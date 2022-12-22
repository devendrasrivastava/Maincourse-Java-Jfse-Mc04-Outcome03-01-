package com.stackroute.repository;

/* Add annotation to declare this class as a Repository class.
This interface should extend CRUD Repository
* */

import com.stackroute.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
//    boolean existById(Integer blogId);
//    @Override
//    Optional<Blog> findById(Integer integer);
//
//    @Query("select u from User u where u.email = ?1")
//    Optional<Blog> getBlogById(Integer blogId);


}
