package socialnetwork.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import socialnetwork.model.post.Comment;
import socialnetwork.model.post.Post;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}), @UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(max = 40)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(max = 15)
    @Column(name = "username")
    private String username;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Email
    @Size(max = 45)
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_details_id")
    private PersonalDetails personalDetails;

    @NotBlank
    @Size(max = 45)
    @Column(name = "profile_description")
    private String description;

    @NotNull
    @Column(name = "verified_account",nullable = false)
    private Boolean verifiedAccount;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments;

}
