package com.project.Tasks.Domain.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

    @JsonProperty
    public String userName;
    @JsonProperty
    public String taskName;

    @JsonProperty
    public String oldTask;

}
