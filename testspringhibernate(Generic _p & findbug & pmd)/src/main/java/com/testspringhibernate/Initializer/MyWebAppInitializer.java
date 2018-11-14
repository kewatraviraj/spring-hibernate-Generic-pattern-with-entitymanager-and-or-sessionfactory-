/**
 * 
 */
package com.testspringhibernate.Initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.testspringhibernate.configuration.HibernateConfig;
import com.testspringhibernate.configuration.WebMvcConfig;

/**
 * @author Dell
 *
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { HibernateConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
       return new Class<?>[] { WebMvcConfig.class };
   }
    
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
