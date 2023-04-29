package com.hello.world.repository;

import com.hello.world.entity.Comment;
import com.hello.world.entity.Post;
import com.hello.world.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //Create
    Comment save(Comment comment);

    //Update
    @Modifying
    @Transactional
    @Query("update Comment c set c.comment = :comment where c.id = :id")
    void updateById(@Param("comment")String comment, @Param("id") int id);

    //Delete
    @Modifying
    @Transactional
    @Query("delete from Comment c where c.id = :id ")
    void deleteById(@Param("id")int id);

    boolean existsById(int id);
}