package socialnetwork.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CommentRequest {

    @NotBlank
    private String username;

    @NotNull
    private long postId;

    @NotBlank
    @Size(max = 40)
    private String body;

}
