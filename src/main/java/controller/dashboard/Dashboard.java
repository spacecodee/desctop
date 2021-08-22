package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private BorderPane container;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addLateralPane();
        this.addCenterMenu();
    }

    private void addLateralPane() {
        var uri = "/view/dashboard/lateralDashboard.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource(uri));
            VBox vBox = fxmlLoader.load();
            this.container.setLeft(vBox);

            LateralDashboard lateralDashboard = fxmlLoader.getController();
            lateralDashboard.setContainer(this.container);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void addCenterMenu() {
        var uri = "/view/dashboard/center-menu.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource(uri));
            VBox vBox = fxmlLoader.load();
            this.container.setCenter(vBox);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
