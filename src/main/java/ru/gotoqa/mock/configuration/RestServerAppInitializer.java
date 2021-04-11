package ru.gotoqa.mock.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestServerAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {SoapWebServiceConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {SoapWebServiceConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/*",
        };
    }
}
