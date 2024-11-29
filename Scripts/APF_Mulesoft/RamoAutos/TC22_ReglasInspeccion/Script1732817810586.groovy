import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSluper = new JsonSlurper()

int modeloInt=Integer.parseInt(Model)
int yearInt=Integer.parseInt(Year)
//Recuperadon la respuesta de la api ReglaInspeccion
ResponseObject respuestaReglaInspeccion = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Inspeccion Vehicular/sb-ivehicular-apps-proxy', [('codPlan') : CodePlan
            , ('codEstado') : estadoAseg, ('codMunicipio') : municipioAseg, ('codMarcaVehiculo') : Brand, ('codTipoReducido') : modeloInt, ('anioVehiculo') : yearInt
            , ('sumaAsegurada') : mtoValorComercial, ('sessionUser') : CURP]))


//Recuperando la url de la api
TestObject request = findTestObject('Migracion Mulesoft/Openshift/Inspeccion Vehicular/sb-ivehicular-apps-proxy')

String url = request.getUrl()

WS.comment(url)

WS.verifyResponseStatusCode(respuestaReglaInspeccion, 200)

//Recuperando e imprimiendo la respuesta de la api 
GlobalVariable.RQ_REGLA_IV = jsonSluper.parseText(respuestaReglaInspeccion.getResponseText())

String RespuestareglaInsp = GlobalVariable.RQ_REGLA_IV

WS.comment(RespuestareglaInsp)

//Recuperando la respuesta de la api inspeccion
ResponseObject respuestaInspection = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Inspeccion Vehicular/sb-ivr-capps-inspection'))

//Recuperando la url de la api
TestObject request1 = findTestObject('Migracion Mulesoft/Openshift/Inspeccion Vehicular/sb-ivr-capps-inspection')

String url1 = request1.getUrl()

WS.comment(url1)

WS.verifyResponseStatusCode(respuestaInspection, 500)

//Recuperando e imprimiendo la respuesta de la api
def jsonResponseInsp = jsonSluper.parseText(respuestaInspection.getResponseText())

String respuestaInsp = jsonResponseInsp

WS.comment(respuestaInsp)


