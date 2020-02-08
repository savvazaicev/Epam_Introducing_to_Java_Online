package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Note {
    private String topic;
    private Date date;
    private String email;
    private String content;


    public Note(String topic, Date date, String email, String content) {
        this.topic = topic;
        this.date = date;
        this.email = email;
        this.content = content;
    }

    @Override
    public String toString() {
        return topic + "\n" + getDateAsString() + "\n" + email + "\n" + content + "\n";
    }

    public String getDateAsString() {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(date);
    }

    public String getTopic() {
        return topic;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }
}
