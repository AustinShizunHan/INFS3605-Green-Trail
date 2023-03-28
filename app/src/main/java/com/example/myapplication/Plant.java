package com.example.myapplication;

public class Plant {
    private String name;
    private int imageResourceId;
    private String details;
    private String description;

    public Plant(String name, int imageResourceId, String details, String description) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.details = details;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
