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

import internal.GlobalVariable
import groovy.json.JsonSlurper
import groovy.json.StringEscapeUtils
import groovy.json.JsonOutput

public class EstructuraCotizacion {


	//def inputJson = new File('C://Users//JRobertoMV//Downloads//GetLifePackages.json').text

	def leerJson(def outputJsn, def CURP, def FirstName, def LastName, def RFC, def PhoneNumber, def Email, def BirthDate, def Street, def ExternalNumber, def InternalNumber, def City,
			def Country, def State, def Town, def PostalCode, def  BirthDateBene, def FirstNameBene, def emailBene, def KinshipExternalCodeBene,def LastNameBene, def PercentageBene, def NumBen, def StreetBene,
			def  ExternalNumberBene, def InternalNumberBene, def CityBene, def CountryBene, def StateBene, def TownBene, def PostalCodeBene, def StartDate, def EndDate, def Bank, def CardCVV,
			def PaymentPeriod, def TypeOfCard, def IsRecurringPayment, def CardMonth, def CardNumber, def CardYear, def pq,def primerPago,
			def BirthDateBene2, def FirstNameBene2, def emailBene2, def KinshipExternalCodeBene2, def LastNameBene2, def PercentageBene2, def NumBen2,def StreetBene2, def ExternalNumberBene2,
			def InternalNumberBene2, def CityBene2, def CountryBene2, def StateBene2, def TownBene2, def PostalCodeBene2) {

		/*
		 * Se comienza creación del JSON que se enviara en el POST
		 * Step1, Step2 y Step3 van a leer datos del excel, ya que son datos del cliente
		 * o si tienes un servicio que traiga datos del cliente, tambien lo puedes llamar para llenar el JSON
		 *
		 */
		print("Si entra al metodo")
		def input=outputJsn
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
		def beneficiaryInfo= []

		if(BirthDateBene2!='' && FirstNameBene2!='') {

			def beneficiaryInfo1 =[
				"BirthDate": BirthDateBene,
				"FirstName": FirstNameBene,
				"email": emailBene,
				"KinshipExternalCode": KinshipExternalCodeBene,
				"LastName": LastNameBene,
				"Percentage": PercentageBene,
				"NumBen": NumBen,
				"Address": [
					"Street": StreetBene,
					"ExternalNumber":ExternalNumberBene,
					"InternalNumber": InternalNumberBene,
					"City": CityBene,
					"Country": CountryBene,
					"State": StateBene,
					"Town": TownBene,
					"PostalCode": PostalCodeBene
				]
			]

			def beneficiaryInfo2 =[
				"BirthDate": BirthDateBene2,
				"FirstName": FirstNameBene2,
				"email": emailBene2,
				"KinshipExternalCode": KinshipExternalCodeBene2,
				"LastName": LastNameBene2,
				"Percentage": PercentageBene2,
				"NumBen": NumBen2,
				"Address": [
					"Street": StreetBene2,
					"ExternalNumber":ExternalNumberBene2,
					"InternalNumber": InternalNumberBene2,
					"City": CityBene2,
					"Country": CountryBene2,
					"State": StateBene2,
					"Town": TownBene2,
					"PostalCode": PostalCodeBene2
				]
			]

			def beneficiarys = [
				beneficiaryInfo1,
				beneficiaryInfo2
			]

			beneficiaryInfo =beneficiarys.collect {
				[
					"BirthDate": it.BirthDate,
					"FirstName": it.FirstName,
					"email": it.email,
					"KinshipExternalCode": it.KinshipExternalCode,
					"LastName": it.LastName,
					"Percentage": it.Percentage,
					"NumBen": it.NumBen,
					"Address": [
						"Street": it.Address.Street,
						"ExternalNumber":it.Address.ExternalNumber,
						"InternalNumber": it.Address.InternalNumber,
						"City": it.Address.City,
						"Country": it.Address.Country,
						"State": it.Address.State,
						"Town": it.Address.Town,
						"PostalCode": it.Address.PostalCode
					]
				]
			}
		}
		else {
			beneficiaryInfo =collect {
				[
					"BirthDate": BirthDateBene,
					"FirstName": FirstNameBene,
					"email": emailBene,
					"KinshipExternalCode": KinshipExternalCodeBene,
					"LastName": LastNameBene,
					"Percentage": PercentageBene,
					"NumBen": NumBen,
					"Address": [
						"Street": StreetBene,
						"ExternalNumber":ExternalNumberBene,
						"InternalNumber": InternalNumberBene,
						"City": CityBene,
						"Country": CountryBene,
						"State": StateBene,
						"Town": TownBene,
						"PostalCode": PostalCodeBene
					]
				]
			}
		}

		def step3 = ["BenificiaryInformation": beneficiaryInfo]

		def lifePackages = input.packages // Se leen todas las coberturas del Json

		def selectedPackage = lifePackages[pq] // Puedes cambiar el índice para seleccionar una cobertura diferente

		def step4 = [
			"Package": [
				"branch": selectedPackage.branchCode,
				"Code": selectedPackage.code,
				"StartDate": StartDate,
				"EndDate": EndDate,
				"Amount": selectedPackage.price,
				"total": selectedPackage.price,
				"taxAmount": 0,
				"priceWithExpense": selectedPackage.price,
				"expense": 0,
				"numInstallments": PaymentPeriod,
				"expenseOnFirstInstallment": false,
				"installmentAmount": primerPago
			],
			"PackageCoverage": selectedPackage.coverages.collect {
				[
					"code": it.code,
					"price": it.price,
					"insuredAmount": it.insuredAmount,
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
		def formattedJson= StringEscapeUtils.unescapeJavaScript(JsonOutput.prettyPrint(JsonOutput.toJson(outputJson)))
		return  formattedJson
	}
}
