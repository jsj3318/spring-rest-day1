package com.nhnacademy.daily.model.createCommand;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MemberCreateCommand {
    private String id;
    private String name;
    private Integer age;
    @JsonProperty("class")
    private ClassType clazz = ClassType.A;
    private Locale locale = Locale.KO;
}
