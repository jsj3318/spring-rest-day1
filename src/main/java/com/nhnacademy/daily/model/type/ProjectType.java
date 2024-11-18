package com.nhnacademy.daily.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProjectType {
    PUBLIC, PRIVATE;

    @JsonCreator
    public static ProjectType forValue(String value) {
        for (ProjectType type : ProjectType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return PRIVATE;
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
