package com.project.Tasks.Domain.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @JsonProperty
    public String name;
    @JsonProperty
    public String password;

}
