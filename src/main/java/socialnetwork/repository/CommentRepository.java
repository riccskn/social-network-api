package socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnetwork.model.post.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
