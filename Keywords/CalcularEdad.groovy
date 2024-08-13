import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.LocalDate

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

public class CalcularEdad {

	@Keyword
	def CalculaEdad(String BirthDate) {

		String fechaNacimiento=BirthDate

		String ano=fechaNacimiento.substring(0, 4)
		int ano1=Integer.parseInt(ano)
		String mes=fechaNacimiento.substring(5,7)
		int mes1=Integer.parseInt(mes)
		String dia=fechaNacimiento.substring(8,10)
		int dia1=Integer.parseInt(dia)

		String fechaActual=LocalDate.now()
		String year=fechaActual.substring(0, 4)
		int year1=Integer.parseInt(year)
		String month=fechaActual.substring(5,7)
		int month1=Integer.parseInt(month)
		String day=fechaActual.substring(8,10)
		int day1=Integer.parseInt(day)

		def edad=0
		print(mes1+"_"+month1)
		if(mes1<month1) {
			edad=year1-ano1
		}
		else {
			if(mes1==month1) {
				if(dia1<=day1) {
					edad=year1-ano1
				}else {
					edad=(year1-ano1)-1
				}
			}
			else {
				edad=(year1-ano1)-1
			}
		}
		//print(edad)
		return edad
	}
}
