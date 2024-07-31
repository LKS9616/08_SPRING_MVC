package com.ohgiraffers.thymeleaf.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private String name;
    private int age;
    private char gender;
    private String address;
}
