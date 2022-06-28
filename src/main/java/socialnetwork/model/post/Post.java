package socialnetwork.model.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import socialnetwork.model.user.User;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private List<Comment> comments;

}
