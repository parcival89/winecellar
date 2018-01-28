package be.sander.winecellar.infrastructure.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
}
