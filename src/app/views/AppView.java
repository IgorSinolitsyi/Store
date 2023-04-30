package app.views;

import app.utils.OptionValidator;

import java.util.Scanner;

public class AppView {

    Scanner scanner;

    public int chooseOption() {

        scanner = new Scanner(System.in);

        System.out.print("""
                Choose an option:
                1 - Product with discount.
                2 - No discounts available.
                0 - Close the application.
                """);

        return OptionValidator.validateOptionInput(scanner);
    }

    public void getOutput(String output, int choice) {
        if (choice == 0) System.out.println(output);
        // Scanner лучше закрыть здесь,
        // т.к. в этом методе завершаем программу.
        scanner.close();
        System.exit(0);
    }
}
