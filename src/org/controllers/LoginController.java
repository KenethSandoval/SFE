package org.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.principal.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private AnchorPane locationPanel, userPanel;
    @FXML private ImageView locationArrow, userArrow;

    private static Main mainScene;
    public static final String INTERFACE_NAME = "Login.fxml";
    public static final int INTERFACE_HEIGHT = 458;
    public static final int INTERFACE_WIDTH = 445;

    public void onExitButtonClicked(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void onUserButtonClicked(MouseEvent event) {
        userPanel.setVisible(true);
        userArrow.setVisible(true);

        locationPanel.setVisible(false);
        locationArrow.setVisible(false);
    }

    public void onLocationButtonClicked(MouseEvent event) {
        locationPanel.setVisible(true);
        locationArrow.setVisible(true);

        userPanel.setVisible(false);
        userArrow.setVisible(false);
    }

    public static Main getMainScene() {
        return mainScene;
    }

    public static void setMainScene(Main mainScene) {
        LoginController.mainScene = mainScene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
