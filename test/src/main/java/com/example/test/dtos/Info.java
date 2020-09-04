package com.example.test.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import sun.util.calendar.BaseCalendar;

import javax.print.attribute.standard.DateTimeAtProcessing;
import java.util.Date;

@Data
public class Info {

        @NotBlank
        private long partnerId;

        @NotBlank
        private long userId;

        @NotBlank
        @Length(min = 10, max =120, message = "sai valid")
        private String name;

        @NotBlank
        @Length(min =8,max = 16,message = "passWord sai valid!")
        private String passWord;

        @NotBlank
        private long orderId;

        @NotBlank
        @Length(min=1000, max = 1000000000, message = "giao dich ko duoc qua 1 ty VND hoac duoi 1k VND")
        private long deliveryMoney;

        private Date deliveryDay;

        private long deliveryFee;
}


