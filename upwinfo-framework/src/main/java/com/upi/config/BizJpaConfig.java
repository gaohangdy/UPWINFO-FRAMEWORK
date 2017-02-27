package com.upi.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "bizEntityManagerFactory", 
        transactionManagerRef = "bizTransactionManager",
        basePackages = { "com.upi.moudles.biz.repository" })
public class BizJpaConfig {

    @Bean(name = "bizDataSource")
    @ConfigurationProperties(prefix="biz.datasource")
    public DataSource bizDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bizEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bizEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bizDataSource") DataSource bizDataSource) {
        return builder
                .dataSource(bizDataSource)
                .packages("com.upi.moudles.biz.domain")
                .persistenceUnit("biz")
                .build();
    }

    @Bean(name = "bizTransactionManager")
    public PlatformTransactionManager bizTransactionManager(
            @Qualifier("bizEntityManagerFactory") EntityManagerFactory bizEntityManagerFactory) {
        return new JpaTransactionManager(bizEntityManagerFactory);
    }

}
