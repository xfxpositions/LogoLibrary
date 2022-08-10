package xfxpositions.LogoLibrary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import xfxpositions.LogoLibrary.model.Book;


@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {
    @DeleteQuery
    void deleteById_(String id);
}
