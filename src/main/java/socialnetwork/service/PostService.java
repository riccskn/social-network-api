package socialnetwork.service;

import socialnetwork.model.post.Post;
import socialnetwork.payload.PagedResponse;
import socialnetwork.payload.PostRequest;
import socialnetwork.payload.PostResponse;

public interface PostService {

    PostResponse addPost(PostRequest request);

    Post findById(long id);

    PagedResponse<Post> getAllPosts(int page,int size);



}
