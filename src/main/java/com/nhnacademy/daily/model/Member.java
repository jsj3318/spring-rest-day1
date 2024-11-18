package com.nhnacademy.daily.model;

public class Member {
    private String id;
    private String name;
    private Integer age;
    private String clazz;
    private Locale locale;

    public Member(String id, String name, Integer age, String clazz, Locale locale) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clazz = clazz;
        this.locale = locale;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getClazz() {
        return clazz;
    }

    public Locale getLocale() {
        return locale;
    }
}
