package validarCurp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class ValidarResponseCurp {

	@Keyword
	def ValidarCurpIngresado(def jsonResponseGetCurp) {
		int num = 0
		String msjValidacion=""

		//validamos el numero de parametros del json
		for (def item : jsonResponseGetCurp) {
			num += 1
		}

		//Si el numero de parametros es igual a tres quiere decir que el curp no esta registrado
		if (num == 3) {
			msjValidacion=jsonResponseGetCurp.error
			GlobalVariable.STATUSCURP=false
		} else {
			msjValidacion="El curp si se encuentra registrado"
			GlobalVariable.BIRTHDATE=jsonResponseGetCurp.birthDate
			GlobalVariable.RFC=jsonResponseGetCurp.rfc
			GlobalVariable.CURP=jsonResponseGetCurp.curp
			GlobalVariable.LASTNAME=jsonResponseGetCurp.lastName
			GlobalVariable.FIRSTNAME=jsonResponseGetCurp.firstName
			GlobalVariable.STATUSCURP=true
		}
		return msjValidacion
	}
}
