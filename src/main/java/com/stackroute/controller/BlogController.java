package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    /* Provide implementation code for these methods */
    @Autowired
    private BlogService blogService;

    /*This method should save blog and return savedBlog Object */
    @PostMapping("save")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog newBlog) {
        Blog addBlog = blogService.saveBlog(newBlog);
        return new ResponseEntity<>(addBlog, HttpStatus.CREATED);
    }


    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return this.blogService.getAllBlogs();
    }


    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blogs/{blogId}")
    public Blog getBlogById(@PathVariable Integer blogId){
        return this.blogService.getBlogById(blogId);
    }


    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<?> getBlogAfterDeleting(@PathVariable int blogId) {
        blogService.deleteBlog(blogId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blogs/{blogId}")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog newBlog, @PathVariable int blogId) {
        Blog editBlog = blogService.updateBlog(newBlog, blogId);
        return new ResponseEntity<>(editBlog,HttpStatus.OK);
    }

}