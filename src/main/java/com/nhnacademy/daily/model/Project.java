package com.nhnacademy.daily.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.nhnacademy.daily.model.type.ProjectType;

import java.time.LocalDate;

public class Project {
    private String code;
    private LocalDate localDate;
    private ProjectType type;

    public String getCode() {
        return code;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public ProjectType getType() {
        return type;
    }

    public Project(String code, LocalDate localDate, ProjectType type) {
        this.code = code;
        this.localDate = localDate;
        this.type = type;
    }
}
