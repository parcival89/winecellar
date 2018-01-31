package be.sander.winecellar.domain.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

import static be.sander.winecellar.domain.spring.DomainConfig.DOMAIN_BASE_PACKAGE;
import static be.sander.winecellar.infrastructure.spring.InfrastructureConfig.BASE_PACKAGE;
import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
    basePackages = DOMAIN_BASE_PACKAGE,
    excludeFilters = @Filter(type = ANNOTATION, value = Configuration.class)
)

public class DomainConfig {
    public static final String DOMAIN_BASE_PACKAGE = BASE_PACKAGE + ".domain";
}
