package be.sander.winecellar.infrastructure.test;

import be.sander.winecellar.infrastructure.spring.SpringBootTestApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@SpringBootTest(classes = {SpringBootTestApplication.class})
@TestExecutionListeners({MockitoTestExecutionListener.class, ResetMocksTestExecutionListener.class})
public abstract class IntegrationTest extends AbstractJUnit4SpringContextTests {
}
