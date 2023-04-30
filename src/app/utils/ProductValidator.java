package app.utils;

import java.util.Scanner;

// Валидатор ввода значений
public class ProductValidator {

    // Валидация ввода имени
    public static String validateNameInput(Scanner scanner) {
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print(Constants.NAME_EMPTY_MSG);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // Валидация ввода количества
    public static String validateQuantityInput(Scanner scanner) {
        String input = scanner.nextLine().trim();
        while (input.isEmpty() || !input.matches(Constants.QUANTITY_RGX)) {
            System.out.print(Constants.WRONG_QUANTITY_MSG);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // Валидация ввода цены
    public static String validatePriceInput(Scanner scanner) {
        String input = scanner.nextLine().trim();
        while (input.isEmpty() || !input.matches(Constants.PRICE_RGX)) {
            System.out.print(Constants.WRONG_PRICE_MSG);
            input = scanner.nextLine().trim();
        }
        return input;
    }
}
