package com.example.f23comp1011lh1206780assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Launching the selected view
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("graph-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // Setting the title of the window
        stage.setTitle("Most Used Programming Languages Among Developers Worldwide As Of 2023");
        // Setting the unique icon of the window
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/coding-icon.png"))); // Sourced from: https://www.iconfinder.com/icons/420785/code_coding_css_development_editor_html_programming_icon
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}