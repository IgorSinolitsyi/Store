package test.app.models;

import app.models.ProductModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

public class ProductModelTest {

    private ProductModel productModel;

    @BeforeEach
    void setUp() {
         productModel = new ProductModel();
    }

    @AfterEach
    void tearDown() {
        productModel = null;
    }

    @ParameterizedTest(name = "{index} -  {0} quota: {1} price: {2} expected result: {3}")
    @CsvSource(value = {
            "<<high quota value and low price>> , 999999990, 3.3, 3299999967",
            "<<high price value and low quota>>, 5, 1999999.85, 9999999.25",
            "<<quota value is zero>>, 0, 8.4, 0",
            "<<price value is zero>>, 5, 0, 0",
            "<<quota value is one>>, 1, 8.4, 8.4",
            "<<price value is one>>, 5, 1, 5"
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Testing calculatePayment method with parameters:")
    void testCalculatePayment(String comment, int quota, double price, double expectedResult) {
        assertEquals(productModel.calculatePayment(quota,price),expectedResult);
    }
}