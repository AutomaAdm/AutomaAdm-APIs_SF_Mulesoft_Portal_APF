import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL as GLOBAL
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

KeywordLogger log = new KeywordLogger()

def jsonSlurper = new JsonSlurper()

//Se recupera dato desencriptado de API  SalesForce
ResponseObject responseDencrypt = WS.sendRequest(findTestObject('Postman/Transversal/Openshift/Dencrypt/Dencrypt', [('value') : value]))

WS.verifyResponseStatusCode(responseDencrypt, 200)

def JsonResponseDencrypt = jsonSlurper.parseText(responseDencrypt.getResponseText())

//Se recupera dato desencriptado de API  Mulesoft
ResponseObject responseMS_Dencrypt = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Encriptar/QA_MS_Decrypt', [('value') :value ]))

WS.verifyResponseStatusCode(responseMS_Dencrypt, 200)

def JsonResponseMS_Dencrypt = jsonSlurper.parseText(responseMS_Dencrypt.getResponseText())

//Validar Response 
def estatus = WS.verifyEqual(JsonResponseMS_Dencrypt, JsonResponseDencrypt, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI='Dencrypt'

String MSJ = CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)

String vJsonResponseMS_Dencrypt = JsonResponseMS_Dencrypt

String vJsonResponseDencrypt = JsonResponseDencrypt

WS.comment(MSJ)

WS.comment('MS:' + vJsonResponseMS_Dencrypt)

WS.comment('SF:' + vJsonResponseDencrypt)


