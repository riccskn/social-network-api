package socialnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import socialnetwork.exception.BadRequestException;
import socialnetwork.exception.ResourceNotFoundException;
import socialnetwork.model.post.Post;
import socialnetwork.model.user.User;
import socialnetwork.payload.UserProfile;
import socialnetwork.repository.UserRepository;
import socialnetwork.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
           if (userRepository.existsByUsername(user.getUsername())) {

               throw new BadRequestException(HttpStatus.BAD_REQUEST,"Username is already taken");

           }

           if (userRepository.existsByEmail(user.getEmail())) {

               throw new BadRequestException(HttpStatus.BAD_REQUEST,"Email is already taken");

           }

           userRepository.save(user);

         return user;
    }

    @Override
    public UserProfile getUserProfile(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User with username: "+username+" not found"));

        return new UserProfile(user.getId(), user.getFirstName(),user.getLastName(), user.getUsername(), user.getEmail(), user.getPersonalDetails(), user.getDescription(),user.getVerifiedAccount()
        );
    }



    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public List<Post> getPosts(String username) {
        return userRepository.findByUsername(username).orElseThrow( () -> {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User with username: "+username+" not found");
        }).getPosts();
    }

    @Override
    public User deleteUserByUsername(String username) {

        User user = userRepository.findByUsername(username).orElseThrow( () -> {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User with username: "+username+" not found");
        });

        userRepository.delete(user);

        return user;
    }
}
