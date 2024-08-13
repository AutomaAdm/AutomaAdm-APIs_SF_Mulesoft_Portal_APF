package consultaPaquetes

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

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class ValidacionPaquetes {



	@Keyword
	def  static validarPaqueteVida(def responseVida){
		def jsonSlurper = new JsonSlurper()
		def paqueteVida="""
			{
		    "packages": [
		        {
		            "coverages": [
		                {
		                    "price": 250.0,
		                    "name": "Muerte Accidental",
		                    "isOptional": false,
		                    "insuredAmount": 500000.0,
		                    "code": "VI10"
		                },
		                {
		                    "price": 433.0,
		                    "name": "Indemnización Hospitalaria por Accidente",
		                    "isOptional": false,
		                    "insuredAmount": 50000,
		                    "code": "VI58"
		                },
		                {
		                    "price": 1370.6,
		                    "name": "INDEMNIZACIÓN DIARIA POR HOSPITALIZACIÓN",
		                    "isOptional": false,
		                    "insuredAmount": 2500,
		                    "code": "VI67"
		                },
		                {
		                    "price": 1925.0,
		                    "name": "Incapacidad Total o Incapacidad Permanente Total o Invalidez",
		                    "isOptional": false,
		                    "insuredAmount": 500000,
		                    "code": "VI33"
		                },
		                {
		                    "price": 4065.0,
		                    "name": "FALLECIMIENTO",
		                    "isOptional": false,
		                    "insuredAmount": 500000.0,
		                    "code": "VI00"
		                },
		                {
		                    "price": 653.0,
		                    "name": "ENFERMEDADES GRAVES",
		                    "isOptional": false,
		                    "insuredAmount": 100000.0,
		                    "code": "VI95"
		                }
		            ],
		            "price": 8696.6,
		            "name": "SEGURO de VIDA INDIVIDUAL APF PAQUETE 1",
		            "monthlyPrice": 724.72,
		            "code": "SEGURO_VI_APF1_ROOT",
		            "branchCode": "VI47",
		            "EdadMin": "18",
		            "EdadMax": "70"
		        },
		        {
		            "coverages": [
		                {
		                    "price": 500.0,
		                    "name": "Muerte Accidental",
		                    "isOptional": false,
		                    "insuredAmount": 1000000.0,
		                    "code": "VI10"
		                },
		                {
		                    "price": 866.0,
		                    "name": "Indemnización Hospitalaria por Accidente",
		                    "isOptional": false,
		                    "insuredAmount": 100000,
		                    "code": "VI58"
		                },
		                {
		                    "price": 2741.2,
		                    "name": "INDEMNIZACIÓN DIARIA POR HOSPITALIZACIÓN",
		                    "isOptional": false,
		                    "insuredAmount": 5000,
		                    "code": "VI67"
		                },
		                {
		                    "price": 3850.0,
		                    "name": "Incapacidad Total o Incapacidad Permanente Total o Invalidez",
		                    "isOptional": false,
		                    "insuredAmount": 1000000,
		                    "code": "VI33"
		                },
		                {
		                    "price": 8130.0,
		                    "name": "FALLECIMIENTO",
		                    "isOptional": false,
		                    "insuredAmount": 1000000.0,
		                    "code": "VI00"
		                },
		                {
		                    "price": 1306.0,
		                    "name": "ENFERMEDADES GRAVES",
		                    "isOptional": false,
		                    "insuredAmount": 200000.0,
		                    "code": "VI95"
		                }
		            ],
		            "price": 17393.2,
		            "name": "SEGURO de VIDA INDIVIDUAL APF PAQUETE 2",
		            "monthlyPrice": 1449.43,
		            "code": "SEGURO_VI_APF2_ROOT",
		            "branchCode": "VI47",
		            "EdadMin": "18",
		            "EdadMax": "70"
		        },
		        {
		            "coverages": [
		                {
		                    "price": 750.0,
		                    "name": "Muerte Accidental",
		                    "isOptional": false,
		                    "insuredAmount": 1500000.0,
		                    "code": "VI10"
		                },
		                {
		                    "price": 1299.0,
		                    "name": "Indemnización Hospitalaria por Accidente",
		                    "isOptional": false,
		                    "insuredAmount": 150000,
		                    "code": "VI58"
		                },
		                {
		                    "price": 4111.8,
		                    "name": "INDEMNIZACIÓN DIARIA POR HOSPITALIZACIÓN",
		                    "isOptional": false,
		                    "insuredAmount": 7500,
		                    "code": "VI67"
		                },
		                {
		                    "price": 5775.0,
		                    "name": "Incapacidad Total o Incapacidad Permanente Total o Invalidez",
		                    "isOptional": false,
		                    "insuredAmount": 1500000,
		                    "code": "VI33"
		                },
		                {
		                    "price": 12195.0,
		                    "name": "FALLECIMIENTO",
		                    "isOptional": false,
		                    "insuredAmount": 1500000.0,
		                    "code": "VI00"
		                },
		                {
		                    "price": 1959.0,
		                    "name": "ENFERMEDADES GRAVES",
		                    "isOptional": false,
		                    "insuredAmount": 300000.0,
		                    "code": "VI95"
		                }
		            ],
		            "price": 26089.8,
		            "name": "SEGURO de VIDA INDIVIDUAL APF PAQUETE 3",
		            "monthlyPrice": 2174.15,
		            "code": "SEGURO_VI_APF3_ROOT",
		            "branchCode": "VI47",
		            "EdadMin": "18",
		            "EdadMax": "70"
		        }
		    ]
		}
		"""
		def RespuestaEsparada = jsonSlurper.parseText(paqueteVida)
		//def status= WS.verifyMatch(responseVida, RespuestaEsparada, false, FailureHandling.CONTINUE_ON_FAILURE)
		def status = WS.verifyEqual(responseVida, RespuestaEsparada, FailureHandling.CONTINUE_ON_FAILURE)
		return status
	}

	@Keyword
	def static validarCuestionario(def responseQuizz) {
		def jsonSlurper = new JsonSlurper()
		def cuestionario="""
			{
			    "question": [
			        {
			            "apiName": "preexisting_diseases",
			            "dataType": "Checkbox",
			            "text": "Declaro que cuento con buena salud, sin haber padecido enfermedades preexistentes, ni realizar ocupaciones y/o actividades de alto riesgo",
			            "tooltips": [
			                {
			                    "message": "Declaro de manera voluntaria y libre, bajo protesta de decir verdad que, en los últimos dos años anteriores a la fecha de firma de la presente declaración: NO padezco 0 he padecido, ni me han diagnosticado, ni tampoco he recibido tratamiento médico y/o quirúrgico por Vfermedades del corazón, hipertensión arterial, pulmones, sistema nervioso, cerebro, esófago, estómago, riñones, hígado, vesícula biliar, próstata, convulsiones, parálisis, paraplejía, cáncer, tumores malignos, leucemia, lupus, diabetes, 0 en general alguna enfermedad grave, afección o lesión grave que ponga en riesgo su vida o la funcionalidad de algún órgano o sistema y NO tengo programada alguna cirugía para los próximos 3 meses, que implique hospitalización de más de 72 horas NO me encuentro en proceso de trámite, juicio o proceso de otorgamiento de invalidez temporal y/o permanente NO tengo incapacidad total y permanente, ni tengo invalidez total y permanente. Declaro bajo protesta de decir verdad que, para el desempeño de mi ocupación, actividad laboral y profesional, no utilizo ni tampoco estoy expuesto a: armas de fuego, explosivos, maquinaria pesada (relacionada con la construcción o la minería), sustancias químicas, no trabajo en alturas, ni bajo el agua, ni con motocicleta, ni en alguna "
			                },
			                {
			                    "message": "advertencia: el usuario está de declarando que en los dos años anteriores de haber suscrito la presente declaracion no tiene enfermedades, estudios, diagnosticos o gastosa asociados a estas enfermedades."
			                }
			            ]
			        },
			        {
			            "apiName": "politically_exposed_person",
			            "dataType": "Checkbox",
			            "text": "Soy una persona políticamente expuesta",
			            "tooltips": [
			                {
			                    "message": "Se entiende como Personas Políticamente expuestas a la persona que desempeña o ha desempeñado por lo menos en el último año, funciones públicas destacadas en un país extranjero o en territorio nacional. Se asimilan a las Personas Políticamente Expuestas el cónyuge, concubina (0) y las personas con las que mantenga parentesco por consanguinidad o afinidad hasta el segundo grado, así como las personas morales con las que la Persona Políticamente Expuesta mantenga vínculos patrimoniales."
			                }
			            ]
			        },
			        {
			            "apiName": "true_information",
			            "dataType": "Checkbox",
			            "text":"\\"El Cliente\\" declara bajo protesta que la presente información, es totalmente verídica, asumiendo las responsabilidades Legales en caso de falsedad, omisión o declaración inexacta"
			        }
			    ]
			}
		"""

		def cuestionarioEsparado = jsonSlurper.parseText(cuestionario)
		print(cuestionarioEsparado)
		//def status= WS.verifyMatch(responseVida, RespuestaEsparada, false, FailureHandling.CONTINUE_ON_FAILURE)
		def status = WS.verifyEqual(responseQuizz, cuestionarioEsparado, FailureHandling.CONTINUE_ON_FAILURE)
		return status
	}

	@Keyword
	def  static validarPaqueteAutos(def responseAutos, def tipoVehicu){

		def jsonSlurper = new JsonSlurper()
		def paqueteAuto=""""""
		switch(tipoVehicu) {
			case "Auto":
				paqueteAuto="""
				[
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A002",
				                    "isOptional": false,
				                    "name": "Rotura cristales",
				                    "deductibleValue": "20",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor del Cristal"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A004",
				                    "isOptional": false,
				                    "name": "Robo total",
				                    "deductibleValue": "5",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 50000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "code": "A017",
				                    "isOptional": true,
				                    "name": "Eliminación deducible y devolución de primas por robo total",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "code": "A016",
				                    "isOptional": true,
				                    "name": "Eliminación de deducible y devolución de primas por perdida total daños materiales",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A001",
				                    "isOptional": false,
				                    "name": "Daños materiales",
				                    "deductibleValue": "3",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A014",
				                    "isOptional": true,
				                    "name": "Auto sustituto por robo total",
				                    "NumDiasEmi": "30",
				                    "sumaAsegurada": "30 días"
				                },
				                {
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A015",
				                    "isOptional": true,
				                    "name": "Auto sustituto por pérdida total daños materiales",
				                    "NumDiasEmi": "15",
				                    "sumaAsegurada": "15 días"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "A03",
				            "name": "AMPLIA"
				        }
				    },
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A004",
				                    "isOptional": false,
				                    "name": "Robo total",
				                    "deductibleValue": "5",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 50000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "code": "A017",
				                    "isOptional": true,
				                    "name": "Eliminación deducible y devolución de primas por robo total",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A014",
				                    "isOptional": true,
				                    "name": "Auto sustituto por robo total",
				                    "NumDiasEmi": "15",
				                    "sumaAsegurada": "15 días"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "A05",
				            "name": "LIMITADA"
				        }
				    },
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 50000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "A06",
				            "name": "RESPONSABILIDAD CIVIL"
				        }
				    }
				]
			"""
				break;

			case "Pickup":
				paqueteAuto="""
		   		[
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A002",
				                    "isOptional": false,
				                    "name": "Rotura cristales",
				                    "deductibleValue": "20",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor del Cristal"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A004",
				                    "isOptional": false,
				                    "name": "Robo total",
				                    "deductibleValue": "5",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 50000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "code": "A017",
				                    "isOptional": true,
				                    "name": "Eliminación deducible y devolución de primas por robo total",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "code": "A016",
				                    "isOptional": true,
				                    "name": "Eliminación de deducible y devolución de primas por perdida total daños materiales",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A001",
				                    "isOptional": false,
				                    "name": "Daños materiales",
				                    "deductibleValue": "3",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A014",
				                    "isOptional": true,
				                    "name": "Auto sustituto por robo total",
				                    "NumDiasEmi": "30",
				                    "sumaAsegurada": "30 días"
				                },
				                {
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A015",
				                    "isOptional": true,
				                    "name": "Auto sustituto por pérdida total daños materiales",
				                    "NumDiasEmi": "15",
				                    "sumaAsegurada": "15 días"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "B03",
				            "name": "AMPLIA"
				        }
				    },
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A004",
				                    "isOptional": false,
				                    "name": "Robo total",
				                    "deductibleValue": "5",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 50000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "code": "A017",
				                    "isOptional": true,
				                    "name": "Eliminación deducible y devolución de primas por robo total",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A014",
				                    "isOptional": true,
				                    "name": "Auto sustituto por robo total",
				                    "NumDiasEmi": "15",
				                    "sumaAsegurada": "15 días"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "B05",
				            "name": "LIMITADA"
				        }
				    },
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 50000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "B06",
				            "name": "RESPONSABILIDAD CIVIL"
				        }
				    }
				]
		   """
				break;

			case "Moto":
				paqueteAuto="""
		   		[
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A002",
				                    "isOptional": false,
				                    "name": "Rotura cristales",
				                    "deductibleValue": "20",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor del Cristal"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A004",
				                    "isOptional": false,
				                    "name": "Robo total",
				                    "deductibleValue": "5",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 100000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A001",
				                    "isOptional": false,
				                    "name": "Daños materiales",
				                    "deductibleValue": "3",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "I01",
				            "name": "AMPLIA"
				        }
				    },
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A004",
				                    "isOptional": false,
				                    "name": "Robo total",
				                    "deductibleValue": "5",
				                    "deductiveBase": "S",
				                    "deductiveType": "PO",
				                    "sumaAsegurada": "Valor Comercial"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 100000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "I03",
				            "name": "LIMITADA"
				        }
				    },
				    {
				        "package": {
				            "branchCode": "A003",
				            "coverages": [
				                {
				                    "NumDiasEmi": "",
				                    "code": "A005",
				                    "isOptional": false,
				                    "name": "Responsabilidad civil terceros",
				                    "deductibleValue": "0",
				                    "deductiveBase": "M",
				                    "deductiveType": "DI",
				                    "sumaAsegurada": 4000000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveType": "",
				                    "code": "A006",
				                    "isOptional": false,
				                    "name": "Gastos médicos ocupantes",
				                    "deductiveBase": "M",
				                    "sumaAsegurada": 100000
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A010",
				                    "isOptional": false,
				                    "name": "Asistencia vehicular",
				                    "sumaAsegurada": "Amparada"
				                },
				                {
				                    "NumDiasEmi": "",
				                    "deductibleValue": "",
				                    "deductiveBase": "",
				                    "deductiveType": "",
				                    "code": "A009",
				                    "isOptional": false,
				                    "name": "Asistencia jurídica",
				                    "sumaAsegurada": "Amparada"
				                }
				            ],
				            "code": "I04",
				            "name": "RESPONSABILIDAD CIVIL"
				        }
				    }
				]
		   """
				break;

			default:
				println("No se encontro esa clave");
				break;
		}
		def RespuestaEsparada = jsonSlurper.parseText(paqueteAuto)
		//def status= WS.verifyMatch(responseVida, RespuestaEsparada, false, FailureHandling.CONTINUE_ON_FAILURE)
		def status = WS.verifyEqual(responseAutos, RespuestaEsparada, FailureHandling.CONTINUE_ON_FAILURE)
		return status
	}

	def static ValidarMarcasAutos(def responseGetAutoMakes) {
		def jsonSlurper = new JsonSlurper()
		def marcasAuto="""{"marca":[{"descMarca":"ACURA","codMarca":"AC"},{"descMarca":"ALFA ROMEO","codMarca":"AR"},{"descMarca":"AT MOTORS","codMarca":"AT"},{"descMarca":"AUDI","codMarca":"AU"},{"descMarca":"BAIC","codMarca":"BA"},{"descMarca":"BMW","codMarca":"BM"},{"descMarca":"BYD","codMarca":"BD"},{"descMarca":"CADILLAC","codMarca":"CD"},{"descMarca":"CBO","codMarca":"CB"},{"descMarca":"CHANGAN","codMarca":"CG"},{"descMarca":"CHIREY","codMarca":"CI"},{"descMarca":"CHRYSLER","codMarca":"CH"},{"descMarca":"COVA","codMarca":"CO"},{"descMarca":"CUPRA","codMarca":"CU"},{"descMarca":"DFSK","codMarca":"DK"},{"descMarca":"FAW","codMarca":"FW"},{"descMarca":"FERRARI","codMarca":"FE"},{"descMarca":"FIAT","codMarca":"FI"},{"descMarca":"FORD","codMarca":"FO"},{"descMarca":"FOTON","codMarca":"FT"},{"descMarca":"GENERAL MOTORS","codMarca":"CV"},{"descMarca":"GIANT","codMarca":"GI"},{"descMarca":"GMC","codMarca":"GM"},{"descMarca":"HONDA","codMarca":"HO"},{"descMarca":"HUMMER","codMarca":"HM"},{"descMarca":"HYUNDAI","codMarca":"HN"},{"descMarca":"INFINITI","codMarca":"IF"},{"descMarca":"JAC","codMarca":"JC"},{"descMarca":"JAGUAR","codMarca":"JA"},{"descMarca":"JETOUR","codMarca":"JT"},{"descMarca":"JMC","codMarca":"JM"},{"descMarca":"KIA","codMarca":"KI"},{"descMarca":"KING LONG","codMarca":"KL"},{"descMarca":"KIRI","codMarca":"KR"},{"descMarca":"LAND ROVER","codMarca":"LR"},{"descMarca":"LEXUS","codMarca":"LE"},{"descMarca":"LOTUS","codMarca":"LO"},{"descMarca":"MASERATI","codMarca":"MT"},{"descMarca":"MAXUS","codMarca":"MX"},{"descMarca":"MAZDA","codMarca":"MZ"},{"descMarca":"MERCEDES BENZ","codMarca":"MB"},{"descMarca":"MG","codMarca":"MG"},{"descMarca":"MITSUBISHI","codMarca":"MI"},{"descMarca":"MOTOCICLETA","codMarca":"VM"},{"descMarca":"NISSAN","codMarca":"NI"},{"descMarca":"OMODA","codMarca":"OM"},{"descMarca":"PEUGEOT","codMarca":"PE"},{"descMarca":"PIAGGIO","codMarca":"PI"},{"descMarca":"PORSCHE","codMarca":"PC"},{"descMarca":"RENAULT","codMarca":"RN"},{"descMarca":"ROVER","codMarca":"RV"},{"descMarca":"SAAB","codMarca":"SA"},{"descMarca":"SEAT","codMarca":"SE"},{"descMarca":"SEV","codMarca":"SY"},{"descMarca":"SKYWELL","codMarca":"SW"},{"descMarca":"SMART","codMarca":"SM"},{"descMarca":"STRUDER","codMarca":"SD"},{"descMarca":"SUBARU","codMarca":"SU"},{"descMarca":"SUZUKI","codMarca":"SK"},{"descMarca":"TESLA","codMarca":"TE"},{"descMarca":"TOYOTA","codMarca":"TY"},{"descMarca":"VOLKSWAGEN","codMarca":"VW"},{"descMarca":"VOLVO","codMarca":"VV"},{"descMarca":"ZACUA","codMarca":"ZA"}]}
		"""
		def marcasEsparadas = jsonSlurper.parseText(marcasAuto)

		//def status= WS.verifyMatch(responseVida, RespuestaEsparada, false, FailureHandling.CONTINUE_ON_FAILURE)
		def status = WS.verifyEqual(marcasEsparadas, responseGetAutoMakes, FailureHandling.CONTINUE_ON_FAILURE)
		return status
	}
}
