import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.time.LocalDateTime as LocalDateTime
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.internal.KeywordLoader as KeywordLoader
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

KeywordLogger log = new KeywordLogger()

def jsonSlurper = new JsonSlurper()

//metodos que se utilizan para transformar los datos bancarios
String mes=String.valueOf(CardMonth)
String anio=String.valueOf(CardYear)
String fechaExpiracion = CustomKeywords.'catalogo.TipoTarjeta.ConcatenarMesAnio'(mes, anio)

String tipo_tarjeta = CustomKeywords.'catalogo.TipoTarjeta.DescripTarjeta'(TypeOfCard)

String refere = CustomKeywords.'catalogo.TipoTarjeta.DescripProducto'(BRANCHCODE)

String fechaHora = LocalDateTime.now()

String referencia = refere + fechaHora

def datosBan = [CardNumber + '', (FirstName + ' ') + LastName, CardCVV, fechaExpiracion]

def datosDencrypt = []

def datosEncrypt = []

//Se encriptan los datos bancarios
for (def item : datosBan) {
    println(item)

    //Llamada al TC Encriptar
    WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC15_Encrypt'), [('value') : item], FailureHandling.STOP_ON_FAILURE)

    //llenar lista con los datos bancarios encriptados
    datosEncrypt.add(GlobalVariable.VALUE_ENCRYP)

    //Lamada al TC Desencriptar
    WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC16_Dencrypt'), [('value') : GlobalVariable.VALUE_ENCRYP], FailureHandling.STOP_ON_FAILURE)

    //llenar lista con los datos bancarios desencriptados
    datosDencrypt.add(GlobalVariable.VALUE_ENCRYP)
}

//Se valida si la lista original es igual a la lista desencriptada
def validar = datosBan.equals(datosDencrypt)

if (validar) {
    WS.comment('La lista desencriptada es igual a la lista Original')
} else {
    WS.comment('NO son iguales las listas')
}


//API Payworks de SF 
ResponseObject responsePayworks = WS.sendRequest(findTestObject('Postman/Transversal/Openshift/Payworks/Payworks', [('numero') : datosEncrypt[
            0], ('nombrePropietario') : datosEncrypt[1], ('codigoSeguridad') : datosEncrypt[2], ('fechaExpiracion') : datosEncrypt[
            3], ('tipo_tarjeta') : tipo_tarjeta, ('monto') : installmentAmount, ('referencia') : referencia, ('referencia_cliente1') : referencia_cliente1
            , ('mode') : mode]))

WS.verifyResponseStatusCode(responsePayworks, 200)

def JsonResponsePayworks = jsonSlurper.parseText(responsePayworks.getResponseText())

//Recuperamos datos del repose payworks SF
String estado=JsonResponsePayworks.autorizacion.estado
String monto =JsonResponsePayworks.autorizacion.monto
String aprobado =JsonResponsePayworks.autorizacion.aprobado
String datosSf=estado+monto+aprobado

//Generar referencia
refere = CustomKeywords.'catalogo.TipoTarjeta.DescripProducto'(BRANCHCODE)

fechaHora = LocalDateTime.now()

referencia = refere + fechaHora

//API Payworks de Mulesoft
ResponseObject responseMS_Payworks = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Payworks Payment Process/QA - MS_Payworks', [('numero') : datosEncrypt[
            0], ('nombrePropietario') : datosEncrypt[1], ('codigoSeguridad') : datosEncrypt[2], ('fechaExpiracion') : datosEncrypt[3], ('tipo_tarjeta') : tipo_tarjeta, ('monto') : installmentAmount
            , ('referencia') : referencia, ('referencia_cliente1') : referencia_cliente1, ('mode') : mode]))

WS.verifyResponseStatusCode(responseMS_Payworks, 200)

def JsonResponseMS_Payworks = jsonSlurper.parseText(responseMS_Payworks.getResponseText())

//def estatus=WS.verifyEqual(JsonResponseMS_Payworks, JsonResponsePayworks, FailureHandling.CONTINUE_ON_FAILURE)

//Recuperamos datos del repose de Payworks Mulesoft
String estadoMS=JsonResponseMS_Payworks.autorizacion.estado
String montoMS =JsonResponseMS_Payworks.autorizacion.monto
String aprobadoMS =JsonResponseMS_Payworks.autorizacion.aprobado
String datosMS=estadoMS+montoMS+aprobadoMS

String nmbreAPI="Payworks"
String request=""
//Validación si son iguales las respuestas de los servicios
def MSJ=CustomKeywords.'validar_Response.ValidarResponse.ValidarDatosdeRespuestaMSvsSF'(nmbreAPI, datosSf, datosMS)

String VresponsePayworks= JsonResponsePayworks
String VresponseMS_Payworks= JsonResponseMS_Payworks

WS.comment(VresponsePayworks)

WS.comment(VresponseMS_Payworks)

//Guardar en archivo exce nomre de la api, estatus de validacion de datos MS vs SF y response 
CustomKeywords.'ArchivoExcel.AgregarResponse'(nmbreAPI, MSJ, VresponsePayworks, VresponseMS_Payworks,request)
