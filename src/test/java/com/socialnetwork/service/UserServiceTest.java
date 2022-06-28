package com.socialnetwork.service;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import socialnetwork.exception.ResourceNotFoundException;
import socialnetwork.model.post.Comment;
import socialnetwork.model.post.Post;
import socialnetwork.model.user.PersonalDetails;
import socialnetwork.model.user.User;
import socialnetwork.payload.UserProfile;
import socialnetwork.service.UserService;
import socialnetwork.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

  /*  @TestConfiguration
    static class UserServiceTestConfiguration{

        @Bean
        public UserServiceImpl userService(){
            return new UserServiceImpl();
        }
    } */

    @MockBean
    UserServiceImpl userService;

    @Test
    public void should_return_user_profile() {

        PersonalDetails personalDetails = new PersonalDetails(1L,"He/Him","17/05/2004");

        Assertions.assertEquals(new UserProfile(1L,"Rick","Mendes","riccskn","henricke@gmail.com",personalDetails,"Nada",false),userService.getUserProfile("riccskn"));

    }


    @BeforeEach
    public void setup() {

        PersonalDetails personalDetails = new PersonalDetails(1L,"He/Him","17/05/2004");

        List<Post> posts = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();

        User user = new User(1L,"Rick","Mendes","riccskn","123456","henricke@gmail.com",personalDetails,"Nada",false,posts,comments);

        Mockito.when(userService.getUserProfile(user.getUsername()))
                .thenReturn(new UserProfile(1L,"Rick","Mendes","riccskn","henricke@gmail.com",personalDetails,"Nada",false));

    }


}
