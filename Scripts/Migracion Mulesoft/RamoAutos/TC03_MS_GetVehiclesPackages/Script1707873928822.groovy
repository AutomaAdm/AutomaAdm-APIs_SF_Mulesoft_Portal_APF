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

//Consultar Tipo de Vehiculo (Moto, Pickup y Auto)
def tipoVehicu = autos.tipoVehiculo(TypeVehiculo)

//Se recuperan los paquetes por Vehiculo api SF 
ResponseObject responseGetPackages = WS.sendRequest(findTestObject('Postman/Autos/GetVehiclePackage/GetVehiclesPackages', 
        [('vehiculo') : tipoVehicu]))

WS.verifyResponseStatusCode(responseGetPackages, 200)

String request=""

def jsonResponseGetPackages = jsonSlurper.parseText(responseGetPackages.getResponseText())

//Se recuperan los paquetes por Vehiculo api Mulesoft
ResponseObject responseMS_GetPackages =WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Autos/GetVehiclePackage/MS_GetVehiclePackage', [('vehiculo') : tipoVehicu]))

WS.verifyResponseStatusCode(responseMS_GetPackages, 200)

def jsonResponseMS_GetPackages = jsonSlurper.parseText(responseMS_GetPackages.getResponseText())


def estatus= WS.verifyEqual(jsonResponseMS_GetPackages, jsonResponseGetPackages, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI="GetVehiclesPackages"

String MSJ=CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)


String vJsonResponseMS_GetPackages=jsonResponseMS_GetPackages

String vJsonResponseGetPackages=jsonResponseGetPackages

WS.comment("MS:"+vJsonResponseMS_GetPackages)
WS.comment("SF:"+vJsonResponseGetPackages)

CustomKeywords.'ArchivoExcel.AgregarResponse'(nmbreAPI, MSJ, vJsonResponseMS_GetPackages, vJsonResponseGetPackages,request)
