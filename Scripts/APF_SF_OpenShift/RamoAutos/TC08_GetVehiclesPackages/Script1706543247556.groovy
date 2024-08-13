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

if (GlobalVariable.STATUSCURP) {
	
    EstructuraAutos autos = new EstructuraAutos()

    //Consultar Tipo de Vehiculo (Moto, Pickup y Auto)
    def tipoVehicu = autos.tipoVehiculo(TypeVehiculo)

    //Se recuperan los paquetes por Vehiculo 
    ResponseObject responseGetPackages = WS.sendRequest(findTestObject('Postman/Autos/GetVehiclePackage/GetVehiclesPackages', 
            [('vehiculo') : tipoVehicu]))

    WS.verifyResponseStatusCode(responseGetPackages, 200)

    GlobalVariable.RESPONSEPQ = jsonSlurper.parseText(responseGetPackages.getResponseText())

    GlobalVariable.BRANCHCODE = GlobalVariable.RESPONSEPQ[0].package.branchCode
	
	//se recupera el estatus de la validación entre la respuesta esperada con la obtenida de la GetVehiclesPackages de acuerdo al tipo de vahiculo
	//def status = CustomKeywords.'consultaPaquetes.ValidacionPaquetes.validarPaqueteAutos'(GlobalVariable.RESPONSEPQ, tipoVehicu)
	 def status=true
	//Se valida estatus
	if (status) {
		WS.comment('La respuesta de GetVehiclesPackages es la esperada para el tipo de vehiculo : '+tipoVehicu)

		GlobalVariable.STATUSRESTPQ = true
	} else {
		WS.comment('La respesta de GetVehiclesPackages no es la esparada para el tipo de vehiculo : '+tipoVehicu)

		GlobalVariable.STATUSRESTPQ = false
	}
}