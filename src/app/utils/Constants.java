package app.utils;

public final class Constants {

    // Регулярное выражение
    // для валидации ввода количества.
    // Можно только цифры, целые числа.
    public final static String QUANTITY_RGX = "[0-9]+";

    // Регулярное выражение
    // для валидации ввода цены.
    // Можно только цифры.
    // Можно double значения, но не более 10-ти цифр
    // перед десятичным разделителем.
    public final static String PRICE_RGX = "[0-9]{1,10}(.[0-9]*)?";

    public final static String NO_SUCH_OPTION_MSG = "There is no such option! Try again: ";
    public final static String NAME_EMPTY_MSG = "Empty name value! Try again: ";
    public final static String WRONG_QUANTITY_MSG = "Wrong quantity value! Try again: ";
    public final static String WRONG_PRICE_MSG = "Wrong price value! Try again: ";
    public final static String NAN_NUMBER_MSG = "\"%s\" - not a number!%nTry again: ";
    public final static String JOB_QUIT_MSG = "\n>> Job completed.";
    public final static int DISCOUNT_RATE = 10;
}
