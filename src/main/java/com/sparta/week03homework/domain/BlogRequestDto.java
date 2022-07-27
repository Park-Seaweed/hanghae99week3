package com.sparta.week03homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlogRequestDto {
    private String title;
    private String username;
    private String password;
    private String content;
}
