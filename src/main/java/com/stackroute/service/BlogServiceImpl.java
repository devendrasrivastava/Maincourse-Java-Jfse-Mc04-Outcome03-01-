package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository repository;

    @Override
    public List<Blog> getAllBlogs(){
    return repository.findAll();
    }

    @Override
    public Blog getBlogById(int blogId) {
        Blog b = null;
        return repository.getOne(blogId);
    }

    @Override
    public Blog deleteBlog(int blogId) {
        Blog blog=repository.getOne(blogId);
        repository.delete(blog);
        return null;
    }

    @Override
    public Blog updateBlog(Blog blog, int blogId) {
        repository.save(blog);
        return blog;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        repository.save(blog);
        return blog;
    }
}
