<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MS_CreateQuote</name>
   <tag></tag>
   <elementGuidId>328ed0b7-bb36-41c3-bf05-30849c3f59ec</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;${jSonCotiVida}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>5d121545-571f-45b2-a638-59762dd8707a</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>ae6c1d3e-5ae1-4cbc-9099-48e3109343d0</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOSTNAME_MULESOFT}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_CreateQuote/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'{\r\n  &quot;Step1&quot;: {\r\n    &quot;CURP&quot;: &quot;EAAC780402HCLSLS02&quot;,\r\n    &quot;FirstName&quot;: &quot;CESAR ARTURO&quot;,\r\n    &quot;LastName&quot;: &quot; ESPARZA ALVAREZ&quot;,\r\n    &quot;RFC&quot;: &quot;EAAC780402&quot;,\r\n    &quot;PhoneNumber&quot;: &quot;5616974123&quot;, \r\n    &quot;Email&quot;: &quot;jrmendozav@desarrollo-ultrasist.com.mx&quot;,\r\n    &quot;BirthDate&quot;: &quot;1975-01-25&quot;\r\n  },\r\n  &quot;Step2&quot;: {\r\n    &quot;Address&quot;: {\r\n      &quot;Street&quot;: &quot;113 MARCHANT PLACE&quot;,\r\n      &quot;ExternalNumber&quot;: &quot;6633A&quot;, \r\n      &quot;InternalNumber&quot;: &quot;&quot;,\r\n      &quot;City&quot;: &quot;CUAUTITLÁN IZCALLI&quot;,\r\n      &quot;Country&quot;: &quot;MEXICO&quot;,\r\n      &quot;State&quot;: &quot;MÉXICO&quot;,\r\n      &quot;Town&quot;: &quot;CENTRO&quot;,\r\n      &quot;PostalCode&quot;: &quot;54730&quot; \r\n    }\r\n  },\r\n  &quot;Step3&quot;: {\r\n    &quot;BenificiaryInformation&quot;: [\r\n      {\r\n        &quot;BirthDate&quot;: &quot;1995-04-13&quot;,\r\n        &quot;FirstName&quot;: &quot;OMAR&quot;,\r\n        &quot;email&quot;: &quot;omar@gmail.com&quot;,\r\n        &quot;KinshipExternalCode&quot;: &quot;0041&quot;,\r\n        &quot;LastName&quot;: &quot;AGUIRRE HUERTA&quot;,\r\n        &quot;Percentage&quot;: 50,\r\n\t\t&quot;NumBen&quot;: 1,\r\n        &quot;Address&quot;: {\r\n          &quot;Street&quot;: &quot;1888 HARRISON ROAD&quot;,\r\n\t\t  &quot;ExternalNumber&quot;: 7082,\r\n\t\t  &quot;InternalNumber&quot;: 258,\r\n\t\t  &quot;City&quot;: &quot;GUADALAJARA&quot;,\r\n\t\t  &quot;Country&quot;: &quot;MEXCO&quot;,\r\n\t\t  &quot;State&quot;: &quot;JALISCO&quot;,\r\n\t\t  &quot;Town&quot;: &quot;ANALCO&quot;,\r\n\t\t  &quot;PostalCode&quot;: &quot;44450&quot;\r\n        }\r\n      },\r\n\t  {\r\n        &quot;BirthDate&quot;: &quot;1995-05-14&quot;,\r\n        &quot;FirstName&quot;: &quot;HUMBERTO&quot;,\r\n        &quot;email&quot;: &quot;cesar123@gmail.com&quot;,\r\n        &quot;KinshipExternalCode&quot;: &quot;0041&quot;,\r\n        &quot;LastName&quot;: &quot;CARDENAS CAMPERO&quot;,\r\n        &quot;Percentage&quot;: 50,\r\n\t\t&quot;NumBen&quot;: 2,\r\n        &quot;Address&quot;: {\r\n          &quot;Street&quot;: &quot;CHRISTIE 456&quot;,\r\n\t\t  &quot;ExternalNumber&quot;: 9178,\r\n\t\t  &quot;InternalNumber&quot;: 1,\r\n\t\t  &quot;City&quot;: &quot;GUADALAJARA&quot;,\r\n\t\t  &quot;Country&quot;: &quot;MEXCO&quot;,\r\n\t\t  &quot;State&quot;: &quot;JALISCO&quot;,\r\n\t\t  &quot;Town&quot;: &quot;ANALCO&quot;,\r\n\t\t  &quot;PostalCode&quot;: &quot;44450&quot;\r\n        }\r\n      }\r\n    ]\r\n  },\r\n  &quot;Step4&quot;: {\r\n    &quot;Package&quot;: {\r\n      &quot;branch&quot;: &quot;VI47&quot;,\r\n      &quot;Code&quot;: &quot;SEGURO_VI_APF1_ROOT&quot;,\r\n      &quot;StartDate&quot;: &quot;2023-12-11&quot;,\r\n      &quot;EndDate&quot;: &quot;2024-12-11&quot;,\r\n      &quot;Amount&quot;: 8696.60,\r\n\t  &quot;taxAmount&quot;: 0,\r\n      &quot;priceWithExpense&quot;: 8696.6,\r\n      &quot;expense&quot;: 0,\r\n      &quot;numInstallments&quot;: &quot;012&quot;,\r\n      &quot;expenseOnFirstInstallment&quot;: false,\r\n      &quot;installmentAmount&quot;: 8696.6\r\n    },\r\n    &quot;PackageCoverage&quot;: [\r\n      {\r\n        &quot;code&quot;: &quot;VI10&quot;,\r\n        &quot;price&quot;: 250,\r\n        &quot;insuredAmount&quot;: 500000,\r\n        &quot;name&quot;: &quot;Muerte Accidental&quot;\r\n      },\r\n      {\r\n        &quot;code&quot;: &quot;VI33&quot;,\r\n        &quot;price&quot;: 1925,\r\n        &quot;insuredAmount&quot;: 500000,\r\n        &quot;name&quot;: &quot;Invalidez Total y Permanente&quot;\r\n      },\r\n      {\r\n        &quot;code&quot;: &quot;VI58&quot;,\r\n        &quot;price&quot;: 433,\r\n        &quot;insuredAmount&quot;: 50000,\r\n        &quot;name&quot;: &quot;Indemnización Hospitalaria por Accidente&quot;\r\n      },\r\n      {\r\n        &quot;code&quot;: &quot;VI67&quot;,\r\n        &quot;price&quot;: 1370.60,\r\n        &quot;insuredAmount&quot;: 2500,\r\n        &quot;name&quot;: &quot;Indemnización Diaria por Hospitalización&quot;\r\n      },\r\n      {\r\n        &quot;code&quot;: &quot;VI00&quot;,\r\n        &quot;price&quot;: 4065,\r\n        &quot;insuredAmount&quot;: 500000,\r\n        &quot;name&quot;: &quot;Fallecimiento&quot;\r\n      },\r\n      {\r\n        &quot;code&quot;: &quot;VI95&quot;,\r\n        &quot;price&quot;: 653,\r\n        &quot;insuredAmount&quot;: 100000,\r\n        &quot;name&quot;: &quot;Enfermedades Graves&quot;\r\n      }\r\n    ]\r\n  },\r\n  &quot;Step5&quot;: {\r\n    &quot;Bank&quot;: &quot;072&quot;,\r\n    &quot;CardCVV&quot;: &quot;245&quot;,\r\n    &quot;FirstName&quot;: &quot;IRMA&quot;,\r\n    &quot;LastName&quot;: &quot;MARTINEZ HERNANDEZ&quot;,\r\n    &quot;PaymentPeriod&quot;: &quot;012&quot;,\r\n    &quot;TypeOfCard&quot;: &quot;04&quot;,\r\n    &quot;Amount&quot;: 724.80,\r\n    &quot;IsRecurringPayment&quot;: true,\r\n    &quot;CardMonth&quot;: 12,\r\n    &quot;CardNumber&quot;: 2999123514123888,\r\n    &quot;CardYear&quot;: 23\r\n  }\r\n}'</defaultValue>
      <description></description>
      <id>5caeedb3-df7e-4f14-812f-1d1706b8bc7c</id>
      <masked>false</masked>
      <name>jSonCotiVida</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
