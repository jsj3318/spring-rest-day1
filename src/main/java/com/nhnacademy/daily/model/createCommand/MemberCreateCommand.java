package com.nhnacademy.daily.model.createCommand;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import com.nhnacademy.daily.model.type.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MemberCreateCommand {
    private String id;
    private String password;
    private String name;
    private Integer age;
    @JsonProperty("class")
    private ClassType clazz = ClassType.A;
    private Locale locale = Locale.KO;
    private Role role = Role.MEMBER;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
