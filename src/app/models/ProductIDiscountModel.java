package app.models;


import app.base.IDiscount;
import app.base.IPayment;


public class ProductIDiscountModel implements IPayment, IDiscount {



    // Расчёт платежа, без учета скидки.
    @Override
    public double calculatePayment(int quota, double price) {
        return quota * price;
    }

    // Расчёт суммы скидки.
    @Override
    public double calculateDiscount(double payment, int discountRate) {
        return payment * discountRate / 100;
    }

    // Расчёт платежа, с учетом скидки.
    public double calculateDiscountPayment(double payment, double discount) {
        return payment - discount;
    }
}
