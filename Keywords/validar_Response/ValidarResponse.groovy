package validar_Response

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

public class ValidarResponse {

	@Keyword
	def ValidarEstatusResponseMSvsSF (def estatus, String nombreAPI) {
		String statusMSj=""
		if (estatus) {
			WS.comment('Las respuesta de SF y Mulesoft son las mismas para la API:'+nombreAPI)
			statusMSj="Las respuesta de SF  y Mulesoft son las mismas para la API:"+nombreAPI
		} else {
			WS.comment('NO es la misma respuesta de SF vs autoRating para la API:'+nombreAPI)
			statusMSj="NO es la misma respuesta de SF vs Mulesoft para la API:"+nombreAPI
		}
		return statusMSj
	}
	@Keyword
	def ValidarDatosdeRespuestaMSvsSF(String nombreAPI,String datosSf, String  datosMS) {
		String statusMSj
		if (datosSf==datosMS) {
			WS.comment('Las respuesta de SF y Mulesoft son las mismas')
			statusMSj="Las respuesta de SF  y Mulesoft son las mismas"+nombreAPI
		} else {
			WS.comment('NO es la misma respuesta de SF Payworks vs Mulesoft Payworks')
			tatusMSj="NO es la misma respuesta de SF vs Mulesoft para la API"+nombreAPI
		}

		return statusMSj
	}
}
