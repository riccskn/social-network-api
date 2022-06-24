package socialnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import socialnetwork.exception.ResourceNotFoundException;
import socialnetwork.model.post.Comment;
import socialnetwork.model.post.Post;
import socialnetwork.model.user.User;
import socialnetwork.payload.CommentRequest;
import socialnetwork.repository.CommentRepository;
import socialnetwork.repository.PostRepository;
import socialnetwork.repository.UserRepository;
import socialnetwork.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public Comment addComment(CommentRequest request) {

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"User with username "+request.getUsername()+" not found"));

        Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Post with id "+request.getPostId()+" not found"));

        Comment comment = new Comment();
        comment.setBody(request.getBody());
        comment.setPost(post);
        comment.setUser(user);

        commentRepository.save(comment);

        return comment;
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Comment with id: "+id+" not found"));
    }

    @Override
    public Comment deleteCommentById(long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Comment with id: "+id+" not found"));

        commentRepository.delete(comment);

        return comment;
    }

}
