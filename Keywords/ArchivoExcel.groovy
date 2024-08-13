import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook



class ArchivoExcel {

	String rootPrj = RunConfiguration.getProjectDir()



	@Keyword
	def AgregarResponse(String api, String msj, String responseSF, String responseMS,String request) {


		String gTestIdPathWay =  rootPrj+"\\Data Files\\Respuesta.xlsx"

		FileInputStream fis = new FileInputStream (gTestIdPathWay);
		XSSFWorkbook workbook = new XSSFWorkbook (fis);

		XSSFSheet sheet = workbook.getSheet(api);


		//Row row = sheet.createRow(1);
		int num=0
		for  ( Object item in   sheet.collect()) {
			//print(item.(1))
			num++
		}

		print ("numerorG"+num)

		Row row = sheet.createRow(num);
		Cell cell = row.createCell(0);

		cell.setCellValue(msj);

		cell = row.createCell(1);

		cell.setCellValue(responseSF);

		cell = row.createCell(2);

		cell.setCellValue(responseMS);

		cell = row.createCell(3);

		cell.setCellValue(request);


		FileOutputStream fos = new FileOutputStream(gTestIdPathWay);
		workbook.write(fos);
		fos.close();
		fis.close();
	}

	@Keyword
	def AgregarRespuestaFallida(String api, boolean estatus, String codMarca, String codModelo,  String response) {
		int bandera=0
		String tipoError=""
		if(estatus) {
			if(response.length()<=2) {
				bandera=1
				tipoError="El response no tiene nodos"
			}
		}
		else {
			bandera=1
			tipoError="No coincide response SF vs MS"
		}

		if(bandera==1) {
			String gTestIdPathWay =  rootPrj+"\\Data Files\\Respuesta.xlsx"

			FileInputStream fis = new FileInputStream (gTestIdPathWay);
			XSSFWorkbook workbook = new XSSFWorkbook (fis);

			XSSFSheet sheet = workbook.getSheet(api);


			//Row row = sheet.createRow(1);
			int num=0
			for  ( Object item in   sheet.collect()) {
				//print(item.(1))
				num++
			}

			//print ("numerorG"+num)

			Row row = sheet.createRow(num);
			Cell cell = row.createCell(0);

			cell.setCellValue(codMarca);

			cell = row.createCell(1);

			cell.setCellValue(codModelo);

			cell = row.createCell(2);

			cell.setCellValue(tipoError);

			FileOutputStream fos = new FileOutputStream(gTestIdPathWay);
			workbook.write(fos);
			fos.close();
			fis.close();
		}
	}

	@Keyword
	def AgregarRespuestaFallidaPaquetesDanio(String api,boolean estatus, String requestV,String response) {
		int bandera=0
		String tipoError=""
		if(estatus) {
			if(response.length()<=2) {
				bandera=1
				tipoError="El response no tiene nodos"
			}
		}
		else {
			bandera=1
			tipoError="No coincide response SF vs MS"
		}

		if(bandera==1) {
			String gTestIdPathWay =  rootPrj+"\\Data Files\\Respuesta.xlsx"

			FileInputStream fis = new FileInputStream (gTestIdPathWay);
			XSSFWorkbook workbook = new XSSFWorkbook (fis);

			XSSFSheet sheet = workbook.getSheet(api);


			//Row row = sheet.createRow(1);
			int num=0
			for  ( Object item in   sheet.collect()) {
				//print(item.(1))
				num++
			}

			//print ("numerorG"+num)

			Row row = sheet.createRow(num);

			Cell cell = row.createCell(0);
			cell.setCellValue(requestV);

			cell = row.createCell(1);
			cell.setCellValue(tipoError);


			FileOutputStream fos = new FileOutputStream(gTestIdPathWay);
			workbook.write(fos);
			fos.close();
			fis.close();
		}
	}

	@Keyword
	def agregarUrlKitVida(def poliza, def branch, def paquete, def urlKit, def Request_Quote, def codFormaPago, def StartDate, def origen) {

		String prod="";
		String formaPago="";

		//		switch (branch) {
		//			case "VI47":
		//				prod="VidaUrlKit"
		//				break;
		//			case "CAHA":
		//				prod="CAHAUrlKit"
		//				break;
		//			case "A003" :
		//				prod="AutoUrlKit"
		//				break;
		//			default:
		//				print("No codigo de producto no existe")
		//		}

		switch (codFormaPago) {
			case "012":
				formaPago="Mensual"
				break;
			case "001":
				formaPago="Anual"
				break;
			default:
				print("No codigo de producto no existe")
		}



		String gTestIdPathWay =  rootPrj+"\\Data Files\\polizas.xlsx"

		FileInputStream fis = new FileInputStream (gTestIdPathWay);
		XSSFWorkbook workbook = new XSSFWorkbook (fis);

		XSSFSheet sheet = workbook.getSheet("VidaUrlKit");


		//Row row = sheet.createRow(1);
		int num=0
		for  ( Object item in   sheet.collect()) {
			//print(item.(1))
			num++
		}

		print ("numerorG"+num)

		Row row = sheet.createRow(num);

		Cell cell = row.createCell(0);

		cell.setCellValue(branch);

		cell = row.createCell(1);

		cell.setCellValue("7J8");

		cell = row.createCell(2);

		cell.setCellValue(poliza);


		cell = row.createCell(3);

		cell.setCellValue(paquete);

		cell = row.createCell(4);

		cell.setCellValue(urlKit);

		cell = row.createCell(5);

		cell.setCellValue(Request_Quote);

		cell = row.createCell(6);

		cell.setCellValue(formaPago);

		cell = row.createCell(7);

		cell.setCellValue(StartDate);
		
		cell = row.createCell(8);
		
		cell.setCellValue(origen);


		FileOutputStream fos = new FileOutputStream(gTestIdPathWay);
		workbook.write(fos);
		fos.close();
		fis.close();
	}


