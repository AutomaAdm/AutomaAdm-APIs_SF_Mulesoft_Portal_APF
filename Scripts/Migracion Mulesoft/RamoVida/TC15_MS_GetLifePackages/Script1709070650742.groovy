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

def jsonSlurper = new JsonSlurper()

//Se recupera la respuesta de la API GetLifePackages de SalesForce
ResponseObject responseGetPackages = WS.sendRequest(findTestObject('Postman/Vida/GetPackages/GetLifePackages'))

WS.verifyResponseStatusCode(responseGetPackages, 200)

def JsonResponseGetPackages = jsonSlurper.parseText(responseGetPackages.getResponseText())

//se recupera el estatus de la validación entre la respuesta esperada con la obtenida de  GetLifePackages 
def status = CustomKeywords.'consultaPaquetes.ValidacionPaquetes.validarPaqueteVida'(JsonResponseGetPackages)

//Se valida estatus
if (status) {
    WS.comment('La respuesta de GetLifePackages es la esperada')

    GlobalVariable.STATUSRESTPQ = true
} else {
    WS.comment('La respesta de GetLifePackages no es la esperada')

    GlobalVariable.STATUSRESTPQ = false
}

//Se recupera la respuesta de la API GetLifePackages de Mulesoft
ResponseObject responseMSGetPackages = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Vida/GetLifePackages/MS_GetLifePackages'))

 WS.verifyResponseStatusCode(responseMSGetPackages, 200)

def JsonResponseMS_GetPackages = jsonSlurper.parseText(responseMSGetPackages.getResponseText())


//Validar Response
def estatusRequest = WS.verifyEqual(JsonResponseMS_GetPackages, JsonResponseGetPackages, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI='GetLifePackages'

String MSJ = CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatusRequest, nmbreAPI)

String vJsonResponseMS_GetPackages = JsonResponseMS_GetPackages

String vJsonResponseGetPackages = JsonResponseGetPackages

WS.comment(MSJ)

WS.comment('MS:' + vJsonResponseMS_GetPackages)

WS.comment('SF:' + vJsonResponseGetPackages)


