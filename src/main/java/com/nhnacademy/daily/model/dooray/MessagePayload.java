package com.nhnacademy.daily.model.dooray;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MessagePayload {
    private String botName;
    private String text;
}
