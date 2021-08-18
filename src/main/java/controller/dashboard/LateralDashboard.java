package controller.dashboard;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import utils.Images;

import java.net.URL;
import java.util.ResourceBundle;

public class LateralDashboard implements Initializable {

    @FXML
    private ImageView imgProfile;

    @FXML
    private Label lblMinPrice;

    @FXML
    private Label lblMaxPrice;

    @FXML
    private Slider slideMinPrice;

    @FXML
    private Slider slideMaxPrice;

    @FXML
    private Label lblRpg;

    @FXML
    private Label lblShooter;

    @FXML
    private Label lblSurvival;

    @FXML
    private Label lblStrategy;

    @FXML
    private Label lblOpenWorld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Images.borderRadiusImgProfile(this.imgProfile);

        slideMinPrice.valueProperty().addListener((ov, oldVal, newVal) -> lblMinPrice.setText(this.roundNumbers(newVal)));
        slideMaxPrice.valueProperty().addListener((ov, oldVal, newVal) -> lblMaxPrice.setText(this.roundNumbers(newVal)));
        this.boxGenre();
    }

    private String roundNumbers(Number num) {
        return String.valueOf(Math.round((Double) num));
    }

    private void boxGenre() {
        Label[] labels = {
                this.lblRpg, this.lblShooter, this.lblSurvival, this.lblStrategy, this.lblOpenWorld
        };

        for (int i = 0; i < labels.length; i++) {
            int finalI = i;
            labels[i].setOnMouseClicked(e -> {
                try {
                    if (labels[finalI].getStyleClass().get(4).equalsIgnoreCase("box-genre-new")) {
                        labels[finalI].getStyleClass().remove(4);
                    }
                } catch (Exception ex) {
                    labels[finalI].getStyleClass().add("box-genre-new");
                }
            });
        }
    }
}
