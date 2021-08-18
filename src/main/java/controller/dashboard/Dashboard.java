package controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML
    private BorderPane container;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addLateralPane();
    }

    private void addLateralPane() {
        Parent sidebar;
        var uri = "/view/dashboard/lateralDashboard.fxml";
        try {
            sidebar = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(uri)));
            this.container.setLeft(sidebar);
        } catch (IOException ex) {
            System.out.println("**************");
            ex.printStackTrace(System.out);
        }
    }
}
