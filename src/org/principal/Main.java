/*
 *
 * @author Keneth
 *
 * */
package org.principal;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import java.io.InputStream;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//Me
import org.controllers.LoginController;

public class Main extends Application {
    /* Variables for view methods */
    private final String VIEWS_PACKAGE = "/org/views/";
    //logo
    private final String CSS_PACKAGE = "/org/css/";

    /* Variables for Scenes */
    private LoginController loginController;
    private Stage mainScene;
    private Scene scene;

    /* Variables for methods to move application */
    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("SFE");
        primaryStage.setScene(scene);
        this.mainScene = primaryStage;
        viewLogin();
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
            charger.setLocation(getClass().getResource(VIEWS_PACKAGE + fxml));
            file = getClass().getResourceAsStream(VIEWS_PACKAGE + fxml);
            this.scene = new Scene((AnchorPane) charger.load(file));
            this.mainScene.setScene(this.scene);
            this.scene.setFill(Color.TRANSPARENT);
            /* Methods to move application */
            this.scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getScreenX();
                    yOffset = event.getSceneY();
                }
            });

            this.scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mainScene.setX(event.getScreenX() - xOffset);
                    mainScene.setY(event.getScreenY() - yOffset);
                }
            });

            result = (Initializable) charger.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /* Views fxml */
    public void viewLogin() {
        loginController = (LoginController) changeScene(LoginController.INTERFACE_NAME);
        LoginController.setMainScene(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
