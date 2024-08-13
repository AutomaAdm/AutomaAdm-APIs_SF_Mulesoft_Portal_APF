import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.internal.KeywordLoader as KeywordLoader
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

//Se recuperar datos respuesta de Onboarding
ResponseObject responseGenerarKit = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Transversal/GenerateKit/MS_GenerateKit', 
        [('quoteId') : quoteId, ('curpId') : CURP]))

WS.verifyResponseStatusCode(responseGenerarKit, 200)

def jsonResponseGenerarKit = jsonSlurper.parseText(responseGenerarKit.getResponseText())

def vId = jsonResponseGenerarKit.Id

WS.delay(8)

//print(vId)
ResponseObject responseDocumURL =WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Transversal/GetDocumentURL/MS_GetDocumentURL', [('Id') : vId]))

WS.verifyResponseStatusCode(responseDocumURL, 200)

def jsonResponseDocumURL = jsonSlurper.parseText(responseDocumURL.getResponseText())

//print(jsonResponseDocumURL)
vId = jsonResponseDocumURL.publicUrl

//print(vId)
GlobalVariable.URLKIT_PDF = vId

WS.comment(vId)



