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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Most Used Programming Languages Among Developers Worldwide As Of 2023");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/coding-icon.png"))); // Sourced from: https://www.iconfinder.com/icons/420785/code_coding_css_development_editor_html_programming_icon
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}