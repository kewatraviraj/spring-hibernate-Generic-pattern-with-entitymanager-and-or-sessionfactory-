package com.testspringhibernate.configuration;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dell
 *
 */
@Configuration
@PropertySource("classpath:configuration.properties")
@EnableTransactionManagement
@ComponentScans(value = { 
      @ComponentScan("com.testspringhibernate.dao"),
      @ComponentScan("com.testspringhibernate.service"), 
      @ComponentScan("com.testspringhibernate.model") 
    })
public class HibernateConfig {
	
   @Autowired
   private Environment environment;
   
/*   @Value("${jdbc.driverClassName}")     private String driverClassName;
   @Value("${jdbc.url}")                 private String url;
   @Value("${jdbc.username}")             private String username;
   @Value("${jdbc.password}")             private String password;
   */
   @Value("${hibernate.dialect}")      private String hibernateDialect;
   @Value("${hibernate.show_sql}")     private String hibernateShowSql;
   @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
   
   
   /*@Bean()    
   public DataSource getDataSource()
   {
       DriverManagerDataSource ds = new DriverManagerDataSource();        
       ds.setDriverClassName(driverClassName);
       ds.setUrl(url);
       ds.setUsername(username);
       ds.setPassword(password);        
       return ds;
   }*/
   @Bean
   public DataSource getDataSource() {
     final BasicDataSource dataSource = new BasicDataSource();
    //final DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
      dataSource.setUrl(environment.getProperty("db.url"));
      dataSource.setUsername(environment.getProperty("db.username"));
      dataSource.setPassword(environment.getProperty("db.password"));
      return dataSource;
   }
   
   @Bean
   public Properties getHibernateProperties(){
      final Properties properties = new Properties();
       properties.put("hibernate.dialect", hibernateDialect);
       properties.put("hibernate.show_sql", hibernateShowSql);
       properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
       
       return properties;
   }
   /* ------------------------------------------------------------------------------------------------------------------------------- */
/*   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
     final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setDataSource(getDataSource());
      factoryBean.setPackagesToScan(new String[] {"com.testspringhibernate"});
      factoryBean.setHibernateProperties(getHibernateProperties());
      
      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
     final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }*/
   
   /* ------------------------------------------------------------------------------------------------------------------------------- */
   /* Entitymanager Jpa Configutration
   */
   @Bean
   public LocalContainerEntityManagerFactoryBean geEntityManagerFactoryBean() {
     final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
      entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
 /*	  entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());		*/
      entityManagerFactoryBean.setDataSource(getDataSource());
      entityManagerFactoryBean.setPackagesToScan(new String[] {"com.testspringhibernate"});
      entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
     
      return entityManagerFactoryBean;
   } 
   
   @Bean
   public JpaTransactionManager geJpaTransactionManager() {
     final JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
      return transactionManager;
   }
   /* ------------------------------------------------------------------------------------------------------------------------------- */
   
}
