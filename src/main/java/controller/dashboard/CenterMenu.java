package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utils.Images;

import java.net.URL;
import java.util.ResourceBundle;

public class CenterMenu implements Initializable {
    @FXML
    private Label lblImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Images.addImg("back-menu.jpg", this.lblImg);
    }
}
