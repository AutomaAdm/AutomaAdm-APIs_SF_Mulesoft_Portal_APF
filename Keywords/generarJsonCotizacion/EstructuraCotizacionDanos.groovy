package generarJsonCotizacion

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.supercsv.cellprocessor.ParseDouble

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
import groovy.json.JsonSlurper
import groovy.json.StringEscapeUtils
import groovy.json.JsonOutput
import groovy.json.JsonParser

public class EstructuraCotizacionDanos {

	def jsonSlurper = new JsonSlurper()

	def leerJson(def outputJsn, def CURP, def FirstName, def LastName, def RFC, def PhoneNumber, def Email, def BirthDate, def Street, def ExternalNumber, def InternalNumber, def City,
			def Country, def State, def Town, def PostalCode, def  Value, def ContentsInsuredAmount, def Levels,def BuildingAge, def MarDistance,
			def StartDate, def EndDate, def Bank, def CardCVV, def PaymentPeriod, def TypeOfCard, def IsRecurringPayment, def CardMonth, def CardNumber, def CardYear, def pq, def primerPago) {

		/*
		 * Se comienza creación del JSON que se enviara en el POST
		 * Step1, Step2 y Step3 van a leer datos del excel, ya que son datos del cliente
		 * o si tienes un servicio que traiga datos del cliente, tambien lo puedes llamar para llenar el JSON
		 *
		 */

		def input=outputJsn

		print(input)

		def step1 = [
			"CURP": CURP,
			"FirstName": FirstName,
			"LastName": LastName,
			"RFC": RFC,
			"PhoneNumber": PhoneNumber,
			"Email": Email ,
			"BirthDate": BirthDate
		]

		def step2 = [
			"Address": [
				"Street": Street,
				"ExternalNumber": ExternalNumber,
				"InternalNumber": InternalNumber,
				"City": City,
				"Country": Country,
				"State": State,
				"Town": Town,
				"PostalCode": PostalCode
			]
		]

		def step3 = [
			"BuildingInformation":[
				"Address":[
					"Street": Street,
					"ExternalNumber": ExternalNumber,
					"InternalNumber": InternalNumber,
					"City": City,
					"Country":Country,
					"State": State,
					"Town": Town,
					"PostalCode": PostalCode
				],
				"Value": Value,
				"ContentsInsuredAmount": ContentsInsuredAmount,
				"Levels": Levels,
				"BuildingAge": BuildingAge,
				"MarDistance": MarDistance
			],
			"ContentsInformation": [
				"Value": Value
			]
		]



		def DanosPackages = input // Se leen todas las coberturas del Json

		def selectedPackage = DanosPackages[pq] // Puedes cambiar el índice para seleccionar una cobertura diferente


		def step4 = [
			"Package": [
				"branch": selectedPackage.branchCode,
				"Code": selectedPackage.productCode,
				"StartDate": StartDate,
				"EndDate": EndDate,
				"Amount": selectedPackage.price,
				"total": selectedPackage.total,
				"taxAmount": selectedPackage.taxAmount,
				"priceWithExpense": selectedPackage.priceWithExpense,
				"expense": selectedPackage.expense,
				"numInstallments": PaymentPeriod,
				"expenseOnFirstInstallment": false,
				"installmentAmount": primerPago
			],
			"PackageCoverage": selectedPackage.coverages.collect {
				[
					"code": it.code,
					"price": it.price,
					"insuredAmount":Double.parseDouble(it.sumaAsegurada.replace(',', '')),
					"name": it.name
				]
			}
		]

		def step5 = [ //Segun yo estos datos tambien los vas a extraer del Excel a excepcion del Amount
			"Bank": Bank,
			"CardCVV": CardCVV,
			"FirstName": FirstName,
			"LastName": LastName,
			"PaymentPeriod": PaymentPeriod,
			"TypeOfCard": TypeOfCard,
			"Amount": primerPago,
			"IsRecurringPayment": IsRecurringPayment,
			"CardMonth": CardMonth,
			"CardNumber": CardNumber,
			"CardYear": CardYear
		]

		//Se devuelve el JSON creado para el post
		def outputJson = [
			"Step1": step1,
			"Step2": step2,
			"Step3": step3,
			"Step4": step4,
			"Step5": step5
		]



		//def formattedJson = JsonOutput.prettyPrint(JsonOutput.toJson(outputJson)) // Se formatea el JSON
		def formattedJson2= StringEscapeUtils.unescapeJavaScript(JsonOutput.prettyPrint(JsonOutput.toJson(outputJson)))
		return  formattedJson2
	}

	def formatearDato(def campo) {
		String dato = campo
		dato.replace(",", "")
		int suumaAsegurada1= Integer.parseInt(dato)
		print(suumaAsegurada1)
		return  suumaAsegurada1
	}
}
