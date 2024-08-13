package catalogo

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White

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

public class TipoTarjeta {
	@Keyword
	def DescripTarjeta(String idTarjeta) {
		if(idTarjeta=="04")
			return "CREDITO"
		if(idTarjeta=="03") {
			return "DEBITO"
		}
	}

	@Keyword
	def ConcatenarMesAnio(String mes2, String anio2) {

		anio2=anio2.substring(2)
		String mesAnio=mes2+anio2
		return mesAnio
	}

	@Keyword
	def DescripProducto(String branchCode) {
		switch(branchCode) {
			case "VI47":
				return "Vida"
				break;
			case "CAHA":
				return "Daños"
				break;
			case "A003":
				return "Autos"
				break;
		}
	}
}
