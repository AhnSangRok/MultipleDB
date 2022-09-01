package com.multidb.multipledb.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.multidb.multipledb.source",
        entityManagerFactoryRef = "sourceEntityManagerFactory",
        transactionManagerRef = "sourceTransactionManager"
)
public class SourceDatabaseConfig {

//    @Autowired
//    private Environment env; //이거 알아오기
//
//    @Bean
//    @Primary
//    public LocalContainerEntityManagerFactoryBean sourceEntityManager(){
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(sourceDataSource());
//        //Entity 패키지 경로
//        em.setPackagesToScan(new String[] {"com.multidb.multipledb.Entity"});
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        //Hibernate 설정
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//        return em;
//    }
//
//    @Primary
//    @Bean
//    public DataSource sourceDataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.source.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.jdbc-url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager sourceTransactionManager(){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(sourceEntityManager().getObject());
//        return transactionManager;
//    }
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties sourceDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource sourceDataSource(@Qualifier("sourceDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean sourceEntityManagerFactory(@Qualifier("sourceDataSource") DataSource hubDataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(hubDataSource).packages("com.multidb.multipledb.Entity")
                .persistenceUnit("source").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager sourceTransactionManager(@Qualifier("sourceEntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

}
