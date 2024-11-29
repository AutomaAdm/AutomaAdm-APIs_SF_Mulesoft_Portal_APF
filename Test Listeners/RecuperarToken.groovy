import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.annotations.BeforeTest

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class RecuperarToken {

	private void setToken() {
		
		def jsonSlurper = new JsonSlurper()
		
		
		switch (GlobalVariable.AMBIENTE) {
			
			case "QA":
			
				//Recuperar token SalesForce
				ResponseObject responseTokenSF = WS.sendRequest(findTestObject('Postman/token/Token_SF_QA'))
				
				
				TestObject request=findTestObject('Migracion Mulesoft/Openshift/TokenInstitucional/Token Institucional')
				String url = request.getUrl()
				WS.comment(url)
				WS.verifyResponseStatusCode(responseTokenSF, 200)
				
				
				
				def jsonResponseTokenSF = jsonSlurper.parseText(responseTokenSF.getResponseText())
				
				GlobalVariable.TOKEN = ('Bearer ' + jsonResponseTokenSF.access_token)
				
				GlobalVariable.HOST="https://segbanortesfi--qa.sandbox.my.salesforce.com"
				GlobalVariable.HOSTNAME_MULESOFT="https://mule-entornos.segurosbanorte.com/sb-ipa-capps-qa-proxy"                                
				print(GlobalVariable.TOKEN)
				KeywordUtil.logInfo('Token: ' + GlobalVariable.TOKEN)
				
				//Recuperar token Openshift
				//ResponseObject responseTokenOpenshift = WS.sendRequest(findTestObject('Postman/token/QA - Generación Token Institucional'))
				ResponseObject responseTokenOpenshift = WS.sendRequest(findTestObject('Migracion Mulesoft/Openshift/TokenInstitucional/Token Institucional'))
				WS.verifyResponseStatusCode(responseTokenOpenshift, 200)
				
				def jsonResponseTokenOpenshift = jsonSlurper.parseText(responseTokenOpenshift.getResponseText())
				
				GlobalVariable.TOKEN_INSTITU = ('Bearer ' + jsonResponseTokenOpenshift.access_token)
				
				print(GlobalVariable.TOKEN_INSTITU)
				
				//Proxy Openshift
				GlobalVariable.HOST_CUMULO_MULE="https://mule-entornos.segurosbanorte.com/syp-arq-capps-cumulo-qa-proxy"
				GlobalVariable.HOST_CRYPT_MULE="https://mule-entornos.segurosbanorte.com/syp-arq-capps-encrypt-qa-proxy"
			    GlobalVariable.HOST_PAYWORKS_MULE="https://mule-entornos.segurosbanorte.com/syp-arq-capps-payworks-qa-proxy"
				GlobalVariable.HOST_REGLAINSPECTION="https://mule-entornos.segurosbanorte.com/sb-ivehicular-apps-qa-proxy"
			break;
			case "PRE":
			
				 ResponseObject responseTokenSF = WS.sendRequest(findTestObject('Postman/token/Token_SF_PRE'))
				
				WS.verifyResponseStatusCode(responseTokenSF, 200)
				
				def jsonResponseTokenSF = jsonSlurper.parseText(responseTokenSF.getResponseText())
				
				GlobalVariable.TOKEN = ('Bearer ' + jsonResponseTokenSF.access_token)
				
				GlobalVariable.HOST="https://segbanortesfi--preprod.sandbox.my.salesforce.com"
				
				print(GlobalVariable.TOKEN)
				
				KeywordUtil.logInfo('Token: ' + GlobalVariable.TOKEN)
				
				//Recuperar token Openshift
				ResponseObject responseTokenOpenshift = WS.sendRequest(findTestObject('Postman/token/QA - Generación Token Institucional'))
				
				WS.verifyResponseStatusCode(responseTokenOpenshift, 200)
				
				def jsonResponseTokenOpenshift = jsonSlurper.parseText(responseTokenOpenshift.getResponseText())
				
				GlobalVariable.TOKEN_INSTITU = ('Bearer ' + jsonResponseTokenOpenshift.access_token)
				
				print(GlobalVariable.TOKEN_INSTITU)
				
			 break;
			
			default:
			 	print("No se encontro la api para ese ambiente")
		  }
		

		
	}

	@BeforeTestCase
	def recuperarToken() {
		
		setToken()
	}
	
	@BeforeTestSuite
	def recuperarToken2() {
		setToken()
	}
}

