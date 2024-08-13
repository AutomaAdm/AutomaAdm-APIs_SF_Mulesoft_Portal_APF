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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

//Se recuperar la respuesta de GetReceiptsData
ResponseObject responseGetReceiptsData = WS.sendRequest(findTestObject('Postman/Transversal/GetReceiptsData/GetReceiptsData', [('price') : price, ('total') : total
            , ('taxAmount') : taxAmount, ('priceWithExpense') : priceWithExpense, ('expense') : expense, ('numInstallments') : numInstallments, ('productCode') : productCode]))

WS.verifyResponseStatusCode(responseGetReceiptsData, 200)

def jsonResponseGetReceiptsData = jsonSlurper.parseText(responseGetReceiptsData.getResponseText())

GlobalVariable.PRIMERPAGO= jsonResponseGetReceiptsData.installmentAmount

WS.comment("Primer Pago:"+GlobalVariable.PRIMERPAGO)