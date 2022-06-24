package socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialnetwork.model.post.Comment;
import socialnetwork.payload.CommentRequest;
import socialnetwork.service.CommentService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping()
    public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentRequest commentRequest) {

        Comment comment = commentService.addComment(commentRequest);

        return new ResponseEntity<>(comment,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id")long id) {

        return new ResponseEntity<>(commentService.getCommentById(id),HttpStatus.OK);
    }

}
