package com.stackroute.domain;

import javax.persistence.*;

@Entity
@Table(name= "blog")
/* Add Annotation to declare this class as a JPA Entity */
public class Blog {
    /*Add Annotation to declare this field as a Unique Identifier */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;
    private String blogTitle;
    private String authorName;
    private String blogContent;

    /* Generate no-arg and parametrized constructor */
    public Blog() {
    }
    public Blog(int blogId, String blogTitle, String authorName, String blogContent) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.blogContent = blogContent;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
