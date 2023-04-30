package app.views;

import app.utils.ProductValidator;

import java.util.Scanner;

public class ProductView {

    String title;
    Scanner scanner;

    // Ввод данных.
    // Возвращает строковый массив как набор данных.
    public String[] getData() {

        scanner = new Scanner(System.in);

        title = "Product name: ";
        System.out.print(title);
        String name = ProductValidator.validateNameInput(scanner);

        title = "Product quantity (pcs.): ";
        System.out.print(title);
        String quantity = ProductValidator.validateQuantityInput(scanner);

        title = "Product price (USD): ";
        System.out.print(title);
        String price = ProductValidator.validatePriceInput(scanner);

        scanner.close();

        return new String[] {name, quantity, price};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
