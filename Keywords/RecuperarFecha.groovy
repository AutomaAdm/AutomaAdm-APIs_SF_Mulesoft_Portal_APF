import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

//import java.sql.Date
import java.text.SimpleDateFormat

import org.glassfish.grizzly.http.server.util.SimpleDateFormats

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

public class RecuperarFecha {

	@Keyword
	def  devolverFechaInicio() {
		Calendar fecha= Calendar.getInstance()

		String anio=fecha.get(Calendar.YEAR)
		String mes = fecha.get(Calendar.MONTH)+1;
		String dia = fecha.get(Calendar.DAY_OF_MONTH);
		if(mes.length()<2) {
			mes='0'+mes
		}
		if(dia.length()<2) {
			dia='0'+dia
		}
		return anio+'-'+mes+"-"+dia
	}

	@Keyword
	def  devolverFechaFin() {

		Calendar fecha= Calendar.getInstance()

		String anio=fecha.get(Calendar.YEAR)+1
		String mes = fecha.get(Calendar.MONTH)+1;
		String dia = fecha.get(Calendar.DAY_OF_MONTH);
		if(mes.length()<2) {
			mes='0'+mes
		}
		if(dia.length()<2) {
			dia='0'+dia
		}
		return anio+'-'+mes+"-"+dia
	}
	
	@Keyword
	def  devolverFechaEjecucion() {
		Date  fecha= new Date()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String fechaActual = sdf.format(fecha);
		return fechaActual
	}
	
}
