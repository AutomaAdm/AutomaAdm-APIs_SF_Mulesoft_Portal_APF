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

//Se recupera el response de la api AnioVehiculos de SF 
ResponseObject responseAnioVehiculo = WS.sendRequest(findTestObject('Postman/Autos/AnioVehiculos/AnioVehiculos', [('codMarca') : codMarca
            , ('codModelo') : codModelo]))

WS.verifyResponseStatusCode(responseAnioVehiculo, 200)

def jsonResponseAnioVehiculo = jsonSlurper.parseText(responseAnioVehiculo.getResponseText())

//Se recupera el response de la api AnioVehiculos de MS
ResponseObject responseMS_AnioVehiculo = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Autos/AnioVehiculos/MS_AnioVehiculos', [('codMarca') : codMarca
            , ('codModelo') : codModelo]))

WS.verifyResponseStatusCode(responseMS_AnioVehiculo, 200)

def jsonResponseMS_AnioVehiculo = jsonSlurper.parseText(responseMS_AnioVehiculo.getResponseText())

def estatus= WS.verifyEqual(jsonResponseMS_AnioVehiculo, jsonResponseAnioVehiculo, FailureHandling.CONTINUE_ON_FAILURE)

String request=""
String nmbreAPI="AnioVehiculos"

String MSJ=CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)

String vJsonResponseMS_GetPackages=jsonResponseMS_AnioVehiculo

String vJsonResponseAnioVehiculo=jsonResponseAnioVehiculo

WS.comment("MS:"+vJsonResponseMS_GetPackages)
WS.comment("SF:"+vJsonResponseAnioVehiculo)

CustomKeywords.'ArchivoExcel.AgregarRespuestaFallida'(nmbreAPI, estatus, codMarca, codModelo, vJsonResponseMS_GetPackages)
