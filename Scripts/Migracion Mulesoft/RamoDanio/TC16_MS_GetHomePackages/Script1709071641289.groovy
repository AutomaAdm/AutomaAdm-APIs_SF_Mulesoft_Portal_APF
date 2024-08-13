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
import generarJsonCotizacion.EstructuraCotizacionDanos as EstructuraCotizacionDanos
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()

//Recuperar los paquetes de Daños de la API en SalesForce
ResponseObject responseGetHomePackages = WS.sendRequest(findTestObject('Postman/Danos/GetHomePackages/GetHomePackages', 
        [('rPorcentajeContenidos') : PorcentajeContenidos, ('rAplicaTeev') : AplicaTeev, ('rAplicaContenidos') : AplicaContenidos
            , ('rCodigoPostal') : CodigoPostal, ('rAplicaRcge') : AplicaRcge, ('rAplicaRhmt') : AplicaRhmt, ('rValorInmueble') : ValorInmueble
            , ('rAplicaDmed') : AplicaDmed, ('rAplicaDmrb') : AplicaDmrb, ('rAplicaRhmtR') : AplicaRhmtR, ('rAplicaTeevR') : AplicaTeevR
            , ('rAplicaDmedR') : AplicaDmedR, ('rAplicaRcgeR') : AplicaRcgeR, ('rAplicaDmrbR') : AplicaDmrbR, ('rCodigoPostalR') : CodigoPostalR
            , ('rValorContenidosR') : ValorContenidosR]))

WS.verifyResponseStatusCode(responseGetHomePackages, 200)

def jsonResponseGetHomePackages = jsonSlurper.parseText(responseGetHomePackages.getResponseText())

//Recuperar los paquetes de Daños de la API en Mulesoft
ResponseObject responseMS_GetHomePackages = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Danios/MS_GetHomePackages', [('rPorcentajeContenidos') : PorcentajeContenidos, ('rAplicaTeev') : AplicaTeev, ('rAplicaContenidos') : AplicaContenidos
            , ('rCodigoPostal') : CodigoPostal, ('rAplicaRcge') : AplicaRcge, ('rAplicaRhmt') : AplicaRhmt, ('rValorInmueble') : ValorInmueble
            , ('rAplicaDmed') : AplicaDmed, ('rAplicaDmrb') : AplicaDmrb, ('rAplicaRhmtR') : AplicaRhmtR, ('rAplicaTeevR') : AplicaTeevR
            , ('rAplicaDmedR') : AplicaDmedR, ('rAplicaRcgeR') : AplicaRcgeR, ('rAplicaDmrbR') : AplicaDmrbR, ('rCodigoPostalR') : CodigoPostalR
            , ('rValorContenidosR') : ValorContenidosR]))

WS.verifyResponseStatusCode(responseMS_GetHomePackages, 200)

def jsonResponseMS_GetHomePackages = jsonSlurper.parseText(responseMS_GetHomePackages.getResponseText())

//Validar Response
def estatus = WS.verifyEqual(jsonResponseMS_GetHomePackages, jsonResponseGetHomePackages, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI='GetHomePackages'

String MSJ = CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)

String vjsonResponseMS_GetHomePackages = jsonResponseMS_GetHomePackages

String vjsonResponseGetHomePackages = jsonResponseGetHomePackages

WS.comment(MSJ)

WS.comment('MS:' + vjsonResponseMS_GetHomePackages)

WS.comment('SF:' + vjsonResponseGetHomePackages)
String requestV=""+PorcentajeContenidos+AplicaTeev+ AplicaContenidos + CodigoPostal+ AplicaRcge+ AplicaRhmt+  ValorInmueble+AplicaDmed+  AplicaDmrb+ AplicaRhmtR+ AplicaTeevR+ AplicaDmedR+ AplicaRcgeR+ AplicaDmrbR+   CodigoPostalR+  ValorContenidosR

//CustomKeywords.'ArchivoExcel.AgregarRespuestaFallidaPaquetesDanio'(nmbreAPI, estatus,requestV,vjsonResponseMS_GetHomePackages)

