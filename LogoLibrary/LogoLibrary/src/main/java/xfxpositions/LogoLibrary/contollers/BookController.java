package xfxpositions.LogoLibrary.contollers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import xfxpositions.LogoLibrary.model.Book;
import xfxpositions.LogoLibrary.repository.BookRepository;

import java.util.List;
import java.util.Optional;
@RestController
public class BookController {
    @Autowired
    public BookRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("api/book/add")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "book added, id: " + book.getId();
    }

    @GetMapping("/api/book/list")
    public List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping("/api/book/findbyid/{id}")
    public Book getBookById(@PathVariable String id){
        return mongoTemplate.findById(id,Book.class);
    }

    @GetMapping("/api/book/find/{field}/{name}")
    public List<Book> getBook(@PathVariable String field,@PathVariable String name, @RequestParam Boolean exact){
        Query query = new Query();
        if(exact){
            query.addCriteria(Criteria.where(field).is(name));
        }
        else{
            query.addCriteria(Criteria.where(field).regex(name));
        }
        return mongoTemplate.find(query,Book.class);
    }

    @DeleteMapping("/api/book/delete/{id}")
    public String deleteBook(@PathVariable String id){
        repository.deleteById_(id);
        return "book deleted with id" + id;
    }



}
