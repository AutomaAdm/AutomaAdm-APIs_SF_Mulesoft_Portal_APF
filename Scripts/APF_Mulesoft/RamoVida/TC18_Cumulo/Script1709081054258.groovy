import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.time.LocalDate as LocalDate
import java.time.LocalDateTime as LocalDateTime
import java.time.Period as Period
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

String lastName = LastName

String paterno = lastName.substring(0, lastName.indexOf(' '))

String materno = lastName.substring(lastName.indexOf(' ') + 1)

int edad = CustomKeywords.'CalcularEdad.CalculaEdad'(BirthDate)

ResponseObject responseCumulo = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/Cumulo/QA - MS-Cumulo', [('rfc') : rfc, ('paterno') : paterno
            , ('materno') : materno, ('nombre') : FirstName, ('sumaAsegurada') : sumaAsegurada, ('edad') : edad]))

WS.verifyResponseStatusCode(responseCumulo, 200)

def jsonResponseCumulo = jsonSlurper.parseText(responseCumulo.getResponseText())

def msj = jsonResponseCumulo.codigo_operacion

if (msj == 1) {
    WS.comment('Operacion Exitosa')
} else {
    WS.comment('No fue aprobado la suma asegurada')
}



