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

KeywordLogger log = new KeywordLogger()

def jsonSlurper = new JsonSlurper()

//Se recupera dato encriptado API Sales Force
ResponseObject responseEncrypt = WS.sendRequest(findTestObject('Postman/Transversal/Openshift/Encrypt/Encrypt', [('value') : value]))

WS.verifyResponseStatusCode(responseEncrypt, 200)

def JsonResponseEncrypt = jsonSlurper.parseText(responseEncrypt.getResponseText())

GlobalVariable.VALUE_ENCRYP = JsonResponseEncrypt.value

//WS.comment(encrip)
//Se recupera dato encriptado API MuleSoft
ResponseObject responseMS_Encrypt = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Encriptar/QA_MS_Encrpt', [('value') : value]))

WS.verifyResponseStatusCode(responseMS_Encrypt, 200)

def JsonMS_ResponseEncrypt = jsonSlurper.parseText(responseMS_Encrypt.getResponseText())

//Validar Response
def estatus = WS.verifyEqual(JsonMS_ResponseEncrypt, JsonResponseEncrypt, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI='Encriptar'

String MSJ = CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)

String vJsonMS_ResponseEncrypt = JsonMS_ResponseEncrypt

String vJsonResponseEncrypt = JsonResponseEncrypt

WS.comment(MSJ)

WS.comment('MS:' + vJsonMS_ResponseEncrypt)

WS.comment('SF:' + vJsonResponseEncrypt)



