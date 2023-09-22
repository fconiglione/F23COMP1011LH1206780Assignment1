package com.example.f23comp1011lh1206780assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class DBUtility {
    private static String user = "Francescolakfaconigl";
    private static String password = "fKlRR5oE_w";
    private static String connectUrl = "jdbc:mysql://172.31.22.43:3306/Francescolakfaconigl";

    public static ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = new ArrayList<>();

        String sql = "SELECT * FROM programming_languages";
        try (
                Connection conn = DriverManager.getConnection(connectUrl, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                String language = resultSet.getString("language");
                double popularity = resultSet.getDouble("popularity");

                try{
                    Language programmingLanguage = new Language(language, popularity);
                    languages.add(programmingLanguage);
                }catch (IllegalArgumentException e)
                {
                    System.out.printf("Error: Invalid Data. Please check your data set.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }
}