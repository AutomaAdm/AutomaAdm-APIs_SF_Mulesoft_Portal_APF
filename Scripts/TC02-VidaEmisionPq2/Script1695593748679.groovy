import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()

//Se consultan los paquetes de Vida
ResponseObject responseGetPackages = WS.sendRequest(findTestObject('Postman/Vida/GetPackages/GetLifePackages'))

WS.verifyResponseStatusCode(responseGetPackages, 200)

def jsonResponseGetPackages = jsonSlurper.parseText(responseGetPackages.getResponseText())

//Datos Paquete 2
double monthlyPrice = jsonResponseGetPackages.packages[pq].monthlyPrice

String branchCode = jsonResponseGetPackages.packages[pq].branchCode

double price = jsonResponseGetPackages.packages[pq].price

String code = jsonResponseGetPackages.packages[pq].code

//Datos Coberturas VI10
String codeCober1 = jsonResponseGetPackages.packages[pq].coverages[0].code

double priceCober1 = jsonResponseGetPackages.packages[pq].coverages[0].price

double insuredAmountCober1 = jsonResponseGetPackages.packages[pq].coverages[0].insuredAmount

String nameCober1 = jsonResponseGetPackages.packages[pq].coverages[0].name

//Datos Coberturas VI33
String codeCober2 = jsonResponseGetPackages.packages[pq].coverages[1].code

double priceCober2 = jsonResponseGetPackages.packages[pq].coverages[1].price

double insuredAmountCober2 = jsonResponseGetPackages.packages[pq].coverages[1].insuredAmount

String nameCober2 = jsonResponseGetPackages.packages[pq].coverages[1].name

//Datos Coberturas VI58
String codeCober3 = jsonResponseGetPackages.packages[pq].coverages[2].code

double priceCober3 = jsonResponseGetPackages.packages[pq].coverages[2].price

double insuredAmountCober3 = jsonResponseGetPackages.packages[pq].coverages[2].insuredAmount

String nameCober3 = jsonResponseGetPackages.packages[pq].coverages[2].name

//Datos Coberturas VI67
String codeCober4 = jsonResponseGetPackages.packages[pq].coverages[3].code

double priceCober4 = jsonResponseGetPackages.packages[pq].coverages[3].price

double insuredAmountCober4 = jsonResponseGetPackages.packages[pq].coverages[3].insuredAmount

String nameCober4 = jsonResponseGetPackages.packages[pq].coverages[3].name

//Datos Coberturas VI00
String codeCober5 = jsonResponseGetPackages.packages[pq].coverages[4].code

double priceCober5 = jsonResponseGetPackages.packages[pq].coverages[4].price

double insuredAmountCober5 = jsonResponseGetPackages.packages[pq].coverages[4].insuredAmount

String nameCober5 = jsonResponseGetPackages.packages[pq].coverages[4].name

//Datos Coberturas VI95
String codeCober6 = jsonResponseGetPackages.packages[pq].coverages[5].code

double priceCober6 = jsonResponseGetPackages.packages[pq].coverages[5].price

double insuredAmountCober6 = jsonResponseGetPackages.packages[pq].coverages[5].insuredAmount

String nameCober6 = jsonResponseGetPackages.packages[pq].coverages[5].name
//cotización
ResponseObject responseCreateQuote = WS.sendRequest(findTestObject('null',
		[('rCURP') : CURP, ('rFirstName') : FirstName, ('rLastName') : LastName, ('rRFC') : RFC, ('rPhoneNumber') : PhoneNumber
			, ('rEmail') : Email, ('rBirthDate') : BirthDate, ('rStreet') : Street, ('rExternalNumber') : ExternalNumber
			, ('rInternalNumber') : InternalNumber, ('rCity') : City, ('rCountry') : Country, ('rState') : State, ('rTown') : Town
			, ('rPostalCode') : PostalCode, ('rBirthDateBene') : BirthDateBene, ('rFirstNameBene') : FirstNameBene, ('rEmailBene') : emailBene
			, ('rKinshipExternalCode') : KinshipExternalCodeBene, ('rLastNameBene') : LastNameBene, ('rPercentage') : PercentageBene
			, ('rStreetBene') : StreetBene, ('rExternalNumberBene') : ExternalNumberBene, ('rInternalNumberBene') : InternalNumberBene
			, ('rCityBene') : CityBene, ('rCountryBene') : CountryBene, ('rStateBene') : StateBene, ('rTownBene') : TownBene
			, ('rPostalCodeBene') : PostalCodeBene, ('rStartDate') : StartDate, ('rEndDate') : EndDate, ('rCode1') : codeCober1
			, ('rPrice1') : priceCober1, ('rInsuredAmount1') : insuredAmountCober1, ('rName1') : nameCober1, ('rCode2') : codeCober2
			, ('rPrice2') : priceCober2, ('rInsuredAmount2') : insuredAmountCober2, ('rName2') : nameCober2, ('rCode3') : codeCober3
			, ('rPrice3') : priceCober3, ('rInsuredAmount3') : insuredAmountCober3, ('rName3') : nameCober3, ('rCode4') : codeCober4
			, ('rPrice4') : priceCober4, ('rInsuredAmount4') : insuredAmountCober4, ('rName4') : nameCober4, ('rCode5') : codeCober5
			, ('rPrice5') : priceCober5, ('rInsuredAmount5') : insuredAmountCober5, ('rName5') : nameCober5, ('rCode6') : codeCober6
			, ('rPrice6') : priceCober6, ('rInsuredAmount6') : insuredAmountCober6, ('rName6') : nameCober6, ('rBank') : Bank
			, ('rCardCVV') : CardCVV, ('rFirstNameBan') : FirstNameBan, ('rLastNameBan') : LastNameBan, ('rPaymentPeriod') : PaymentPeriod
			, ('rTypeOfCard') : TypeOfCard, ('rAmount') : Amount, ('rIsRecurringPayment') : IsRecurringPayment, ('rCardMonth') : CardMonth
			, ('rCardNumber') : CardNumber, ('rCardYear') : CardYear]))

WS.verifyResponseStatusCode(responseCreateQuote, 200)

def jsonResponseCreateQuote = jsonSlurper.parseText(responseCreateQuote.getResponseText())

//Cotizacion  Paquete 2
String quoteId = jsonResponseCreateQuote.quoteId

println(quoteId)

//Emision paquete 2 

ResponseObject responseEmisionVidaPq1=WS.sendRequest(findTestObject('Postman/Transversal/Emision/Emision - (new)', [('vCurpId') : CURP, ('vQuoteId') : quoteId]))

WS.verifyResponseStatusCode(responseEmisionVidaPq1, 200)

def jsonResponseEmisionVidaPq1 = jsonSlurper.parseText(responseEmisionVidaPq1.getResponseText())

String poliza=jsonResponseEmisionVidaPq1.quoteNumber

println(poliza)