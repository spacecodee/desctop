package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LateralBarUser implements Initializable {


    @FXML
    private Label lblBtnProfile;

    @FXML
    private Label lblProfileNotification;

    @FXML
    private Label lblBtnFriends;

    @FXML
    private Label lblFriendsNotification;

    @FXML
    private Label lblBtnMsg;

    @FXML
    private Label lblMsgNotification;

    @FXML
    private Label lblBtnGoals;

    @FXML
    private Label lblGoalsNotification;

    @FXML
    private Label lblBtnFavorite;

    @FXML
    private Label lblFavoriteNotification;

    @FXML
    private Label btnCloseSesion;

    private Label[] labels;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.labels = new Label[]{
                this.lblProfileNotification, this.lblFriendsNotification, this.lblMsgNotification,
                this.lblGoalsNotification, this.lblFavoriteNotification
        };
    }

    @FXML
    void closeSessionOnClick(MouseEvent event) {

    }

    public void addInfo(String[] data) {
        for (int i = 0; i < this.labels.length; i++) {
            var newData = Integer.parseInt(data[i].trim());
            this.labels[i].setText(data[i]);

            if (newData > 0) {
                this.labels[i].getStyleClass().add("box-notification");
            }

        }
    }
}
