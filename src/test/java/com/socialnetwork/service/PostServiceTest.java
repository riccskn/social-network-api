package com.socialnetwork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import socialnetwork.model.post.Comment;
import socialnetwork.model.post.Post;
import socialnetwork.model.user.PersonalDetails;
import socialnetwork.model.user.User;
import socialnetwork.payload.UserProfile;
import socialnetwork.service.PostService;
import socialnetwork.service.impl.PostServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class PostServiceTest {

    @MockBean
    PostServiceImpl postService;


    @Test
    public void should_return_post_entity() {

        PersonalDetails personalDetails = new PersonalDetails(1L,"He/Him","17/05/2004");

        List<Post> posts = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();

        User user = new User(1L,"Rick","Mendes","riccskn","123456","henricke@gmail.com",personalDetails,"Nada",false,posts,comments);

        Post post = new Post(1L,"Title","Post title",user,comments);

        Assertions.assertEquals(post,postService.findById(1L));

    }


    @BeforeEach
    public void setup() {

        PersonalDetails personalDetails = new PersonalDetails(1L,"He/Him","17/05/2004");

        List<Post> posts = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();

        User user = new User(1L,"Rick","Mendes","riccskn","123456","henricke@gmail.com",personalDetails,"Nada",false,posts,comments);

        Post post = new Post(1L,"Title","Post title",user,comments);

        Mockito.when(postService.findById(1L))
                .thenReturn(post);

    }

}
