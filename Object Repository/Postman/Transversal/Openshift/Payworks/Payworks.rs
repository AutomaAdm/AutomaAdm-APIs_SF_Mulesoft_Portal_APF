<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Payworks</name>
   <tag></tag>
   <elementGuidId>7f11ac3a-5c7b-4f76-8054-ff1ba283b612</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;numero\&quot;:\&quot;${numero}\&quot;, \n  \&quot;nombrePropietario\&quot;:\&quot;${nombrePropietario}\&quot;,\n  \&quot;codigoSeguridad\&quot;:\&quot;${codigoSeguridad}\&quot;,\n  \&quot;fechaExpiracion\&quot;:\&quot;${fechaExpiracion}\&quot;,\n  \&quot;tipo_tarjeta\&quot;:\&quot;${tipo_tarjeta}\&quot;,\n  \&quot;monto\&quot;:${monto},\n  \&quot;referencia\&quot;:\&quot;${referencia}\&quot;,\n  \&quot;referencia_cliente1\&quot;:\&quot;${referencia_cliente1}\&quot;,\n  \&quot;payment_process\&quot;:\&quot;Salesforce_APF\&quot;,\n  \&quot;mode\&quot;:\&quot;${mode}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN_INSTITU}</value>
      <webElementGuid>45951d46-192f-4c31-8465-6fc81dc63093</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>b0e07151-8013-4cee-9f75-85602c34e8fd</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://syp-arq-capps.apps.sbc-qas.segurosbanorte.com/payworks/api/payment/process</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'ojhN7RtB+TixTxPLy++DL50Wdvkntn2Q6gCmRnHb1rqaqXX6mbTO7Eu+fppeIZUJ'</defaultValue>
      <description></description>
      <id>2ab67d27-cdcf-4d62-8ee2-789206133f12</id>
      <masked>false</masked>
      <name>numero</name>
   </variables>
   <variables>
      <defaultValue>'ojhN7RtB+TixTxPLy++DL7IdbZ7NbRU1ZOD2JxjK7NHYV/j3vu0XpLj9vu5mlV9B'</defaultValue>
      <description></description>
      <id>57159a3a-2d93-450d-b7ad-d75824087fd4</id>
      <masked>false</masked>
      <name>nombrePropietario</name>
   </variables>
   <variables>
      <defaultValue>'ojhN7RtB+TixTxPLy++DL38J7IK8RASnFy3PZ0U1ro8='</defaultValue>
      <description></description>
      <id>5b03d584-1abd-40b3-b4cc-d913dde8af02</id>
      <masked>false</masked>
      <name>codigoSeguridad</name>
   </variables>
   <variables>
      <defaultValue>'ojhN7RtB+TixTxPLy++DL52NdhIDISEPSwDhBGhWOSg='</defaultValue>
      <description></description>
      <id>c8b18a2f-d5b5-42cb-a2b1-66378c56f6be</id>
      <masked>false</masked>
      <name>fechaExpiracion</name>
   </variables>
   <variables>
      <defaultValue>'CREDITO'</defaultValue>
      <description></description>
      <id>93be5392-1c3c-4f6e-a4d6-1bb8f11eaa66</id>
      <masked>false</masked>
      <name>tipo_tarjeta</name>
   </variables>
   <variables>
      <defaultValue>1500.00</defaultValue>
      <description></description>
      <id>4f94aa1e-74e4-462b-96b5-af06cb4596f8</id>
      <masked>false</masked>
      <name>monto</name>
   </variables>
   <variables>
      <defaultValue>'Seguro de Auto 30/01/24-15:09'</defaultValue>
      <description></description>
      <id>66fc0e76-15b5-452b-a2bd-3f1485262420</id>
      <masked>false</masked>
      <name>referencia</name>
   </variables>
   <variables>
      <defaultValue>'1000000'</defaultValue>
      <description></description>
      <id>292d7efe-6e26-4a01-afba-25a6eb9bb82d</id>
      <masked>false</masked>
      <name>referencia_cliente1</name>
   </variables>
   <variables>
      <defaultValue>'AUTORIZADA'</defaultValue>
      <description></description>
      <id>8b23616a-51b8-408e-8b30-fed8e81e6c6f</id>
      <masked>false</masked>
      <name>mode</name>
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
