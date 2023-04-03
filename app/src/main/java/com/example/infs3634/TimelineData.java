package com.example.infs3634;

public class TimelineData {
    private String eventDate;
    private String content;




    // create constructor
    public TimelineData(String eventDate, content) {
        this.eventDate = eventDate;
        this.content = content;

    }

    // Create getters and setters

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


