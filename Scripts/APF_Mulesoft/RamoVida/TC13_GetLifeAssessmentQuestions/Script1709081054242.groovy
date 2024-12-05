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
ResponseObject responseQuestions = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Vida/Assessments/GetLifeAssessmenQuestions/GetLifeAssessmenQuestions'))

TestObject request=findTestObject('Migracion Mulesoft/Salesforce/Vida/Assessments/GetLifeAssessmenQuestions/GetLifeAssessmenQuestions')
String url = request.getUrl()
WS.comment(url)


WS.verifyResponseStatusCode(responseQuestions, 200)

def jsonResponseQuestions = jsonSlurper.parseText(responseQuestions.getResponseText())

print(responseQuestions.getResponseText())

print(jsonResponseQuestions)

//se recupera el estatus de la validación entre la respesta esperada con la obtenida de  GetLifeAssessmentQuestions
//def status = CustomKeywords.'consultaPaquetes.ValidacionPaquetes.validarCuestionario'(jsonResponseQuestions)
//
////Se valida estatus
//if (status) {
//    WS.comment('El cuestionario es el esperado')
//
//    GlobalVariable.STATUSRESTPQ = true
//} else {
//    WS.comment('El cuestionario no coincide con el esperado')
//
//    GlobalVariable.STATUSRESTPQ = false
//}



