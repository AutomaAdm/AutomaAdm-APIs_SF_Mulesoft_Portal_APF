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

String mes=String.valueOf(CardMonth)
String anio=String.valueOf(CardYear)

//metodos que se utilizan para transformar los datos bancarios
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


ResponseObject responsePayworks = WS.sendRequest(findTestObject('Postman/Transversal/Openshift/Payworks/Payworks', [('numero') : datosEncrypt[
            0], ('nombrePropietario') : datosEncrypt[1], ('codigoSeguridad') : datosEncrypt[2], ('fechaExpiracion') : datosEncrypt[
            3], ('tipo_tarjeta') : tipo_tarjeta, ('monto') : installmentAmount, ('referencia') : referencia, ('referencia_cliente1') : referencia_cliente1, ('mode') : mode]))


WS.verifyResponseStatusCode(responsePayworks, 200)

def JsonResponsePayworks = jsonSlurper.parseText(responsePayworks.getResponseText())

String vJsonResponsePayworks=JsonResponsePayworks

WS.comment(vJsonResponsePayworks)

