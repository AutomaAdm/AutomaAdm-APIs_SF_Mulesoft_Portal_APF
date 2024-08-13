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

//API SF Se recuperar datos relacionados al curp
ResponseObject responseGetCurp = WS.sendRequest(findTestObject('Postman/Transversal/SearchByCurp/SearchByCurp', [('curp') : CURP]))

WS.verifyResponseStatusCode(responseGetCurp, 200)

def jsonResponseGetCurp = jsonSlurper.parseText(responseGetCurp.getResponseText())

//API MS Se recuperar datos relacionados al curp
ResponseObject responseMS_GetCurp = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Transversal/SearchByCurp/MS_SearchByCurp', [('curp') : CURP]))

String request=""
WS.verifyResponseStatusCode(responseMS_GetCurp, 200)

def jsonResponseMS_GetCurp = jsonSlurper.parseText(responseMS_GetCurp.getResponseText())


def estatus= WS.verifyEqual(jsonResponseMS_GetCurp, jsonResponseGetCurp, FailureHandling.CONTINUE_ON_FAILURE)

String nmbreAPI="SearchByCurp"

String MSJ=CustomKeywords.'validar_Response.ValidarResponse.ValidarEstatusResponseMSvsSF'(estatus, nmbreAPI)


String vJsonResponseMS_GetCurp=jsonResponseMS_GetCurp

String vJsonResponseGetCurp=jsonResponseGetCurp

WS.comment("MS:"+vJsonResponseMS_GetCurp)
WS.comment("SF:"+vJsonResponseGetCurp)

CustomKeywords.'ArchivoExcel.AgregarResponse'(nmbreAPI, MSJ, vJsonResponseGetCurp, vJsonResponseMS_GetCurp,request)


int num = 0

//validamos el numero de parametros del json
for (def item : jsonResponseGetCurp) {
    num += 1
}

//Si el numero de parametros es igual a tres quiere decir que el curp no esta registrado
if (num == 3) {
    WS.comment(jsonResponseMS_GetCurp.error)

    GlobalVariable.STATUSCURP = false
} else {
    WS.comment('El curp si se encuentra registrado')

    GlobalVariable.BIRTHDATE = jsonResponseMS_GetCurp.birthDate

    GlobalVariable.RFC = jsonResponseMS_GetCurp.rfc

    GlobalVariable.CURP = jsonResponseMS_GetCurp.curp

    GlobalVariable.LASTNAME = jsonResponseMS_GetCurp.lastName

    GlobalVariable.FIRSTNAME = jsonResponseMS_GetCurp.firstName

    GlobalVariable.STATUSCURP = true
}


