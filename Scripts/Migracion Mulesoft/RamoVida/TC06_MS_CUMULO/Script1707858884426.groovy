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

String lastName = LastName

String paterno = lastName.substring(0, lastName.indexOf(' '))
print(paterno)
String materno = lastName.substring(lastName.indexOf(' ') + 1)
print(materno)
int edad = CustomKeywords.'CalcularEdad.CalculaEdad'(BirthDate)
println(edad)
//Api de Openshift
ResponseObject responseCumulo = WS.sendRequest(findTestObject('Postman/Vida/Cumulo/Cumulo', [('rfc') : rfc, ('paterno') : paterno
            , ('materno') : materno, ('nombre') : FirstName, ('sumaAsegurada') : sumaAsegurada, ('edad') : edad]))


WS.verifyResponseStatusCode(responseCumulo, 200, FailureHandling.CONTINUE_ON_FAILURE)

def jsonResponseCumulo = jsonSlurper.parseText(responseCumulo.getResponseText())

def msj = jsonResponseCumulo.codigo_operacion

//Api MuleSoft
ResponseObject responseMS_Cumulo = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Cumulo/QA - MS-Cumulo', [
            ('rfc') : rfc, ('paterno') : paterno, ('materno') : materno, ('nombre') : FirstName, ('sumaAsegurada') : sumaAsegurada
            , ('edad') : edad]))


WS.verifyResponseStatusCode(responseMS_Cumulo, 200, FailureHandling.CONTINUE_ON_FAILURE)

def jsonResponseMS_Cumulo = jsonSlurper.parseText(responseMS_Cumulo.getResponseText())

def estatus = WS.verifyEqual(jsonResponseCumulo, jsonResponseMS_Cumulo)

String nmbreAPI="Cumulo"
String request=""
//Se toma mensaje de acuerdo a la validacion de los response de SF vs MS
String MSJ=CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)


String VresponseCumulo= jsonResponseCumulo
String VresponseMS_Cumulo= jsonResponseMS_Cumulo

WS.comment(VresponseCumulo)

WS.comment(VresponseMS_Cumulo)

//Se agrega los reponse de MS y SF , nombre de la api y msj de validación
CustomKeywords.'ArchivoExcel.AgregarResponse'(nmbreAPI, MSJ, VresponseCumulo, VresponseMS_Cumulo,request)


