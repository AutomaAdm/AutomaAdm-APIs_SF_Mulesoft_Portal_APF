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
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def jsonSlurper = new JsonSlurper()

if (GlobalVariable.STATUSCURP) {
    //Se recupera la respuesta de la API GetLifePackages
    ResponseObject responseGetPackages = WS.sendRequest(findTestObject('Migracion Mulesoft/Salesforce/Vida/GetLifePackages/MS_GetLifePackages'))

	TestObject request=findTestObject('Migracion Mulesoft/Salesforce/Vida/GetLifePackages/MS_GetLifePackages')
	String url = request.getUrl()
	WS.comment(url)
	
	
    WS.verifyResponseStatusCode(responseGetPackages, 200)

    GlobalVariable.RESPONSEPQ = jsonSlurper.parseText(responseGetPackages.getResponseText())

    int pq = Integer.parseInt(pq)

    GlobalVariable.BRANCHCODE = GlobalVariable.RESPONSEPQ.packages[pq].branchCode

    def paquete = GlobalVariable.RESPONSEPQ.packages[pq].name

	GlobalVariable.PQ=paquete
    //Se imprime el paquete seleccionado
    WS.comment('El paquete Seleccinado es: ' + paquete)

    //se recupera el estatus de la validación entre la respesta esperada con la obtenida de  GetLifePackages 
    def status = CustomKeywords.'consultaPaquetes.ValidacionPaquetes.validarPaqueteVida'(GlobalVariable.RESPONSEPQ)

    //Se valida estatus
    if (status) {
        WS.comment('La respuesta de GetLifePackages es la esperada')

        GlobalVariable.STATUSRESTPQ = true
    } else {
        WS.comment('La respesta de GetLifePackages no es la esperada')

        GlobalVariable.STATUSRESTPQ = false
    }
	GlobalVariable.STATUSRESTPQ = true
}



