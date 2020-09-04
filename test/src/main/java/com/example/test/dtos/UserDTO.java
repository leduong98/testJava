package com.example.test.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO{

    private long id;

    private String passWord;

   private Date dayStart;

    private Date dayEnd;

}
