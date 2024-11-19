package com.nhnacademy.daily.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN, MEMBER;

    @JsonCreator
    public static Role forValue(String value) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        return MEMBER;
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
