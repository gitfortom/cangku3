package com.example.redis_sb.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String age;
    private String address;

}
