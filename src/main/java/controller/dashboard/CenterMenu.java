package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CenterMenu implements Initializable {

    @FXML
    private FlowPane fPaneGamesCards;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addGamesCard();
    }

    private void addGamesCard() {
        var uri = "/view/games/principal-games-card.fxml";
        FXMLLoader[] fxmlLoaders = new FXMLLoader[4];
        try {
            for (int i = 0; i < fxmlLoaders.length; i++) {
                fxmlLoaders[i] = new FXMLLoader();
                fxmlLoaders[i].setLocation(this.getClass().getResource(uri));
                VBox vBox = fxmlLoaders[i].load();
                this.fPaneGamesCards.getChildren().add(vBox);
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
