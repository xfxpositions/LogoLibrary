package xfxpositions.LogoLibrary.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Getter
@Setter
@ToString
@EnableMongoRepositories(basePackages = "repo.packages")
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String bookName;
    private String authorName;
}
