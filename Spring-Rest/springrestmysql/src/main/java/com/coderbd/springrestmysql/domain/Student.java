package com.coderbd.springrestmysql.domain;

public class Student {
    private final long id;
    private final String content;
    private final String country;

    public Student(long id, String content,  String country) {
        this.id = id;
        this.content = content;
        this.country=country;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCountry() {
        return country;
    }


}
