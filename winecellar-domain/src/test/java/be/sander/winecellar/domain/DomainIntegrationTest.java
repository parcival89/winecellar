package be.sander.winecellar.domain;

import be.sander.winecellar.domain.spring.DomainConfig;
import be.sander.winecellar.infrastructure.spring.InfrastructureConfig;
import be.sander.winecellar.infrastructure.test.IntegrationTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
    DomainConfig.class,
    InfrastructureConfig.class
})
public abstract class DomainIntegrationTest extends IntegrationTest {
}
