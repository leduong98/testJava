package com.example.test.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "partner")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private long password;

    private long accountNumber;

    private long accountBalance;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "partner")
    private List<PartnerLog> logList = new ArrayList<>();

}
