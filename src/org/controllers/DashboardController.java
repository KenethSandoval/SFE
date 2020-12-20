package org.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import org.principal.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private VBox pnItems = null;

    private static Main mainScene;
    public static final String INTERFACE_NAME = "Dashboard.fxml";

    public static Main getMainScene() {
        return mainScene;
    }

    public static void setMainScene(Main mainScene) {
        DashboardController.mainScene = mainScene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[10];

        for (int i = 0; i < nodes.length; ++i) {
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("/org/views/Item.fxml"));
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
