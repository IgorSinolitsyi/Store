package app.controllers;

import app.entities.Product;
import app.models.ProductIDiscountModel;
import app.utils.Rounder;
import app.views.ProductDiscountView;

import static app.utils.Constants.DISCOUNT_RATE;

public class ProductDiscountController {

    private final ProductIDiscountModel model;
    private final ProductDiscountView view;
    private String name;
    private int quantity;
    private double price;

    public ProductDiscountController(
            ProductIDiscountModel model, ProductDiscountView view
    ) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        mapDataToModel();
        double[] calcValues = {
                calcInitialPayment(),
                calcDiscount(calcInitialPayment()),
                calcPayment(calcInitialPayment(),
                        calcDiscount(calcInitialPayment())
                )
        };
        String[] roundValues = getRoundValues(calcValues);
        setOutput(formOutput(roundValues));
    }

    private void mapDataToModel() {
        String[] data = view.getData();
        Product product = new Product();

        product.setName(data[0]);
        name = product.getName();

        product.setQuantity(Integer.parseInt(data[1]));
        quantity = product.getQuantity();

        product.setPrice(Double.parseDouble(data[2]));
        price = product.getPrice();
    }

    private double calcInitialPayment() {
        return model.calculatePayment(quantity,price);
    }

    private double calcDiscount(double paymentInitial) {
        return model.calculateDiscount(paymentInitial, DISCOUNT_RATE);
    }

    private double calcPayment(double paymentInitial, double discount) {
        return model.calculateDiscountPayment(paymentInitial, discount);
    }

    private String[] getRoundValues(double[] calcValues) {
        return new String[] {
                Rounder.roundValue(calcValues[0]),
                Rounder.roundValue(calcValues[1]),
                Rounder.roundValue(calcValues[2])
        };
    }

    private String formOutput(String[] calcValues) {
        return "------------------------------\n" +
                "Product name: " + name + "\n" +
                "Purchase amount (USD): " + calcValues[0] + "\n" +
                "Discount amount (USD): " + calcValues[1] + "\n" +
                "PAYMENT (USD): " + calcValues[2];
    }

    private void setOutput(String output) {
        view.getOutput(output);
    }
}
