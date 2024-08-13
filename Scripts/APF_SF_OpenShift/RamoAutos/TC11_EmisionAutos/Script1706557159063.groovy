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

String StartDate=CustomKeywords.'RecuperarFecha.devolverFechaInicio'()
String EndDate=CustomKeywords.'RecuperarFecha.devolverFechaFin'()

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC01_SearchByCurp'), [('CURP') : CURP], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/RamoAutos/TC19_GetAutomakes'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/RamoAutos/TC20_GetAutoModel'), [('codMarca') : Brand], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/RamoAutos/TC21_AnioVehiculo'), [('codMarca') : Brand, ('codModelo') : Model], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/RamoAutos/TC08_GetVehiclesPackages'), [('TypeVehiculo') : TypeVehiculo], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/RamoAutos/TC09_AutoRating'), [('PostalCode') : PostalCode, ('Year') : Year
        , ('Brand') : Brand, ('TypeVehiculo') : TypeVehiculo, ('Model') : Model, ('ModelDesc') : ModelDesc, ('CodePlan') : CodePlan
        , ('mtoValorComercial') : mtoValorComercial, ('estadoAseg') : estadoAseg, ('estadoCirculacion') : estadoCirculacion
        , ('municipioAseg') : municipioAseg, ('municipioCirculacion') : municipioCirculacion], FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('APF_SF_OpenShift/Envio_PDF_Por_Correo/TC_GenerarEmailTemp'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//Email=GlobalVariable.EMAIL_TEMP
//En el CP CreateQuoteAutos se encuentra el TC GetReceiptsData

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/RamoAutos/TC10_CreateQuoteAutos'), [('PhoneNumber') : PhoneNumber, ('Email') : Email
        , ('isDriver') : isDriver, ('FirstNameConductor') : FirstNameConductor, ('LastNameConductor') : LastNameConductor
        , ('PhoneNumberConductor') : PhoneNumberConductor, ('EmailConductor') : EmailConductor, ('Street') : Street, ('ExternalNumber') : ExternalNumber
        , ('InternalNumber') : InternalNumber, ('City') : City, ('Country') : Country, ('State') : State, ('Town') : Town
        , ('PostalCode') : PostalCode, ('StartDate') : StartDate, ('EndDate') : EndDate, ('Bank') : Bank, ('CardCVV') : CardCVV
        , ('PaymentPeriod') : PaymentPeriod, ('TypeOfCard') : TypeOfCard, ('IsRecurringPayment') : IsRecurringPayment, ('CardMonth') : CardMonth
        , ('CardNumber') : CardNumber, ('CardYear') : CardYear, ('Year') : Year, ('Brand') : Brand, ('TypeVehiculo') : TypeVehiculo
        , ('Model') : Model, ('ModelDesc') : ModelDesc, ('CodePlan') : CodePlan, ('mtoValorComercial') : mtoValorComercial
        , ('SerieNumber') : SerieNumber, ('EngineNumber') : EngineNumber, ('NumberPlate') : NumberPlate, ('estadoAseg') : estadoAseg
        , ('estadoCirculacion') : estadoCirculacion, ('municipioAseg') : municipioAseg, ('municipioCirculacion') : municipioCirculacion],
FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC23_GenerateKit'), [('CURP') : GlobalVariable.CURP, ('quoteId') : GlobalVariable.QUOTEID], 
    FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('APF_SF_OpenShift/Envio_PDF_Por_Correo/TC_AbrirPDF_Browser'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC22_Onboarding'), [('CURP') : GlobalVariable.CURP, ('quoteId') : GlobalVariable.QUOTEID], 
    FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('APF_SF_OpenShift/Envio_PDF_Por_Correo/TC_EnvioPDF_PorEmail'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//Validamos, que si el quoteid es diferente de vacío genera la emisión 
if (GlobalVariable.QUOTEID != '') {
    //Generar Emision
    ResponseObject responseEmisionVidaPq1 = WS.sendRequest(findTestObject('Postman/Transversal/Emision/Emision - (new)', 
            [('vCurpId') : GlobalVariable.CURP, ('vQuoteId') : GlobalVariable.QUOTEID]))

    WS.verifyResponseStatusCode(responseEmisionVidaPq1, 200)

    def jsonResponseEmisionVidaPq1 = jsonSlurper.parseText(responseEmisionVidaPq1.getResponseText())

    //Se recupera póliza
    def poliza = jsonResponseEmisionVidaPq1.quoteNumber
    
    //En el TC Payworks se encuentra el TC Encrypt y Dencrypt
    WebUI.callTestCase(findTestCase('APF_SF_OpenShift/TRANSVERSAL/TC17_Payworks'), [('CardNumber') : CardNumber, ('FirstName') : GlobalVariable.FIRSTNAME
            , ('LastName') : GlobalVariable.LASTNAME, ('CardCVV') : CardCVV, ('CardMonth') : CardMonth, ('CardYear') : CardYear
            , ('TypeOfCard') : TypeOfCard, ('installmentAmount') : GlobalVariable.PRIMERPAGO, ('BRANCHCODE') : GlobalVariable.BRANCHCODE
            , ('referencia_cliente1') : poliza, ('mode') : 'AUTORIZADA'], FailureHandling.STOP_ON_FAILURE)

	
	String origen="SaleForce"
	//Se agrega la poliza en archivo excel
	CustomKeywords.'ArchivoExcel.agregarUrlKitAutos'(poliza, GlobalVariable.BRANCHCODE,CodePlan, TypeVehiculo, GlobalVariable.URLKIT_PDF , GlobalVariable.RQ_QUOTE,GlobalVariable.RQ_AUTORATING, PaymentPeriod,StartDate,origen)

	
	}



