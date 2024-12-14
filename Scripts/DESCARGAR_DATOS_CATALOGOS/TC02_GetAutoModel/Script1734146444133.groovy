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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.ArrayUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import consultaPaquetes.ValidacionPaquetes as ValidacionPaquetes
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable

import org.apache.commons.lang.ArrayUtils
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

//Se recuperan los modelos del id de codigo de marca
ResponseObject responseGetAutomakes = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Autos/GetAutoModel/MS_GetAutoModel', [('codMarca') : codMarca]))

TestObject request=findTestObject('Migracion Mulesoft/Salesforce/Autos/GetAutoModel/MS_GetAutoModel')
String url = request.getUrl()
WS.comment(url)



WS.verifyResponseStatusCode(responseGetAutomakes, 200)

def jsonResponseGetAutomakes = jsonSlurper.parseText(responseGetAutomakes.getResponseText())

CustomKeywords.'ArchivoExcel.exportarDatosModel'(codMarca, jsonResponseGetAutomakes)





