package socialnetwork.service;

import socialnetwork.model.post.Post;
import socialnetwork.model.user.User;
import socialnetwork.payload.UserProfile;

import java.util.List;

public interface UserService {

    User addUser(User user);

    UserProfile getUserProfile(String username);

    List<User> getAllUsers();

    List<Post> getPosts(String username);

    User deleteUserByUsername(String username);


}
