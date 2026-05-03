
package com.example.demo.Repository;
import com.example.demo.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByAuthor(String author);
    List<Comment> findByContentContaining(String keyword);
    List<Comment> findByAuthorAndContentContaining(String author, String keyword);
}