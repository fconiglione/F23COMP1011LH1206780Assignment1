package com.example.f23comp1011lh1206780assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GraphViewController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;

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
        try {
            // Sourced from: https://stackoverflow.com/questions/34863425/javafx-scene-builder-how-switch-scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));
            Parent tableViewRoot = loader.load();
            tableViewButton.getScene().setRoot(tableViewRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds all the data into the bar graph
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Language> languages = DBUtility.getLanguages();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Language language : languages) {
            series.getData().add(new XYChart.Data<>(language.getLanguage(), language.getPopularity()));
        }
        barChart.getData().add(series);
    }
}
