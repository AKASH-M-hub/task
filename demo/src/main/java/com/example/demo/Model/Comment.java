//create a full code for the comment class in the package com.example.demo.Model with fields id, content, author and also add the necessary annotations for the entity and the id field

package com.example.demo.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Comment {
    @Id
    private Long id;
    private String content;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
