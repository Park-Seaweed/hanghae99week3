package com.sparta.week03homework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PasswordCheckDto {
    private Long id;
    private String password;
    private int result;


}
