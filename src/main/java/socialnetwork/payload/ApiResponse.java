package socialnetwork.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "success",
        "message"
})
public class ApiResponse {

    @JsonProperty(value = "success")
    private boolean success;

    @JsonProperty(value = "message")
    private String message;

    @JsonIgnore
    private HttpStatus httpStatus;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
