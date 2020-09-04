package com.example.test.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;

    private String password;

    private long accountNumber;

    private long accountBalance;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Partner partner;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<UserLog> logList = new ArrayList<>();

}
