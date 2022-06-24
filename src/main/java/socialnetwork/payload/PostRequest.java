package socialnetwork.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 10)
    private String title;

    @NotBlank
    @Size(min = 5, max = 350)
    private String body;

}
