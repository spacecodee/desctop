package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import utils.Images;

import java.io.IOException;
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
    private GridPane gridGenre;

    private BorderPane container;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Images.borderRadiusImgProfile(this.imgProfile);

        slideMinPrice.valueProperty().addListener((ov, oldVal, newVal) -> lblMinPrice.setText(this.roundNumbers(newVal)));
        slideMaxPrice.valueProperty().addListener((ov, oldVal, newVal) -> lblMaxPrice.setText(this.roundNumbers(newVal)));
        this.addGridPaneGenre();
    }

    @FXML
    void showProfileMenu(MouseEvent e) {
        if (e.getSource().equals(this.imgProfile)) {
            if (this.container.getRight() == null) {
                var uri = "/view/dashboard/lateralBarUser.fxml";
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(this.getClass().getResource(uri));
                    VBox vBox = fxmlLoader.load();
                    this.container.setRight(vBox);

                    LateralBarUser lateralBarUser = fxmlLoader.getController();
                    String[] data = {
                            "0", "2", "4", "6", "8", "10", "24"
                    };
                    lateralBarUser.addInfo(data);
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            } else {
                this.container.setRight(null);
            }

        }
    }

    private String roundNumbers(Number num) {
        return String.valueOf(Math.round((Double) num));
    }

    private void addGridPaneGenre() {
        var column = 0;
        var row = 0;
        String[] genres = {
                "RPG", "Disparos", "Estrateg??a", "Survival", "Mundo Abierto"
        };

        for (String genre : genres) {
            Label label = this.customLabel(genre);

            if (column == 2) {
                column = 0;
                row++;
            }

            //add listener
            label.setOnMouseClicked(e -> {
                try {
                    if (label.getStyleClass().get(4).equalsIgnoreCase("box-genre-new")) {
                        label.getStyleClass().remove(4);
                    }
                } catch (Exception ex) {
                    label.getStyleClass().add("box-genre-new");
                }
            });

            this.gridGenre.add(label, column++, row);
            GridPane.setVgrow(label, Priority.ALWAYS);
            GridPane.setHgrow(label, Priority.ALWAYS);
            GridPane.setMargin(this.gridGenre, new Insets(0));
        }
    }

    private Label customLabel(String label) {
        var lbl = new Label(label);
        lbl.getStyleClass().addAll("box-genre", "font-normal", "text-normal");
        lbl.setMinHeight(Region.USE_PREF_SIZE);
        lbl.setMinWidth(Region.USE_PREF_SIZE);
        lbl.setPrefWidth(Region.USE_COMPUTED_SIZE);
        lbl.setPrefHeight(Region.USE_COMPUTED_SIZE);
        lbl.setMaxWidth(118);
        lbl.setMaxHeight(40);
        lbl.setAlignment(Pos.CENTER);
        lbl.setCursor(Cursor.HAND);
        return lbl;
    }

    // getters and setters
    public void setContainer(BorderPane container) {
        this.container = container;
    }
}
