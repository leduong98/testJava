package com.example.test.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "partner_log")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class PartnerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long deliveryMoney;

    private long deliveryFee;

    private Date deliveryDay;

    private long accNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnerId")
    private Partner partner;

}
