package app.models;

import app.controllers.ProductController;
import app.controllers.ProductDiscountController;
import app.views.ProductDiscountView;
import app.views.ProductView;

public class AppModel {

    public void runProductDiscount() {
        ProductIDiscountModel model = new ProductIDiscountModel();
        ProductDiscountView view = new ProductDiscountView();
        ProductDiscountController controller = new ProductDiscountController(model, view);
        controller.runApp();
    }

    public void runProduct() {
        ProductModel model = new ProductModel();
        ProductView view = new ProductView();
        ProductController controller = new ProductController(model, view);
        controller.runApp();
    }
}
