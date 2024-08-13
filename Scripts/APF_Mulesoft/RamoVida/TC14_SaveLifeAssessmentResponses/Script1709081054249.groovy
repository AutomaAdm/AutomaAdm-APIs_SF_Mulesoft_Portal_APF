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

//Se recupera el questionario de Vida
ResponseObject responseSaveAssess = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Vida/Assessments/SaveLifeAssessmentResponses/MS_SaveLifeAssessmentResponses', 
        [('quoteId') : quoteId]))

WS.verifyResponseStatusCode(responseSaveAssess, 200)

def jsonResponseSaveAssess = jsonSlurper.parseText(responseSaveAssess.getResponseText())

//Se valida estatus
if (quoteId == jsonResponseSaveAssess.quoteId) {
    WS.comment('El quoteId es el mismo que se genero en la cotización')
} else {
    WS.comment('El quoteId NO es el mismo que se genero en la cotización')
}



