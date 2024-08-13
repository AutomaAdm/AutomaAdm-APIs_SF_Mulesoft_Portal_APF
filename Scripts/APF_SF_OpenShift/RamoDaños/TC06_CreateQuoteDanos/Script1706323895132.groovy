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
import generarJsonCotizacion.EstructuraCotizacionDanos as EstructuraCotizacionDanos
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()


if (GlobalVariable.STATUSRESTPQ) {
	
    int pq = Integer.parseInt(pq)

    //Le Asignamos los datos (nombre completo, curp, y rfc)que se recuperaron de la api buscarCurp
    BirthDate = GlobalVariable.BIRTHDATE

    RFC = GlobalVariable.RFC

    CURP = GlobalVariable.CURP

    LastName = GlobalVariable.LASTNAME

    FirstName = GlobalVariable.FIRSTNAME
	
	//Recuperamos el response que de Paquetes de Daños
	def rpPaquete=GlobalVariable.RESPONSEPQ
	int numInstallments=Integer.parseInt(PaymentPeriod)
	
	//Recuperamos el prorrateo del primer pago
	WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC12_GetReceiptsData'), [('price') : rpPaquete[pq].price, ('total') : rpPaquete[pq].total, ('taxAmount') : rpPaquete[pq].taxAmount
		, ('priceWithExpense') : rpPaquete[pq].priceWithExpense, ('expense') : rpPaquete[pq].expense, ('numInstallments') : numInstallments, ('productCode') :  rpPaquete[pq].productCode],
	FailureHandling.STOP_ON_FAILURE)

	//print(GlobalVariable.PRIMERPAGO)
	
    //Se crea instacia para mandar a llamar el metodo leerJson
    EstructuraCotizacionDanos jsonDanos = new EstructuraCotizacionDanos()

    //Recuperamos el Json de cotización Danos
    def jsonCotizacion = jsonDanos.leerJson(GlobalVariable.RESPONSEPQ, CURP, FirstName, LastName, RFC, PhoneNumber, Email, 
        BirthDate, Street, ExternalNumber, InternalNumber, City, Country, State, Town, PostalCode, Value, ContentsInsuredAmount, 
        Levels, BuildingAge, MarDistance, StartDate, EndDate, Bank, CardCVV, PaymentPeriod, TypeOfCard, IsRecurringPayment, 
        CardMonth, CardNumber, CardYear, pq,GlobalVariable.PRIMERPAGO)

	WebUI.comment(jsonCotizacion)
	GlobalVariable.RQ_QUOTE=jsonCotizacion
    //Recuperamos la respesta de la Api CreateQuote
    ResponseObject responseCreateQuote = WS.sendRequest(findTestObject('Postman/Transversal/CreateQuote for All/CreateQuote', 
            [('jSonCotiVida') : jsonCotizacion]))

    WS.verifyResponseStatusCode(responseCreateQuote, 200)

    def jsonResponseCreateQuote = jsonSlurper.parseText(responseCreateQuote.getResponseText())

    //Se recuperar el quoteId
    GlobalVariable.QUOTEID = jsonResponseCreateQuote.quoteId //print(GlobalVariable.QUOTEID)
}