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

WebUI.callTestCase(findTestCase('APF_Mulesoft/TRANSVERSAL/TC01_SearchByCurp'), [('CURP') : CURP], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_Mulesoft/RamoVida/TC13_GetLifeAssessmentQuestions'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_Mulesoft/RamoVida/TC02_GetLifePackages'), [('pq') : pq], FailureHandling.STOP_ON_FAILURE)

//llamar TC Cumulo
WebUI.callTestCase(findTestCase('APF_Mulesoft/RamoVida/TC18_Cumulo'), [('rfc') : GlobalVariable.RFC, ('FirstName') : GlobalVariable.FIRSTNAME
        , ('LastName') : GlobalVariable.LASTNAME, ('sumaAsegurada') : 1500000, ('BirthDate') : GlobalVariable.BIRTHDATE], 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('APF_SF_OpenShift/Envio_PDF_Por_Correo/TC_GenerarEmailTemp'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//Email=GlobalVariable.EMAIL_TEMP
//En el TC CreateQuoteDanos se tiene el TC GetReceiptsData

WebUI.callTestCase(findTestCase('APF_Mulesoft/RamoVida/TC03_CreateQuoteVida'), [('PhoneNumber') : PhoneNumber, ('Email') : Email
        , ('Street') : Street, ('ExternalNumber') : ExternalNumber, ('InternalNumber') : InternalNumber, ('City') : City
        , ('Country') : Country, ('State') : State, ('Town') : Town, ('PostalCode') : PostalCode, ('BirthDateBene') : BirthDateBene
        , ('FirstNameBene') : FirstNameBene, ('emailBene') : emailBene, ('KinshipExternalCodeBene') : KinshipExternalCodeBene
        , ('LastNameBene') : LastNameBene, ('PercentageBene') : PercentageBene,('NumBen') : NumBen ,('StreetBene') : StreetBene, ('ExternalNumberBene') : ExternalNumberBene
        , ('InternalNumberBene') : InternalNumberBene, ('CityBene') : CityBene, ('CountryBene') : CountryBene, ('StateBene') : StateBene
        , ('TownBene') : TownBene, ('PostalCodeBene') : PostalCodeBene, ('StartDate') : StartDate, ('EndDate') : EndDate
        , ('Bank') : Bank, ('CardCVV') : CardCVV, ('PaymentPeriod') : PaymentPeriod, ('TypeOfCard') : TypeOfCard, ('IsRecurringPayment') : IsRecurringPayment
        , ('CardMonth') : CardMonth, ('CardNumber') : CardNumber, ('CardYear') : CardYear, ('pq') : pq, ('BirthDateBene2') : BirthDateBene2
	, ('FirstNameBene2') : FirstNameBene2, ('emailBene2') : emailBene2, ('KinshipExternalCodeBene2') : KinshipExternalCodeBene2
	, ('LastNameBene2') : LastNameBene2, ('PercentageBene2') : PercentageBene2, ('NumBen2') : NumBen2, ('StreetBene2') : StreetBene2
	, ('ExternalNumberBene2') : ExternalNumberBene2, ('InternalNumberBene2') : InternalNumberBene2, ('CityBene2') : CityBene2, ('CountryBene2') : CountryBene2
	, ('StateBene2') : StateBene2, ('TownBene2') : TownBene2, ('PostalCodeBene2') : PostalCodeBene2], FailureHandling.STOP_ON_FAILURE)




WebUI.callTestCase(findTestCase('APF_Mulesoft/TRANSVERSAL/TC23_GenerateKit'), [('CURP') : GlobalVariable.CURP, ('quoteId') : GlobalVariable.QUOTEID], 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('APF_SF_OpenShift/Envio_PDF_Por_Correo/TC_AbrirPDF_Browser'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('APF_Mulesoft/TRANSVERSAL/TC22_Onboarding'), [('CURP') : GlobalVariable.CURP, ('quoteId') : GlobalVariable.QUOTEID], 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('APF_SF_OpenShift/Envio_PDF_Por_Correo/TC_EnvioPDF_PorEmail'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//Validar que se tenga un QuoteId 
if (GlobalVariable.QUOTEID != '') {
    //Se guardan las respuestas del cuestionario
    WebUI.callTestCase(findTestCase('APF_Mulesoft/RamoVida/TC14_SaveLifeAssessmentResponses'), [('quoteId') : GlobalVariable.QUOTEID], 
        FailureHandling.STOP_ON_FAILURE)

    //Generar Emision
    ResponseObject responseEmisionVidaPq1 = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Transversal/Emision/MS_Emision', 
            [('vCurpId') : GlobalVariable.CURP, ('vQuoteId') : GlobalVariable.QUOTEID]))

    println(GlobalVariable.CURP)

    println(GlobalVariable.QUOTEID)

	TestObject request=findTestObject('Migracion Mulesoft/Salesforce/Transversal/Emision/MS_Emision')
	String url = request.getUrl()
	WS.comment(url)
	
    WS.verifyResponseStatusCode(responseEmisionVidaPq1, 200)

    def jsonResponseEmisionVidaPq1 = jsonSlurper.parseText(responseEmisionVidaPq1.getResponseText())

    //Se recupera póliza
    def poliza = jsonResponseEmisionVidaPq1.quoteNumber

    //
    WS.comment('Poliza generada:' + poliza)

     //En el TC Payworks se tiene el TC de Encrypt y Dencrypt
    WebUI.callTestCase(findTestCase('APF_Mulesoft/TRANSVERSAL/TC17_Payworks'), [('CardNumber') : CardNumber, ('FirstName') : GlobalVariable.FIRSTNAME
            , ('LastName') : GlobalVariable.LASTNAME, ('CardCVV') : CardCVV, ('CardMonth') : CardMonth, ('CardYear') : CardYear
            , ('TypeOfCard') : TypeOfCard, ('installmentAmount') : GlobalVariable.PRIMERPAGO, ('BRANCHCODE') : GlobalVariable.BRANCHCODE
            , ('referencia_cliente1') : poliza, ('mode') : 'AUTORIZADA'], FailureHandling.STOP_ON_FAILURE)
	
	String origen="Mulesoft"
	//Se agrega la poliza en archivo excel
	CustomKeywords.'ArchivoExcel.agregarUrlKitVida'(poliza, GlobalVariable.BRANCHCODE,GlobalVariable.PQ, GlobalVariable.URLKIT_PDF, GlobalVariable.RQ_QUOTE, PaymentPeriod,StartDate, origen)
	
}


