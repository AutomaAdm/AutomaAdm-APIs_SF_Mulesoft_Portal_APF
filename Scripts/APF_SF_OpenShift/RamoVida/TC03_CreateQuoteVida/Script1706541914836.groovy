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
import generarJsonCotizacion.EstructuraCotizacion as EstructuraCotizacion
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook

def jsonSlurper = new JsonSlurper()



if (GlobalVariable.STATUSRESTPQ) {
    int pq = Integer.parseInt(pq)

    //Le Asignamos los datos (nombre completo, curp, y rfc)que se recuperaron de la api buscarCurp
    BirthDate = GlobalVariable.BIRTHDATE

    RFC = GlobalVariable.RFC

    CURP = GlobalVariable.CURP

    LastName = GlobalVariable.LASTNAME

    FirstName = GlobalVariable.FIRSTNAME

    def jsonCotizacion

    if (GlobalVariable.BRANCHCODE == 'VI47') {

		//Recuperamos el response que de Paquetes de Vida
		def rpPaquete=GlobalVariable.RESPONSEPQ
		int numInstallments=Integer.parseInt(PaymentPeriod)
	
		//Recuperamos el prorrateo del primer pago
		WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC12_GetReceiptsData'), [('price') : rpPaquete.packages[pq].price, ('total') : rpPaquete.packages[pq].price, ('taxAmount') : 0
			, ('priceWithExpense') : 0, ('expense') : 0, ('numInstallments') : numInstallments, ('productCode') :  rpPaquete.packages[pq].code],
		FailureHandling.STOP_ON_FAILURE)
	
		//print(GlobalVariable.PRIMERPAGO)
		
		//Se crea instacia para recuperar el metodo leerJson
        EstructuraCotizacion estructuraJson = new EstructuraCotizacion()

        //Llamar metodo  leerJson que nos regresa el json de cotización
        jsonCotizacion = estructuraJson.leerJson(GlobalVariable.RESPONSEPQ, CURP, FirstName, LastName, RFC, PhoneNumber, 
            Email, BirthDate, Street, ExternalNumber, InternalNumber, City, Country, State, Town, PostalCode, BirthDateBene, 
            FirstNameBene, emailBene, KinshipExternalCodeBene, LastNameBene, PercentageBene, NumBen, StreetBene, ExternalNumberBene, 
            InternalNumberBene, CityBene, CountryBene, StateBene, TownBene, PostalCodeBene, StartDate, EndDate, Bank, CardCVV, 
            PaymentPeriod, TypeOfCard, IsRecurringPayment, CardMonth, CardNumber, CardYear, pq, GlobalVariable.PRIMERPAGO, 
            BirthDateBene2, FirstNameBene2, emailBene2, KinshipExternalCodeBene2, LastNameBene2, PercentageBene2, NumBen2, 
            StreetBene2, ExternalNumberBene2, InternalNumberBene2, CityBene2, CountryBene2, StateBene2, TownBene2, PostalCodeBene2)

        print(jsonCotizacion)
		WebUI.comment(jsonCotizacion)
		GlobalVariable.RQ_QUOTE=jsonCotizacion
    }
    
    ResponseObject responseCreateQuote = WS.sendRequest(findTestObject('Postman/Transversal/CreateQuote for All/CreateQuote', 
            [('jSonCotiVida') : jsonCotizacion]))

    WS.verifyResponseStatusCode(responseCreateQuote, 200)

    def jsonResponseCreateQuote = jsonSlurper.parseText(responseCreateQuote.getResponseText())

    //Se recuperar el quoteId
    GlobalVariable.QUOTEID = jsonResponseCreateQuote.quoteId
}


