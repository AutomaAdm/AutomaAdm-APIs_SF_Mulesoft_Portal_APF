package generarJsonCotizacion

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

import catalogo.PlanesAutos
import groovy.json.JsonOutput
import groovy.json.StringEscapeUtils
import internal.GlobalVariable

public class EstructuraAutos {



	def crearJsonAutoRating (def TypeVehiculo, def Brand, def Model, def ModelDesc, def Year, def CodePlan, def PostalCode,def estadoAseg,def estadoCirculacion,def municipioAseg,def municipioCirculacion, def mtoValorComercial) {

		def coverages=""

		def input_1=[
			"autoDriver.Gender": "M",
			"autoVehicle.Type": TypeVehiculo,
			"autoVehicle.Model": Model,
			"autoVehicle.ModelDesc": ModelDesc,
			"autoVehicle.Year": Year,
			"autoVehicle.Make": Brand,
			"codePlan": CodePlan,
			"cp":PostalCode,
			"estadoAseg": estadoAseg,
			"estadoCirculacion": estadoCirculacion,
			"municipioAseg": municipioAseg,
			"municipioCirculacion": municipioCirculacion
		]

		//print(tipoVehiculo)
		PlanesAutos planAuto= new PlanesAutos()
		//Se valida el tipo de vehículo
		if (TypeVehiculo=="001" || TypeVehiculo=="002" ) {
			//Se recupera el json con las coberturas de acuerdo al tipo de vehículo
			coverages=planAuto.autosPquetes(CodePlan,mtoValorComercial)
		}
		if (TypeVehiculo=="017") {
			//Se recupera el json con las coberturas de acuerdo al tipo de vehículo
			coverages=planAuto.motosPaquetes(CodePlan, mtoValorComercial)
		}
		def inputJson=[
			"input_1":input_1,
			"coverages":coverages
		]


		def formattedJson = JsonOutput.prettyPrint(JsonOutput.toJson(inputJson)) // Se formatea el JSON

		return formattedJson
	}

	def leerJson(def outputJsn, def CURP, def FirstName, def LastName, def RFC, def PhoneNumber, def Email, def isDriver,
			def FirstNameConductor, def LastNameConductor, def PhoneNumberConductor, def EmailConductor,
			def Street, def ExternalNumber, def InternalNumber, def City,
			def Country, def State, def Town, def PostalCode, def  SerieNumber, def EngineNumber, def NumberPlate,def Brand, def Year,
			def StartDate, def EndDate, def Bank, def CardCVV, def PaymentPeriod, def TypeOfCard, def IsRecurringPayment, def CardMonth, def CardNumber, def CardYear, def TypeVehiculo,
			def Model, def ModelDesc, def CodePlan, def branch, def primerPago) {



		/*
		 * Se comienza creación del JSON que se enviara en el POST
		 * Step1, Step2 y Step3 van a leer datos del excel, ya que son datos del cliente
		 * o si tienes un servicio que traiga datos del cliente, tambien lo puedes llamar para llenar el JSON
		 *
		 */

		//print(outputJsn)
		def step1= []
		if(isDriver==true) {
			step1 = [
				"CURP": CURP,
				"FirstName": FirstName,
				"LastName": LastName,
				"RFC": RFC,
				"PhoneNumber": PhoneNumber,
				"Email": Email ,
				"isDriver":isDriver,
				"Driver": [
					"FirstName": FirstName,
					"LastName": LastName,
					"PhoneNumber": PhoneNumber,
					"Email": Email
				]
			]
		}
		else {
			step1 = [
				"CURP": CURP,
				"FirstName": FirstName,
				"LastName": LastName,
				"RFC": RFC,
				"PhoneNumber": PhoneNumber,
				"Email": Email ,
				"isDriver":isDriver,
				"Driver": [
					"FirstName": FirstNameConductor,
					"LastName": LastNameConductor,
					"PhoneNumber": PhoneNumberConductor,
					"Email": EmailConductor
				]
			]
		}


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
			"VehicleInformation": [
				"SerieNumber": SerieNumber,
				"EngineNumber": EngineNumber,
				"NumberPlate": NumberPlate,
				"Brand": Brand,
				"Year": Year,
				"Model": Model,
				"ModelDesc": ModelDesc,
				"Type": TypeVehiculo,
				"PostalCode": PostalCode,
				"isParticular": true,
				"AcceptanceInformation": true,
				"AcceptanceLaw": true
			]
		]



		def responseAutoRating = outputJsn // Se leen todas las coberturas del Json



		def step4 = [
			"Package": [
				"branch": branch,
				"Code": CodePlan,
				"StartDate": StartDate,
				"EndDate":EndDate,
				"Amount": responseAutoRating.price,
				"total": responseAutoRating.total,
				"taxAmount": responseAutoRating.taxAmount,
				"priceWithExpense":responseAutoRating.priceWithExpense,
				"expense": responseAutoRating.expense,
				"numInstallments": PaymentPeriod,
				"expenseOnFirstInstallment": false,
				"installmentAmount": primerPago,
				"PorcRecaDctoVol": responseAutoRating.package.PorcRecaDctoVol,
				"PorcRecaDctoEarnix": responseAutoRating.package.PorcRecaDctoEarnix,
				"MtoRecaDctoEarnix": responseAutoRating.package.MtoRecaDctoEarnix,
				"CodRecaDctoBE": responseAutoRating.package.CodRecaDctoBE,
				"CodRecaDctoDis": responseAutoRating.package.CodRecaDctoDis,
				"CodRecaDctoEarnix": responseAutoRating.package.CodRecaDctoEarnix,
				"CodRecaDctoVol": responseAutoRating.package.CodRecaDctoVol,
				"PorcRecaDctoBE": responseAutoRating.package.PorcRecaDctoBE,
				"PorcRecaDctoDis": responseAutoRating.package.PorcRecaDctoDis,
				"TipoRecaDctoBE": responseAutoRating.package.TipoRecaDctoBE,
				"TipoRecaDctoDis": responseAutoRating.package.TipoRecaDctoDis,
				"TipoRecaDctoEarnix": responseAutoRating.package.TipoRecaDctoEarnix,
				"TipoRecaDctoVol": responseAutoRating.package.TipoRecaDctoVol
			],
			"PackageCoverage": responseAutoRating.package.coverages.collect {
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"insuredAmount": String.valueOf(it.SumaAsegurada),
					"code": it.CodCobert,
					"price": it.MtoPrimaCob,
					"PorcDed": String.valueOf(it.PorcDed)
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

		//print(outputJson)

		def formattedJson = JsonOutput.prettyPrint(JsonOutput.toJson(outputJson)) // Se formatea el JSON
		def formattedJson2= StringEscapeUtils.unescapeJavaScript(JsonOutput.prettyPrint(JsonOutput.toJson(outputJson)))
		return  formattedJson2
	}

	def tipoVehiculo (def typeVehiculo) {
		String tpoVehiculo=""
		if(typeVehiculo=="001") {
			tpoVehiculo= "Auto"
		}
		if(typeVehiculo=="002") {
			tpoVehiculo= "Pickup"
		}
		if(typeVehiculo=="017") {
			tpoVehiculo= "Moto"
		}

		return tpoVehiculo
	}
}
