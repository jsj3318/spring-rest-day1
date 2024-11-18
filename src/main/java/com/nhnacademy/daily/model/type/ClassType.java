package com.nhnacademy.daily.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ClassType {
    A,B,C,D;

    @JsonCreator
    public static ClassType fromString(String string) {
        for(ClassType value : ClassType.values()) {
            if(value.name().equalsIgnoreCase(string)) {
                return value;
            }
        }
        return A;
    }

}
