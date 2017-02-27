package com.upi.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "fwEntityManagerFactory",
        transactionManagerRef = "fwTransactionManager",
        basePackages = {"com.upi.moudles.sys.repository"})
public class FwJpaConfig {

    @Primary
    @Bean(name = "fwDataSource")
    @ConfigurationProperties(prefix = "fw.datasource")
    public DataSource fwDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "fwEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fwEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("fwDataSource") DataSource fwDataSource) {
        return builder
                .dataSource(fwDataSource)
                .packages("com.upi.moudles.sys.domain")
                .persistenceUnit("fw")
                .build();
    }

    @Primary
    @Bean(name = "fwTransactionManager")
    public PlatformTransactionManager fwTransactionManager(
            @Qualifier("fwEntityManagerFactory") EntityManagerFactory fwEntityManagerFactory) {
        return new JpaTransactionManager(fwEntityManagerFactory);
    }

}
