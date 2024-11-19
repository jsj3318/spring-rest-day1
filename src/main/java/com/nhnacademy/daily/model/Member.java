package com.nhnacademy.daily.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import com.nhnacademy.daily.model.type.Role;

public class Member {
    private String id;
    private String password;
    private String name;
    @JsonSerialize(using= ToStringSerializer.class)
    private Integer age;
    @JsonProperty("class")
    private ClassType clazz;
    private Locale locale;
    private Role role;

    @JsonCreator
    public Member(
            @JsonProperty("id") String id,
            @JsonProperty("password") String password,
            @JsonProperty("name") String name,
            @JsonProperty("age") Integer age,
            @JsonProperty("class") ClassType clazz,
            @JsonProperty("locale") Locale locale,
            @JsonProperty("role") Role role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.clazz = clazz;
        this.locale = locale;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
