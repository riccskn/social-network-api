package socialnetwork.service;

import socialnetwork.model.post.Comment;
import socialnetwork.payload.CommentRequest;

public interface CommentService {

    Comment addComment(CommentRequest request);

    Comment getCommentById(long id);

    Comment deleteCommentById(long id);

}
