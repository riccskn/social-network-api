package socialnetwork.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnetwork.model.post.Post;
import socialnetwork.payload.PagedResponse;
import socialnetwork.payload.PostRequest;
import socialnetwork.payload.PostResponse;
import socialnetwork.service.PostService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/posts")
@Slf4j
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity<PostResponse> addPost(@Valid @RequestBody PostRequest postRequest) {
     PostResponse postResponse = service.addPost(postRequest);

     return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<Post>> getAllPosts(
            @RequestParam(value = "page",required = false,defaultValue = "0") Integer page,
            @RequestParam(value = "size",required = false,defaultValue = "5") Integer size
    ) {

        PagedResponse<Post> response = service.getAllPosts(page,size);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
