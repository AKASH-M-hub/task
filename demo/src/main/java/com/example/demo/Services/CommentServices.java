/// generate the full code for the comment services class in the package com.example.demo.Services with methods to create, update and delete comments. The class should use the CommentRepository to perform database operations and should also handle exceptions properly. The methods should return appropriate responses based on the success or failure of the operations.
/// also create the comment repository interface in the package com.example.demo.Repositories that extends JpaRepository for the Comment entity.
/// also create the necessary DTOs for creating and updating comments in the package com.example.demo.DTO.request with fields content and author.
/// also create the necessary DTOs for the comment response in the package com.example.demo.DTO.response with fields id, content, author and taskId.
/// id should be of type Long, content and author should be of type String and taskId should be of type Long.
package com.example.demo.Services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Comment;
import com.example.demo.Repository.CommentRepository;
@Service    
public class CommentServices {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment updatedComment = existingComment.get();
            updatedComment.setContent(comment.getContent());
            updatedComment.setAuthor(comment.getAuthor());
            return commentRepository.save(updatedComment);
        } else {
            throw new RuntimeException("Comment not found with id: " + id);
        }
    }

    public void deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Comment not found with id: " + id);
        }
    }
}