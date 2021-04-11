package ru.gotoqa.mock.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import ru.gotoqa.mock.core.builders.CapitalCityResponseBuilder;
import ru.gotoqa.mock.core.builders.CountryCurrencyResponseBuilder;
import ru.gotoqa.mock.core.storages.CapitalCityRequestStorage;
import ru.gotoqa.mock.core.storages.CapitalCityResponseStorage;
import ru.gotoqa.mock.core.storages.CountryCurrencyRequestStorage;
import ru.gotoqa.mock.core.storages.CountryCurrencyResponseStorage;

@EnableWs
@Configuration
public class SoapWebServiceConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean<>(messageDispatcherServlet, "/mock-soap/*");
    }

    @Bean(name = "country")
    public Wsdl11Definition wsdl11DefinitionSms() {
        SimpleWsdl11Definition simpleWsdl11Definition = new SimpleWsdl11Definition();
        simpleWsdl11Definition.setWsdl(new ClassPathResource("/wsdl/CountryInfo.wsdl"));
        return simpleWsdl11Definition;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public CapitalCityRequestStorage createCapitalCityRequestStorage() {
        return new CapitalCityRequestStorage();
    }

    @Bean
    public CapitalCityResponseStorage createCapitalCityResponseStorage() {
        return new CapitalCityResponseStorage();
    }

    @Bean
    public CountryCurrencyRequestStorage createCountryCurrencyRequestStorage() {
        return new CountryCurrencyRequestStorage();
    }

    @Bean
    public CountryCurrencyResponseStorage createCountryCurrencyResponseStorage() {
        return new CountryCurrencyResponseStorage();
    }

    @Bean
    public CapitalCityResponseBuilder createCapitalCityResponseBuilder() {
        return new CapitalCityResponseBuilder();
    }

    @Bean
    public CountryCurrencyResponseBuilder createCountryCurrencyResponseBuilder() {
        return new CountryCurrencyResponseBuilder();
    }

}