package com.sparta.week03homework.controller;

import com.sparta.week03homework.domain.Blog;
import com.sparta.week03homework.domain.BlogRepository;
import com.sparta.week03homework.domain.BlogRequestDto;
import com.sparta.week03homework.domain.PasswordCheckDto;
import com.sparta.week03homework.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;
    private final BlogRepository blogRepository;

    @PostMapping("/api/blogs")
    public BlogRequestDto blogwrite(@RequestBody BlogRequestDto requestDto){
        blogService.blogwrite(requestDto);
        return requestDto;
    }

    @GetMapping("/api/blogs")
    public List<Blog> readBlog(){
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/blogs/password")
    @ResponseBody
    public PasswordCheckDto passwordcheck(@RequestBody PasswordCheckDto passwordCheckDto){

        passwordCheckDto.setResult(blogService.passwordcheck(passwordCheckDto.getId(),passwordCheckDto.getPassword()));
        return passwordCheckDto;
    }


    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id,@RequestBody BlogRequestDto requestDto){
        blogService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id){
        blogRepository.deleteById(id);
        return id;
    }



}
