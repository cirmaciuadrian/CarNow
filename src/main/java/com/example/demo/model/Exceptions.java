package com.example.demo.model;

public class Exceptions {
    public int id;
    public String date;
    public String message;

    public Exceptions() {
    }

    public Exceptions(int id, String date, String message) {
        this.id = id;
        this.date = date;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
