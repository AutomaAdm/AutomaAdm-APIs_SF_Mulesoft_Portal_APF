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
import generarJsonCotizacion.EstructuraAutos as EstructuraAutos
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

EstructuraAutos autos = new EstructuraAutos()

//Se arma reques json para la api de autoRating
def jsonRequestAutoRating = autos.crearJsonAutoRating(TypeVehiculo, Brand, Model, ModelDesc, Year, CodePlan, PostalCode, 
    estadoAseg, estadoCirculacion, municipioAseg, municipioCirculacion, mtoValorComercial)

String request = jsonRequestAutoRating

WS.comment(request)

//Ejecutar Api AutoRating SalesForce
ResponseObject responseAutoRating = WS.sendRequest(findTestObject('Postman/Autos/AutoRating/AutoRating', [('inputjson') : jsonRequestAutoRating]))

WS.verifyResponseStatusCode(responseAutoRating, 200)

def jsonResponseAutoRating = jsonSlurper.parseText(responseAutoRating.getResponseText())

//ejecutar Api AutoRating Mulesoft
ResponseObject responseMS_AutoRating = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Autos/AutoRating/MS_AutoRating', 
        [('inputjson') : jsonRequestAutoRating]))

WS.verifyResponseStatusCode(responseMS_AutoRating, 200)

GlobalVariable.RESPONSEAUTORATING = jsonSlurper.parseText(responseMS_AutoRating.getResponseText())

//Se validan los reponse entre Sf vs MS
def estatus = WS.verifyEqual(GlobalVariable.RESPONSEAUTORATING, jsonResponseAutoRating, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI = 'AutoRating'

String MSJ = CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)

String vJsonMS_ResponseAutoRating = GlobalVariable.RESPONSEAUTORATING

String VJsonResponseAutoRating = jsonResponseAutoRating

WS.comment('MS:' + vJsonMS_ResponseAutoRating)

WS.comment('SF:' + VJsonResponseAutoRating)

CustomKeywords.'ArchivoExcel.AgregarResponse'(nmbreAPI, MSJ, VJsonResponseAutoRating, vJsonMS_ResponseAutoRating, request)

GlobalVariable.STATUSAUTORATING=true

