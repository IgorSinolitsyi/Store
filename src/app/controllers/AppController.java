package app.controllers;

import app.models.AppModel;
import app.utils.Constants;
import app.views.AppView;

public class AppController {

    AppModel model;
    AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> model.runProductDiscount();
            case 2 -> model.runProduct();
            case 0 -> {
                String output = Constants.JOB_QUIT_MSG;
                view.getOutput(output, choice);
            }
        }
    }

}
