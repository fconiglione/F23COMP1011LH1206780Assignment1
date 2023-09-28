package com.example.f23comp1011lh1206780assignment1;

public class Language {
    private String language;
    private double popularity;

    /**
     * Constructor for the two attributes: language and popularity
     * @param language
     * @param popularity
     */
    public Language(String language, double popularity) {
        setLanguage(language);
        setPopularity(popularity);
    }

    public String getLanguage() {
        return language;
    }

    /**
     * Setting the language parameter.
     * Adding validation to match the database table (equal to or less than 50 characters, cannot be null).
     * @param language
     */
    public void setLanguage(String language) {
        if (language == null)
            throw new IllegalArgumentException("Language cannot be null value.");
        language = language.trim();
        if (language.length() <= 50)
            this.language = language;
        else
            throw new IllegalArgumentException("Language must be equal to or less than 50 characters.");
    }

    public double getPopularity() {
        return popularity;
    }

    /**
     * Setting the popularity parameter.
     * Adding validation to ensure popularity stays between 0 and 100 percent.
     * @param popularity
     */
    public void setPopularity(double popularity) {
        if (popularity > 0 && popularity <= 100)
            this.popularity = popularity;
        else
            throw new IllegalArgumentException("Popularity must be between 0 and 100.");
    }
}
