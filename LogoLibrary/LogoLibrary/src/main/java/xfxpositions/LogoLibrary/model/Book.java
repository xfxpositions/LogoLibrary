package xfxpositions.LogoLibrary.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "books")
public class Book {

    private String bookName;
    private String authorName;
}
