package com.volumidev.videogameslib;

import java.util.List;

public class Game {
    private String name;
    private String description;
    private int expected_release_year;
    private Image image;
    private List<Platform> platforms;





    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getExpected_release_year() {
        return expected_release_year;
    }

    public void setExpected_release_year(int expected_release_year) {
        this.expected_release_year = expected_release_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
