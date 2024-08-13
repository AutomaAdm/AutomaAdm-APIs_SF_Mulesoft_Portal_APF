package catalogo

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

public class PlanesAutos {

	def autosPquetes (String codPlan, def mtoValorComercial) {
		def inputJson=""
		if (codPlan=="A06" || codPlan=="B06" ) {
			inputJson=[
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "DI",
					"PorcDed": "",
					"SumaAseg": "4000000",
					"CodCobert": "A005",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "50000.00",
					"CodCobert": "A006",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A010",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A009",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				]
			]
		}
		if(codPlan=="A03" || codPlan=="B03") {
			inputJson=[
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "20",
					"SumaAseg": "0",
					"CodCobert": "A002",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "5",
					"SumaAseg": mtoValorComercial,
					"CodCobert": "A004",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "DI",
					"PorcDed": "0",
					"SumaAseg": "4000000",
					"CodCobert": "A005",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "50000.00",
					"CodCobert": "A006",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "0",
					"SumaAseg": "0",
					"CodCobert": "A017",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "0",
					"SumaAseg": "0",
					"CodCobert": "A016",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "3",
					"SumaAseg": mtoValorComercial,
					"CodCobert": "A001",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A014",
					"NumDiasEmi": "30",
					"NumDiasDed": "30"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A015",
					"NumDiasEmi": "15",
					"NumDiasDed": "15"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A010",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A009",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				]
			]
		}
		if(codPlan=="A05" || codPlan=="B05") {
			inputJson=[
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "5",
					"SumaAseg": mtoValorComercial,
					"CodCobert": "A004",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "DI",
					"PorcDed": "0",
					"SumaAseg": "4000000",
					"CodCobert": "A005",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "50000.00",
					"CodCobert": "A006",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "0",
					"SumaAseg": "0",
					"CodCobert": "A017",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A014",
					"NumDiasEmi": "15",
					"NumDiasDed": "15"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A010",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A009",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				]
			]
		}
		return inputJson
	}

	def  motosPaquetes (String codPlan, def mtoValorComercial) {
		def inputJson=""
		if (codPlan=="I04" ) {
			inputJson=[
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "DI",
					"PorcDed": "0",
					"SumaAseg": "4000000",
					"CodCobert": "A005",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "100000.00",
					"CodCobert": "A006",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A010",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A009",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				]
			]
		}
		if(codPlan=="I01") {
			inputJson=[
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "20",
					"SumaAseg": "0",
					"CodCobert": "A002",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "5",
					"SumaAseg": mtoValorComercial,
					"CodCobert": "A004",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "DI",
					"PorcDed": "0",
					"SumaAseg": "4000000",
					"CodCobert": "A005",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "100000.00",
					"CodCobert": "A006",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "3",
					"SumaAseg": mtoValorComercial,
					"CodCobert": "A001",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A010",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A009",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				]
			]
		}
		if(codPlan=="I03") {
			inputJson=[
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "S",
					"TipoDeducible": "PO",
					"PorcDed": "5",
					"SumaAseg": mtoValorComercial,
					"CodCobert": "A004",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "DI",
					"PorcDed": "0",
					"SumaAseg": "4000000",
					"CodCobert": "A005",
					"NumDiasEmi": "0",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "M",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "100000.00",
					"CodCobert": "A006",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A010",
					"NumDiasEmi": "",
					"NumDiasDed": "0"
				],
				[
					"CoberturaSeleccionada": "S",
					"CoberturaVisible": "S",
					"IndCobertOblig": "S",
					"BaseDeducible": "",
					"TipoDeducible": "",
					"PorcDed": "",
					"SumaAseg": "0",
					"CodCobert": "A009",
					"NumDiasEmi": "",
					"NumDiasDed": ""
				]
			]
		}
		return inputJson
	}
}
