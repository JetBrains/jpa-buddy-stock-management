package jpa.buddy.stockmanagement;

import jpa.buddy.stockmanagement.services.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class StockManagementApplicationTests {

    @Autowired
    private StockService stockService;

    @Test
    void contextLoads(){}

    @Test
    @Sql(scripts = "insert-products.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "delete-products.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void quantityByProductTypeTest() {
        assertThat(stockService.getQuantityByProductType("Perfume")).isEqualTo(3L);
    }
}
