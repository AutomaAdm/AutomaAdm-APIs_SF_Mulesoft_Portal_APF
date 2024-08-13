import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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



if (GlobalVariable.STATUSRESTPQ) {
    def inputJsonAutoRating = autos.crearJsonAutoRating(TypeVehiculo, Brand, Model, ModelDesc, Year, CodePlan, PostalCode, 
        estadoAseg, estadoCirculacion, municipioAseg, municipioCirculacion, mtoValorComercial)

    print(inputJsonAutoRating)
	
	GlobalVariable.RQ_AUTORATING=inputJsonAutoRating

    //Ejecutar Api AutoRating
    ResponseObject responseAutoRating = WS.sendRequest(findTestObject('Postman/Autos/AutoRating/AutoRating', [('inputjson') : inputJsonAutoRating]))

    WS.verifyResponseStatusCode(responseAutoRating, 200)

    GlobalVariable.RESPONSEAUTORATING = jsonSlurper.parseText(responseAutoRating.getResponseText())
	
	GlobalVariable.STATUSAUTORATING=true
	
}



