package com.example.f23comp1011lh1206780assignment1;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableView<Language> tableView;

    @FXML
    private TableColumn<Language, String> languageColumn;

    @FXML
    private TableColumn<Language, Double> popularityColumn;

    @FXML
    private Button tableViewButton;

    @FXML
    private Button graphViewButton;

    /**
     * This method is actioned when the graphViewButton is clicked;
     * it switches the view to the graph-view.fxml
     */
    @FXML
    void switchToGraphView() {
        try {
            // Sourced from: https://stackoverflow.com/questions/34863425/javafx-scene-builder-how-switch-scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("graph-view.fxml"));
            Parent graphViewRoot = loader.load();
            graphViewButton.getScene().setRoot(graphViewRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is actioned when the tableViewButton is clicked;
     * it switches the view to the table-view.fxml
     */
    @FXML
    void switchToTableView() {
        // Sourced from: https://stackoverflow.com/questions/34863425/javafx-scene-builder-how-switch-scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));
            Parent tableViewRoot = loader.load();
            tableViewButton.getScene().setRoot(tableViewRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method populates all the data into the tableView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Language> languages = DBUtility.getLanguages();

        ObservableList<Language> observableLanguages = FXCollections.observableArrayList(languages);

        tableView.setItems(observableLanguages);

        languageColumn.setCellValueFactory(cellData -> {
            String language = cellData.getValue().getLanguage();
            return new SimpleStringProperty(language);
        });

        popularityColumn.setCellValueFactory(cellData -> {
            double popularity = cellData.getValue().getPopularity();
            return new SimpleDoubleProperty(popularity).asObject();
        });
    }

}
