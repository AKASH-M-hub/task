/// generate the full code for comment services implementation class in the package com.example.demo.Services.impl with methods createComment, getCommentById, updateComment and deleteComment. Also add the necessary annotations for the service class and inject the CommentRepository to perform the database operations.
package com.example.demo.Services.impl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Comment;
import com.example.demo.Repository.CommentRepository;
@Service
public class CommentServicesImpl {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        } else {
            throw new RuntimeException("Comment not found with id: " + id);
        }
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