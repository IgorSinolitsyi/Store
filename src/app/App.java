package app;

import app.controllers.AppController;
import app.models.AppModel;
import app.views.AppView;

// Входная точка в программу/приложение
public class App {

    public static void main(String[] args) {
        AppModel model = new AppModel();
        AppView view = new AppView();
        AppController controller = new AppController(model, view);
        controller.runApp();
    }
}
