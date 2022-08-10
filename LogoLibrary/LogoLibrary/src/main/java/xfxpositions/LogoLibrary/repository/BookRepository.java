package xfxpositions.LogoLibrary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import xfxpositions.LogoLibrary.model.Book;


public interface BookRepository extends MongoRepository<Book,Integer> {

}
