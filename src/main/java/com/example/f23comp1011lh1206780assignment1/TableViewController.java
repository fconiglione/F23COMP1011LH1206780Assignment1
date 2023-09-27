package com.example.f23comp1011lh1206780assignment1;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    void switchToGraphView() {

    }

    @FXML
    void switchToTableView() {

    }

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
