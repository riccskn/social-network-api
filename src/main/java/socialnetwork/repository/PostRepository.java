package socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnetwork.model.post.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
