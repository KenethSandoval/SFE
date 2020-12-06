package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML private AnchorPane locationPanel, userPanel;
    @FXML private ImageView locationArrow, userArrow;

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
}
