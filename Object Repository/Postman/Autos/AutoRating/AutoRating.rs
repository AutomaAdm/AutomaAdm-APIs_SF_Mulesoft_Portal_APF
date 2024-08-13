<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>AutoRating</name>
   <tag></tag>
   <elementGuidId>506244e1-f9b1-47a9-ba2b-21e0785c7993</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;${inputjson}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>text/plain</value>
      <webElementGuid>b96ded6b-dd27-46ab-8ea5-7a59a6113021</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>eb2ec3aa-2643-47c3-87cc-009263e17686</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.5</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOST}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_EarnixAuto/?ignoreCache=false</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'{\r\n    &quot;input_1&quot;: {\r\n        &quot;autoDriver.Gender&quot;: &quot;M&quot;,\r\n        &quot;autoVehicle.Type&quot;: &quot;001&quot;,\r\n        &quot;autoVehicle.Model&quot;: &quot;004&quot;,\r\n        &quot;autoVehicle.ModelDesc&quot;: &quot;MZ036&quot;,\r\n        &quot;autoVehicle.Year&quot;: &quot;2010&quot;,\r\n        &quot;autoVehicle.Make&quot;: &quot;MZ&quot;,\r\n        &quot;codePlan&quot;: &quot;A06&quot;,\r\n\t\t&quot;cp&quot;: &quot;01000&quot;,\r\n        &quot;estadoAseg&quot;: &quot;09&quot;,\r\n        &quot;estadoCirculacion&quot;: &quot;09&quot;,\r\n        &quot;municipioAseg&quot;: &quot;010&quot;,\r\n        &quot;municipioCirculacion&quot;: &quot;010&quot;\r\n    },\r\n    &quot;coverages&quot;: [\r\n        {\r\n            &quot;CoberturaSeleccionada&quot;: &quot;S&quot;,\r\n            &quot;CoberturaVisible&quot;: &quot;S&quot;,\r\n            &quot;IndCobertOblig&quot;: &quot;S&quot;,\r\n            &quot;BaseDeducible&quot;: &quot;M&quot;,\r\n            &quot;TipoDeducible&quot;: &quot;DI&quot;,\r\n            &quot;PorcDed&quot;: &quot;&quot;,\r\n            &quot;SumaAseg&quot;: &quot;4000000&quot;,\r\n            &quot;CodCobert&quot;: &quot;A005&quot;,\r\n            &quot;NumDiasEmi&quot;: &quot;0&quot;,\r\n            &quot;NumDiasDed&quot;: &quot;0&quot;\r\n        },\r\n        {\r\n            &quot;CoberturaSeleccionada&quot;: &quot;S&quot;,\r\n            &quot;CoberturaVisible&quot;: &quot;S&quot;,\r\n            &quot;IndCobertOblig&quot;: &quot;S&quot;,\r\n            &quot;BaseDeducible&quot;: &quot;M&quot;,\r\n            &quot;TipoDeducible&quot;: &quot;&quot;,\r\n            &quot;PorcDed&quot;: &quot;&quot;,\r\n            &quot;SumaAseg&quot;: &quot;50000.00&quot;,\r\n            &quot;CodCobert&quot;: &quot;A006&quot;,\r\n            &quot;NumDiasEmi&quot;: &quot;&quot;,\r\n            &quot;NumDiasDed&quot;: &quot;&quot;\r\n        },\r\n        {\r\n            &quot;CoberturaSeleccionada&quot;: &quot;S&quot;,\r\n            &quot;CoberturaVisible&quot;: &quot;S&quot;,\r\n            &quot;IndCobertOblig&quot;: &quot;S&quot;,\r\n            &quot;BaseDeducible&quot;: &quot;&quot;,\r\n            &quot;TipoDeducible&quot;: &quot;&quot;,\r\n            &quot;PorcDed&quot;: &quot;&quot;,\r\n            &quot;SumaAseg&quot;: &quot;0&quot;,\r\n            &quot;CodCobert&quot;: &quot;A010&quot;,\r\n            &quot;NumDiasEmi&quot;: &quot;&quot;,\r\n            &quot;NumDiasDed&quot;: &quot;0&quot;\r\n        },\r\n        {\r\n            &quot;CoberturaSeleccionada&quot;: &quot;S&quot;,\r\n            &quot;CoberturaVisible&quot;: &quot;S&quot;,\r\n            &quot;IndCobertOblig&quot;: &quot;S&quot;,\r\n            &quot;BaseDeducible&quot;: &quot;&quot;,\r\n            &quot;TipoDeducible&quot;: &quot;&quot;,\r\n            &quot;PorcDed&quot;: &quot;&quot;,\r\n            &quot;SumaAseg&quot;: &quot;0&quot;,\r\n            &quot;CodCobert&quot;: &quot;A009&quot;,\r\n            &quot;NumDiasEmi&quot;: &quot;&quot;,\r\n            &quot;NumDiasDed&quot;: &quot;&quot;\r\n        }\r\n    ]\r\n}'</defaultValue>
      <description></description>
      <id>1ea599cf-a17a-4a2e-a37f-6c3fb79b07ff</id>
      <masked>false</masked>
      <name>inputjson</name>
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
