package app.models;

import app.base.IPayment;

public class ProductModel implements IPayment {

    @Override
    public double calculatePayment(int quota, double price) {
        return quota * price;
    }
}
