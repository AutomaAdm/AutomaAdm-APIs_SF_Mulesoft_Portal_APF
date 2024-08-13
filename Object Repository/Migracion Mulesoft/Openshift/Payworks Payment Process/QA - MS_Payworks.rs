<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>QA - MS_Payworks</name>
   <tag></tag>
   <elementGuidId>31bf16a3-d1fa-48bf-b7c7-201acd6b276c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
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
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>aef1191e-e674-4895-a0cd-37f2fcee4499</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN_INSTITU}</value>
      <webElementGuid>08ed94f3-ee28-4b2d-84dc-8b321abd9933</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://mule-entornos.segurosbanorte.com/syp-arq-capps-payworks-qa-proxy/payworks/api/payment/process/deducibles_generales</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>6a46cc64-7dec-42f0-9aad-d257b7569a01</id>
      <masked>false</masked>
      <name>numero</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9fa5b99e-3834-4efa-8b00-ad3bf4a3a9ec</id>
      <masked>false</masked>
      <name>nombrePropietario</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3db94875-1aed-44a9-b322-2df271844eb7</id>
      <masked>false</masked>
      <name>codigoSeguridad</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d60d5c30-819e-4c60-84f9-35fc319c50a8</id>
      <masked>false</masked>
      <name>fechaExpiracion</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>1b4e843d-d8b5-4479-81c6-21bb3385053c</id>
      <masked>false</masked>
      <name>tipo_tarjeta</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>6d5bd130-3ba1-4675-b1ba-41a3e8b1083f</id>
      <masked>false</masked>
      <name>monto</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>b8699b3e-38cb-4d38-af1f-1547f192b5fd</id>
      <masked>false</masked>
      <name>referencia</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>cf166237-4714-428e-9ea2-6e4b6c5f862d</id>
      <masked>false</masked>
      <name>referencia_cliente1</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>4e396c46-ce07-4409-a50d-62e1346fb8e7</id>
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
