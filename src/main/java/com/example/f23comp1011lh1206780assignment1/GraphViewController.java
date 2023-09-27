package com.example.f23comp1011lh1206780assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GraphViewController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    void switchToGraphView() {

    }

    @FXML
    void switchToTableView() {

    }

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
