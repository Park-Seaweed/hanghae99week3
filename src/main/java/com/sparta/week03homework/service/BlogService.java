package com.sparta.week03homework.service;

import com.sparta.week03homework.domain.Blog;
import com.sparta.week03homework.domain.BlogRepository;
import com.sparta.week03homework.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    @Transactional
    public void blogwrite(BlogRequestDto requestDto){
        Blog blog = new Blog(requestDto);
        blogRepository.save(blog);
    }
    @Transactional
    public int passwordcheck(Long id, String password) {
        Optional<Blog> optional = blogRepository.findById(id);
        Blog blog = optional.get();
        String realpassword = blog.getPassword();
        if(realpassword.equals(password)){
            return 1;
        }else {
            return 0;
        }
    }
    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return blog.getId();
    }


}
