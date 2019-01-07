package be.sander.winecellar.infrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;

@Configuration
@ComponentScan
@EnableJpaRepositories()
@EntityScan()
public class InfrastructureConfig {

//    @Bean
//    public ApplicationProperties applicationProperties() {
//        return new ApplicationProperties();
//    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
