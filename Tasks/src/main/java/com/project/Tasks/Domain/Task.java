package com.project.Tasks.Domain;

import com.project.Tasks.Constants.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "user_id")
    @NotBlank
    public int userId;

    @Column(name = "task_name")
    public String taskName;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    public Status status;

}
