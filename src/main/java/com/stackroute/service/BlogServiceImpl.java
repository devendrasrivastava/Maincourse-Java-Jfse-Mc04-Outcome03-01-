package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
@Transactional
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository repository;

    @Override
    public List<Blog> getAllBlogs(){
    return repository.findAll();
    }

    @Override
    public Blog getBlogById(int blogId) {
        Optional<Blog> blog = this.repository.findById(blogId);
            return blog.get();
    }

    @Override
    public Blog deleteBlog(int blogId) {
        Blog blog=repository.getOne(blogId);
        repository.delete(blog);
        return null;
    }

    @Override
    public Blog updateBlog(Blog blog, int blogId) {
        Optional<Blog> blog1 = this.repository.findById(blog.getBlogId());

            Blog blog2 = blog1.get();
            blog2.setBlogId(blog.getBlogId());
            blog2.setBlogTitle((blog.getBlogTitle()));
            blog2.setBlogContent(blog.getBlogContent());
            blog2.setAuthorName(blog.getAuthorName());
            return blog2;

    }

    @Override
    public Blog saveBlog(Blog blog) {
        repository.save(blog);
        return blog;
    }
}
