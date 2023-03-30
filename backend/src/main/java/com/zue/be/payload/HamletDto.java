package com.zue.be.payload;
import lombok.Data;

@Data
public class HamletDto {
    private String code;
    private String name;
    private WardDto ward;
}
