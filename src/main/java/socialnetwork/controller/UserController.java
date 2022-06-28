package socialnetwork.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnetwork.model.post.Post;
import socialnetwork.model.user.User;
import socialnetwork.payload.FriendRequest;
import socialnetwork.payload.UserProfile;
import socialnetwork.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
@Slf4j
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {

        User newUser = userService.addUser(user);

        log.info("User {} registered",user.getUsername());

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{username}/profile")
    public ResponseEntity<UserProfile> getProfile(@PathVariable(value = "username") String username) {
        log.info("Getting {} profile",username);

        return new ResponseEntity<>(userService.getUserProfile(username),HttpStatus.OK);

    }

    @DeleteMapping("/{username}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "username")String username) {
        log.info("deleting {} user",username);

        User user = userService.deleteUserByUsername(username);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/{username}/posts")
    public ResponseEntity<List<Post>> getPosts(@PathVariable(value = "username") String username) {

        log.info("Getting {} posts",username);

        return new ResponseEntity<>(userService.getPosts(username),HttpStatus.OK);
    }


    @GetMapping
    public List<User> getAllUsers() {

        log.info("Getting all users");
        return userService.getAllUsers();
    }

}
