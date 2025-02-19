package com.project.Tasks.Domain;


import com.project.Tasks.Constants.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "full_name")
    public String name;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    public Status status = Status.active;

    @Column(name = "password")
    public String password;
}
