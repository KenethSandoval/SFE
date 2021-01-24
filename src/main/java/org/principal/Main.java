/*
 *
 * @author Keneth
 *
 * */
package org.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;

import java.io.InputStream;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//Me
import org.controllers.LoginController;
import org.controllers.DashboardController;

public class Main extends Application {
    //logo
    //private final String CSS_PACKAGE = "/org/css/";

    private Stage mainScene;
    private Scene scene;

    /* Variables for methods to move application */
    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage primaryStage){
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("SFE");
        primaryStage.setScene(scene);
        this.mainScene = primaryStage;
        viewDashboard();
        primaryStage.show();
    }

    /* For change scene */
    public Initializable changeScene(String fxml) {
        Initializable result = null;
        InputStream file;
        FXMLLoader charger;

        try {
            charger = new FXMLLoader();
            charger.setBuilderFactory(new JavaFXBuilderFactory());
            /* Variables for view methods */
            String VIEWS_PACKAGE = "/org/views/";
            charger.setLocation(getClass().getResource(VIEWS_PACKAGE + fxml));
            file = getClass().getResourceAsStream(VIEWS_PACKAGE + fxml);
            this.scene = new Scene(charger.load(file));
            this.mainScene.setScene(this.scene);
            this.scene.setFill(Color.TRANSPARENT);

            /* Methods to move application */
            this.scene.setOnMousePressed(event -> {
                xOffset = event.getScreenX();
                yOffset = event.getSceneY();
            });

            this.scene.setOnMouseDragged(event -> {
                    mainScene.setX(event.getScreenX() - xOffset);
                    mainScene.setY(event.getScreenY() - yOffset);
            });

            result = charger.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /* Views fxml */
    public void viewLogin() {
        /* Variables for Scenes */
        LoginController loginController = (LoginController) changeScene(LoginController.INTERFACE_NAME);
        LoginController.setMainScene(this);
    }

    public void viewDashboard() {
        DashboardController dashboardController = (DashboardController) changeScene(DashboardController.INTERFACE_NAME);
        DashboardController.setMainScene(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
