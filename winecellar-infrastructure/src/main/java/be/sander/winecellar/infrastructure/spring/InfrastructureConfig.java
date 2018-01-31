package be.sander.winecellar.infrastructure.spring;

import be.sander.winecellar.config.ApplicationProperties;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static be.sander.winecellar.infrastructure.spring.InfrastructureConfig.BASE_PACKAGE;
import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
    value = InfrastructureConfig.INFRASTRUCTURE_BASE_PACKAGE,
    excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class)
)
@EnableJpaRepositories(basePackages = BASE_PACKAGE)
@EntityScan(basePackages = BASE_PACKAGE)
public class InfrastructureConfig {
    public static final String BASE_PACKAGE = "be.sander.winecellar";
    public static final String INFRASTRUCTURE_BASE_PACKAGE = BASE_PACKAGE + ".infrastructure";

    @Bean
    public ApplicationProperties applicationProperties() {
        return new ApplicationProperties();
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
