package com.example.test.dtos;

import com.sun.prism.shader.DrawRoundRect_ImagePattern_AlphaTest_Loader;
import lombok.Data;

import java.util.Date;

@Data
public class PartnerDTO{

    private long id;

    private String passWord;

    private Date dayStart;

    private Date dayEnd;

}
