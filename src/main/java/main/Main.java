package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final int height = 850;
        final int width = 1200;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/dashboard/dashboard.fxml")));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, width, height));
        stage.setMinWidth(width);
        stage.setMinHeight(height);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
