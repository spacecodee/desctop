package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import model.principalgamecard.PrincipalGamesCard;
import utils.Images;

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
        var lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porttitor nunc sed nibh sodales, a" +
                " sagittis mauris tempor.";
        FXMLLoader[] fxmlLoaders = new FXMLLoader[4];
        PrincipalGamesCard card1 = new PrincipalGamesCard(
                "Juego 1", 29.00, 44.99, lorem, new String[]{"xdxd1", "xdxdxd1"}, "gamecard-1.jpg"
        );
        PrincipalGamesCard card2 = new PrincipalGamesCard(
                "Juego 2", 29.00, 44.99, lorem, new String[]{"xdxd2", "xdxdxd2"}, "gamecard-2.jpg"
        );
        PrincipalGamesCard card3 = new PrincipalGamesCard(
                "Juego 3", 29.00, 44.99, lorem, new String[]{"xdxd3", "xdxdxd3"}, "gamecard-3.jpg"
        );
        PrincipalGamesCard card4 = new PrincipalGamesCard(
                "Juego 4", 29.00, 44.99, lorem, new String[]{"xdxd4", "xdxdxd4"}, "gamecard-4.jpg"
        );
        PrincipalGamesCard[] principalGamesCard = {
                card1, card2, card3, card4
        };

        try {
            controller.games.PrincipalGamesCard principalGameCard = null;
            for (int i = 0; i < fxmlLoaders.length; i++) {
                fxmlLoaders[i] = new FXMLLoader();
                fxmlLoaders[i].setLocation(this.getClass().getResource(uri));
                VBox vBox = fxmlLoaders[i].load();

                principalGameCard = fxmlLoaders[i].getController();

                Images.addImg(principalGamesCard[i].getUrlImg(), principalGameCard.getImgGame());
                Images.borderRadiusImgProfile(principalGameCard.getImgGame(), 50);
                principalGameCard.getLblName().setText(principalGamesCard[i].getName());
                principalGameCard.getLblNewPrice().setText(String.valueOf(principalGamesCard[i].getNewPrice()));
                principalGameCard.getLblOldPrice().setText(String.valueOf(principalGamesCard[i].getOldPrice()));
                principalGameCard.getLblDescription().setText(principalGamesCard[i].getDescription());

                principalGameCard.getLblGenre1().setText(principalGamesCard[i].getGenres()[
                        (i < 2) ? i : i - 2
                        ]);
                principalGameCard.getLblGenre2().setText(principalGamesCard[i].getGenres()[
                        (i < 2) ? i : i - 2
                        ]);

                this.fPaneGamesCards.getChildren().add(vBox);
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
