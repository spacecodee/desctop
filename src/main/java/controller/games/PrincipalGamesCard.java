package controller.games;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import utils.Images;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalGamesCard implements Initializable {

    @FXML
    private ImageView imgGame;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNewPrice;

    @FXML
    private Label lblOldPrice;

    @FXML
    private Label lblDescription;

    @FXML
    private Button lblGenre1;

    @FXML
    private Button lblGenre2;

    @FXML
    private Button btnAddToCart;

    @FXML
    private ImageView btnAddCart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Images.borderRadiusImgProfile(this.imgGame, 50);
    }
}
