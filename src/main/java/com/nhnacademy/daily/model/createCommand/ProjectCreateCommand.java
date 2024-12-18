package com.nhnacademy.daily.model.createCommand;

import com.nhnacademy.daily.model.type.ProjectType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ProjectCreateCommand {
    private String code;
    private LocalDate localDate = LocalDate.now();
    private ProjectType type = ProjectType.PRIVATE;
}
