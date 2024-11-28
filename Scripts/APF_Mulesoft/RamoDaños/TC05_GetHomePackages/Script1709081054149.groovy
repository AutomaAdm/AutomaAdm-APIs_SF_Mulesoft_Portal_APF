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

if (GlobalVariable.STATUSCURP) {
    //Recuperar los paquetes de Daños 
    ResponseObject responseGetHomePackages = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Danios/MS_GetHomePackages', [('rPorcentajeContenidos') : PorcentajeContenidos, ('rAplicaTeev') : AplicaTeev, ('rAplicaContenidos') : AplicaContenidos
                , ('rCodigoPostal') : CodigoPostal, ('rAplicaRcge') : AplicaRcge, ('rAplicaRhmt') : AplicaRhmt, ('rValorInmueble') : ValorInmueble
                , ('rAplicaDmed') : AplicaDmed, ('rAplicaDmrb') : AplicaDmrb, ('rAplicaRhmtR') : AplicaRhmtR, ('rAplicaTeevR') : AplicaTeevR
                , ('rAplicaDmedR') : AplicaDmedR, ('rAplicaRcgeR') : AplicaRcgeR, ('rAplicaDmrbR') : AplicaDmrbR, ('rCodigoPostalR') : CodigoPostalR
                , ('rValorContenidosR') : ValorContenidosR]))

    
	TestObject request=findTestObject('Migracion Mulesoft/Salesforce/Danios/MS_GetHomePackages')
	String url = request.getUrl()
	WS.comment(url)
	
	
	WS.verifyResponseStatusCode(responseGetHomePackages, 200)

    GlobalVariable.RESPONSEPQ = jsonSlurper.parseText(responseGetHomePackages.getResponseText())

    int pq = Integer.parseInt(pq)
	
    GlobalVariable.BRANCHCODE = GlobalVariable.RESPONSEPQ[pq].branchCode

    def paquete = GlobalVariable.RESPONSEPQ[pq].name
	GlobalVariable.PQ=paquete
    //Se imprime el paquete seleccionado
    WS.comment('El paquete Selecinado es: ' + paquete)

    GlobalVariable.STATUSRESTPQ = true
}



