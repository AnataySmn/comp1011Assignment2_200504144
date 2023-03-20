package ca.georgiancollege.comp1011.assignment2;

import ca.georgiancollege.comp1011.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PointsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scrabble.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Scrabble points Generator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

