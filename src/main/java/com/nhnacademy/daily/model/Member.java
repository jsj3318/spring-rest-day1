package com.nhnacademy.daily.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;

public class Member {
    private String id;
    private String name;
    @JsonSerialize(using= ToStringSerializer.class)
    private Integer age;
    @JsonProperty("class")
    private ClassType clazz;
    private Locale locale;

    public Member(String id, String name, Integer age, ClassType clazz, Locale locale) {
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

    public ClassType getClazz() {
        return clazz;
    }

    public Locale getLocale() {
        return locale;
    }
}
