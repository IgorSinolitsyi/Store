package app.utils;

import java.text.DecimalFormat;

// Округлитель значений
public class Rounder {
    // Округление значения по шаблону
    public static String roundValue(double value) {
        return new DecimalFormat("0.00").format(value);
    }
}