	@Keyword
	def agregarUrlKitAutos(def poliza, def branch,def codigoPlan,def codTipoVehiculo,  def urlKit, def Request_Quote, def Request_AutoRating,def codFormaPago, def fechaEjecucion, def origen ) {

		String plan="";
		String tipoVehiculo="";
		String formaPago="";
		switch (codFormaPago) {
			case "012":
				formaPago="Mensual"
				break;
			case "001":
				formaPago="Anual"
				break;
			default:
				print("No codigo de producto no existe")
		}

		switch (codTipoVehiculo) {
			case "001":
				tipoVehiculo="Auto"
				break;
			case "002":
				tipoVehiculo="PickUp"
				break;
			case "017":
				tipoVehiculo="Moto"
				break;
			default:
				print("No codigo de producto no existe")
		}

		if (codigoPlan=="A03" || codigoPlan=="B03" || codigoPlan=="I01") {
			plan="AMPLIA"
		}
		if(codigoPlan=="A05"|| codigoPlan=="B05" || codigoPlan=="I03" ) {
			plan="LIMITADA"
		}
		if(codigoPlan=="A06" || codigoPlan=="B06" || codigoPlan=="I04") {
			plan="RESPONSABILIDAD CIVIL"
		}

		String gTestIdPathWay =  rootPrj+"\\Data Files\\polizas.xlsx"

		FileInputStream fis = new FileInputStream (gTestIdPathWay);
		XSSFWorkbook workbook = new XSSFWorkbook (fis);

		XSSFSheet sheet = workbook.getSheet("AutoUrlKit");


		//Row row = sheet.createRow(1);
		int num=0
		for  ( Object item in   sheet.collect()) {
			//print(item.(1))
			num++
		}

		print ("numerorG"+num)

		Row row = sheet.createRow(num);

		Cell cell = row.createCell(0);

		cell.setCellValue(branch);

		cell = row.createCell(1);

		cell.setCellValue("7J8");

		cell = row.createCell(2);

		cell.setCellValue(poliza);

		cell = row.createCell(3);

		cell.setCellValue(plan);

		cell = row.createCell(4);

		cell.setCellValue(tipoVehiculo);


		cell = row.createCell(5);

		cell.setCellValue(urlKit);

		cell = row.createCell(6);

		cell.setCellValue(Request_Quote);

		cell = row.createCell(7);

		cell.setCellValue(Request_AutoRating);


		cell = row.createCell(8);

		cell.setCellValue(formaPago);

		cell = row.createCell(9);

		cell.setCellValue(fechaEjecucion);

		cell = row.createCell(10);
		
		cell.setCellValue(origen);

		FileOutputStream fos = new FileOutputStream(gTestIdPathWay);
		workbook.write(fos);
		fos.close();
		fis.close();
	}

	@Keyword
	def agregarUrlKitCAHA(def poliza, def branch,  def pq,def urlKit, def Request_Quote, def codFormaPago, def StartDate, def origen) {

		String plan="";
		String tipoPaquete="";
		String formaPago="";
		switch (codFormaPago) {
			case "012":
				formaPago="Mensual"
				break;
			case "001":
				formaPago="Anual"
				break;
			default:
				print("No codigo de producto no existe")
		}

		switch (pq) {
			case "0":
				tipoPaquete="PROPIO"
				break;
			case "1":
				tipoPaquete="RENTADO"
				break;
			default:
				print("No codigo de producto no existe")
		}


		String gTestIdPathWay =  rootPrj+"\\Data Files\\polizas.xlsx"

		FileInputStream fis = new FileInputStream (gTestIdPathWay);
		XSSFWorkbook workbook = new XSSFWorkbook (fis);

		XSSFSheet sheet = workbook.getSheet("CAHAUrlKit");


		//Row row = sheet.createRow(1);
		int num=0
		for  ( Object item in   sheet.collect()) {
			//print(item.(1))
			num++
		}

		print ("numerorG"+num)

		Row row = sheet.createRow(num);

		Cell cell = row.createCell(0);

		cell.setCellValue(branch);

		cell = row.createCell(1);

		cell.setCellValue("7J8");

		cell = row.createCell(2);

		cell.setCellValue(poliza);


		cell = row.createCell(3);

		cell.setCellValue(tipoPaquete);

		cell = row.createCell(4);

		cell.setCellValue(urlKit);

		cell = row.createCell(5);

		cell.setCellValue(Request_Quote);

		cell = row.createCell(6);

		cell.setCellValue(formaPago);

		cell = row.createCell(6);

		cell.setCellValue(StartDate);
		
		cell = row.createCell(7);
		
		cell.setCellValue(origen);



		FileOutputStream fos = new FileOutputStream(gTestIdPathWay);
		workbook.write(fos);
		fos.close();
		fis.close();
	}
}