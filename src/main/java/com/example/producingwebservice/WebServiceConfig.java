package com.example.producingwebservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "countries")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}
	
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(getSecurityInterceptor());
		super.addInterceptors(interceptors);
	}

	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
	}
	
	@Bean
	public Wss4jSecurityInterceptor getSecurityInterceptor() {
		Wss4jSecurityInterceptor securityInterceptor=new Wss4jSecurityInterceptor();
		securityInterceptor.setValidationActions("UsernameToken");
		securityInterceptor.setValidationCallbackHandler(getCallbackHandler());
		return securityInterceptor;
	}
	/*
	@Bean
	public CryptoFactoryBean getCryptoFactory() {
		CryptoFactoryBean cryptoFactory=new CryptoFactoryBean();
		cryptoFactory.setKeyStorePassword("clave-secreta");
		FileSystemResource resource=new FileSystemResource("./src/main/resources/keystore.jks"); 
		try {
			cryptoFactory.setKeyStoreLocation(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cryptoFactory;
	}*/
	
	@Bean
	public SimplePasswordValidationCallbackHandler getCallbackHandler() {
		Map<String,String> users=new HashMap<String,String>();
		users.put("japarejo", "claveSecreta");
		SimplePasswordValidationCallbackHandler passwordValidationHandler=new SimplePasswordValidationCallbackHandler();
		passwordValidationHandler.setUsersMap(users);
		return passwordValidationHandler;
	}
	
}
