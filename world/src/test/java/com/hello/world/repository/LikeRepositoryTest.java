package com.hello.world.repository;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import com.hello.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikeRepositoryTest {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    public void saveLike(){
        User user = userRepository.getById(100);
        Post post = postRepository.getById(4);
        if((user != null) && (post != null)){
            Like like = new Like(user,post);
            likeRepository.save(like);
        }
        else
            fail("There is no user or post with this id.");
    }
    @Test
    public void updateById(){
        boolean check = likeRepository.existsById(1);
        if(check == true){
            likeRepository.updateById(6,1);
        }
        else
            fail("There is no such like id.");
    }
    @Test
    public void deleteById(){
        boolean check = likeRepository.existsById(1);
        if(check == true){
            likeRepository.deleteById(1);
        }
        else
            fail("There is no like with this id");
    }
    @Test
    public void getByPostId(){
        boolean check = postRepository.existsById(4);
        if(check == true){
            List<Like> likes = likeRepository.getByPostId(4);
            System.out.println("likes: " + likes);
        }
        else
            fail("There is no post");
    }

}