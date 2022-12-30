package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.exception.ResourceNotFoundException;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
@Transactional
public class BlogServiceImpl implements BlogService{
@Autowired
private BlogRepository blogRepository;
@Override
public Blog saveBlog(Blog blog){
    return blogRepository.save(blog);    //doubtfull
}

@Override
    public Blog updateBlog(Blog blog){
    Optional<Blog> blogDb = this.blogRepository.findById(blog.getBlogId());
    if(blogDb.isPresent()){
        Blog blogUpdate = blogDb.get();
        blogUpdate.setBlogId(blog.getBlogId());
        blogUpdate.setBlogTitle(blog.getBlogTitle());
        blogUpdate.setBlogContent(blog.getBlogContent());
        blogUpdate.setAuthorName(blog.getAuthorName());
        blogRepository.save(blogUpdate);
        return blogUpdate;
    }else {
throw new ResourceNotFoundException("Record not found with given id: " + blog.getBlogId());
    }
}

    @Override
public List<Blog> getAllBlogs(){
return this.blogRepository.findAll();
    }

@Override
    public Blog getBlogById(int blogId){
        Optional<Blog> blogDb =this.blogRepository.findById(blogId);
        if(blogDb.isPresent()){
        return blogDb.get();
        }else {
        throw new ResourceNotFoundException("Record not found with given id: " + blogId);
}
}

@Override
    public void deleteBlog(int blogId){
        Optional<Blog> blogDb = this.blogRepository.findById(blogId);
        if(blogDb.isPresent()){
            this.blogRepository.delete(blogDb.get());
        }else {
        throw new ResourceNotFoundException("Record not found with given id: " + blogId);
        }
}
}
