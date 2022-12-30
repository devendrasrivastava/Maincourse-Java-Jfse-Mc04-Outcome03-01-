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
public class BlogController {

    /* Provide implementation code for these methods */
    @Autowired
    protected BlogService blogService;
    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blogs")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok().body(this.blogService.saveBlog(blog));
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok().body(blogService.getAllBlogs());
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int blogId){
        return ResponseEntity.ok().body(blogService.getBlogById(blogId));
    }

    /*This method should delete the blog taking its id and return the deleted blog */
@DeleteMapping("/blogs/{blogId}")
    public HttpStatus deleteBlog(@PathVariable int blogId) {
    this.blogService.deleteBlog(blogId);
    return HttpStatus.NO_CONTENT;
    }

    /*This method should update blog and return the updatedBlog */
@PutMapping("/blogs/{blogId}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int blogId, @RequestBody Blog blog) {
    blog.setBlogId(blogId);
    return ResponseEntity.ok().body(this.blogService.updateBlog(blog));
    }
}