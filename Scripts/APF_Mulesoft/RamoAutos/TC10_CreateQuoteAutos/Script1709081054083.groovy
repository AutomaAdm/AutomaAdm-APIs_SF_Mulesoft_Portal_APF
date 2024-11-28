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
import generarJsonCotizacion.EstructuraAutos as EstructuraAutos
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

EstructuraAutos autos = new EstructuraAutos()

if (GlobalVariable.STATUSAUTORATING) {
    //Le Asignamos los datos (nombre completo, curp, y rfc)que se recuperaron de la api buscarCurp
    RFC = GlobalVariable.RFC

    CURP = GlobalVariable.CURP

    LastName = GlobalVariable.LASTNAME

    FirstName = GlobalVariable.FIRSTNAME

    //Recuperamos el response de  autorating
    def RPAutoRating = GlobalVariable.RESPONSEAUTORATING

    int numInstallments = Integer.parseInt(PaymentPeriod)

    //Recuperamos el prorrateo del primer pago 
    WebUI.callTestCase(findTestCase('APF_Mulesoft/TRANSVERSAL/TC12_GetReceiptsData'), [('price') : RPAutoRating.price, ('total') : RPAutoRating.total
            , ('taxAmount') : RPAutoRating.taxAmount, ('priceWithExpense') : RPAutoRating.priceWithExpense, ('expense') : RPAutoRating.expense
            , ('numInstallments') : numInstallments, ('productCode') : CodePlan], FailureHandling.STOP_ON_FAILURE)

    //print(GlobalVariable.PRIMERPAGO)
    //Se crea el json de cotización
    def jsonCotizacion = autos.leerJson(GlobalVariable.RESPONSEAUTORATING, CURP, FirstName, LastName, RFC, PhoneNumber, 
        Email, isDriver,FirstNameConductor, LastNameConductor, PhoneNumberConductor, EmailConductor,
		Street, ExternalNumber, InternalNumber, City, Country, State, Town, PostalCode, SerieNumber, EngineNumber, 
        NumberPlate, Brand, Year, StartDate, EndDate, Bank, CardCVV, PaymentPeriod, TypeOfCard, IsRecurringPayment, CardMonth, 
        CardNumber, CardYear, TypeVehiculo, Model, ModelDesc, CodePlan, GlobalVariable.BRANCHCODE, GlobalVariable.PRIMERPAGO)

    print(jsonCotizacion)
	GlobalVariable.RQ_QUOTE=jsonCotizacion
    //Recuperamos la respesta de la Api CreateQuote
    ResponseObject responseCreateQuote = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Transversal/CreateQuote for All/MS_CreateQuote', [('jSonCotiVida') : jsonCotizacion]))

	TestObject request= findTestObject('Migracion Mulesoft/Salesforce/Transversal/CreateQuote for All/MS_CreateQuote')
	String url = request.getUrl()
	WS.comment(url)
	
    WS.verifyResponseStatusCode(responseCreateQuote, 200)

    def jsonResponseCreateQuote = jsonSlurper.parseText(responseCreateQuote.getResponseText())

    //Se recuperar el quoteId
    GlobalVariable.QUOTEID = jsonResponseCreateQuote.quoteId //print(GlobalVariable.QUOTEID)
}



