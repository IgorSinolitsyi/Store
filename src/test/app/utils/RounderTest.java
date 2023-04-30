package test.app.utils;

import app.utils.Rounder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RounderTest {
    @Test
    void test_Result_Right_Rounding() {
        assertEquals("8,56", Rounder.roundValue(8.56483));
    }

    @Test
    void test_Result_Wrong_Rounding() {
        assertNotEquals("8,565",  Rounder.roundValue(8.56483));
    }
}
