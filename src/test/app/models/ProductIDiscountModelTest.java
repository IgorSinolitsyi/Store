package test.app.models;

import app.models.ProductIDiscountModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ProductIDiscountModelTest {
    private ProductIDiscountModel productIDiscountModel;

    @BeforeEach
    void setUp() {
         productIDiscountModel = new ProductIDiscountModel();
    }

    @AfterEach
    void tearDown() {
        productIDiscountModel = null;
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
        assertEquals(productIDiscountModel.calculatePayment(quota,price),expectedResult);
    }



    @ParameterizedTest(name = "{index} -  {0} payment: {1}, discount rate {2}, expected result: {3}")
    @CsvSource(value = {
            "<<high payment value and low discount rate>> , 9999990, 10, 999999.0",
            "<<high discount rate  value and low payment>> , 7, 95, 6.65",
            "<<discount rate value is zero>> , 7, 0, 0.0",
            "<<payment value is zero>> , 0, 10, 0.0",
            "<<payment value is one>>, 1,55, 0.55",
            "<<discount rate value is one>>, 333.2, 1, 3.332"}, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Testing calculateDiscount method with parameters:")

    void calculateDiscount(String comment,double payment, int discountRate, double expectedResult) {
        assertEquals(productIDiscountModel.calculateDiscount(payment,discountRate),expectedResult);
    }



    @ParameterizedTest(name = "{index} -  {0} payment: {1}, discount {2}, expected result: {3}")
    @CsvSource(value = {
            "<<high payment value and low discount>> , 9999990, 10, 9999980",
            "<<high discount value and low payment>> , 100, 95, 5",
            "<<discount value is zero>> , 7, 0, 7",
            "<<payment value is zero>> , 0, 10, -10"}, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Testing calculateDiscountPayment method with parameters:")

    void calculateDiscountPayment(String comment, double payment, double discount, double expectedResult) {
        assertEquals(productIDiscountModel.calculateDiscountPayment(payment, discount),expectedResult);
    }
}