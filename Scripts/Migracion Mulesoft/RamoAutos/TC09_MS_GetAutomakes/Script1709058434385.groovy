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
import consultaPaquetes.ValidacionPaquetes as ValidacionPaquetes
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

//Se recuperan las marcas de los Vehiculo APIS SalesForce
ResponseObject responseGetAutomakes = WS.sendRequest(findTestObject('Postman/Autos/GetAutomakes/GetAutomakes'))

WS.verifyResponseStatusCode(responseGetAutomakes, 200)

def jsonResponseGetAutomakes = jsonSlurper.parseText(responseGetAutomakes.getResponseText())

ValidacionPaquetes marcasAutos = new ValidacionPaquetes()

//Se valida con el response esperado vs generado desde la api de SF 
def estatus = marcasAutos.ValidarMarcasAutos(jsonResponseGetAutomakes)

if (estatus) {
	WS.comment('La respuesta de la api es la esperada')
} else {
	WS.comment('NO corresponde la respuesta con la esperada')
}


//Se recuperan las marcas de los Vehiculo APIS SalesForce
ResponseObject responseMSGetAutomakes = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Autos/GetAutomakes/MS_GetAutomakes'))


WS.verifyResponseStatusCode(responseMSGetAutomakes, 200)

def jsonMSResponseGetAutomakes = jsonSlurper.parseText(responseMSGetAutomakes.getResponseText())

def estatusRequest= WS.verifyEqual(jsonMSResponseGetAutomakes, jsonResponseGetAutomakes, FailureHandling.CONTINUE_ON_FAILURE)


String nmbreAPI="GetAutomakes"

String MSJ=CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatusRequest, nmbreAPI)

String vjsonMSResponseGetAutomakes=jsonMSResponseGetAutomakes

String vjsonResponseGetAutomakes=jsonResponseGetAutomakes
WS.comment(MSJ)
WS.comment("MS:"+vjsonMSResponseGetAutomakes)
WS.comment("SF:"+vjsonResponseGetAutomakes)

