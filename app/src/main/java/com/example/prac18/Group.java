package com.example.prac18;


public class Group {


    private String name;

    private String author;
    public Group(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public Group() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


