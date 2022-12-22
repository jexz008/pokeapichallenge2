/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.config;

import java.util.List;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadRootSmartSoapEndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


/**
 *
 * @author Joel Corona
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(new CustomEndpointInterceptor());
    }        

        @Bean
        public RestTemplate restTemplate() {
            /*final RestTemplate restTemplate = new RestTemplate(this.httpRequestFactory());
            restTemplate.setMessageConverters(Arrays.asList(new HttpMessageConverter<?>[]{
                new SourceHttpMessageConverter(), new MappingJackson2HttpMessageConverter()}));        
            return restTemplate;*/
            return new RestTemplate();
        } 
    
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		//return new ServletRegistrationBean<>(servlet, "/ws/*");
                return new ServletRegistrationBean<>(servlet, "/api/v2/*");
	}


        
	@Bean(name = "pokemon")
	public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema pokemonSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PokemonPort");
		//wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setLocationUri("/api/v2");
		wsdl11Definition.setTargetNamespace("http://jci.com/pokeapichallenge/producing-web-service");
		wsdl11Definition.setSchema(pokemonSchema);
		return wsdl11Definition;
	}     
  

        
	@Bean
	public XsdSchema pokemonSchema() {
		return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
	}
  
        
    
}
