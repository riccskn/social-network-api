package socialnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import socialnetwork.exception.ResourceNotFoundException;
import socialnetwork.model.post.Post;
import socialnetwork.model.user.User;
import socialnetwork.payload.PagedResponse;
import socialnetwork.payload.PostRequest;
import socialnetwork.payload.PostResponse;
import socialnetwork.repository.PostRepository;
import socialnetwork.repository.UserRepository;
import socialnetwork.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostResponse addPost(PostRequest request) {

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User with username: "+request.getUsername()+" not found"));

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setBody(request.getBody());
        post.setUser(user);

        postRepository.save(post);

        return new PostResponse(request.getUsername(), post.getTitle(), post.getBody());
    }

    @Override
    public Post findById(long id) {
       return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Post with id: "+id+" not found"));
    }

    @Override
    public PagedResponse<Post> getAllPosts(int page, int size) {

        Pageable pageable = PageRequest.of(page,size);

        Page<Post> postsPage = postRepository.findAll(pageable);

        List<Post> posts = postsPage.getContent();

        if (postsPage.isEmpty()) {

            System.out.println("**********************************************************************************************************************************************************************");

        }

        return new PagedResponse<>(posts,postsPage.getNumber(),postsPage.getSize(),postsPage.getTotalElements(),postsPage.getTotalPages(),postsPage.isLast());
    }
}
