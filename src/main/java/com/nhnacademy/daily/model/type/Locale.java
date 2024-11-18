package com.nhnacademy.daily.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Locale {
    KO, EN, JP;

    @JsonCreator
    public static Locale fromString(String locale) {
        for(Locale l : Locale.values()) {
            if(l.toString().equalsIgnoreCase(locale)) {
                return l;
            }
        }
        return KO;
    }

}
