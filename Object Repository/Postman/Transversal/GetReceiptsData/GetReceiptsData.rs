<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetReceiptsData</name>
   <tag></tag>
   <elementGuidId>83d3ad66-d62d-4a35-9a75-4a0283b4a006</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;price\&quot;: ${price},\n    \&quot;total\&quot;: ${total},\n    \&quot;taxAmount\&quot;: ${taxAmount},\n    \&quot;priceWithExpense\&quot;: ${priceWithExpense},\n    \&quot;expense\&quot;: ${expense},\n    \&quot;numInstallments\&quot;: ${numInstallments},\n    \&quot;productCode\&quot;: \&quot;${productCode}\&quot;\n}\n&quot;,
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
      <webElementGuid>660ebfe2-b89f-4b89-a796-8e47eea17da0</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>72502f86-4ba5-4263-bab0-4051afe54de1</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOST}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_GetReceiptsData/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>1500</defaultValue>
      <description></description>
      <id>c2ac4e2b-1a4c-4e9f-a8b4-8bf849c48264</id>
      <masked>false</masked>
      <name>price</name>
   </variables>
   <variables>
      <defaultValue>2320</defaultValue>
      <description></description>
      <id>757266c3-2e81-4210-b301-8f05d169e37c</id>
      <masked>false</masked>
      <name>total</name>
   </variables>
   <variables>
      <defaultValue>320</defaultValue>
      <description></description>
      <id>3533b9a7-3262-4c03-a3f7-b4cc930834e3</id>
      <masked>false</masked>
      <name>taxAmount</name>
   </variables>
   <variables>
      <defaultValue>200</defaultValue>
      <description></description>
      <id>ba8931f1-306b-4a7f-b8ac-c20d43b0de53</id>
      <masked>false</masked>
      <name>priceWithExpense</name>
   </variables>
   <variables>
      <defaultValue>500</defaultValue>
      <description></description>
      <id>328cf477-6f0b-4347-80f7-25e359dd9a9b</id>
      <masked>false</masked>
      <name>expense</name>
   </variables>
   <variables>
      <defaultValue>12</defaultValue>
      <description></description>
      <id>e2be14a6-5c7b-438d-b8dc-f3a08000e4df</id>
      <masked>false</masked>
      <name>numInstallments</name>
   </variables>
   <variables>
      <defaultValue>'SEGURO_CASA_HABITACION_APF_PROPIO_ROOT'</defaultValue>
      <description></description>
      <id>42735c33-559d-48ca-896e-988545ebc123</id>
      <masked>false</masked>
      <name>productCode</name>
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
