package xfxpositions.LogoLibrary.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xfxpositions.LogoLibrary.model.Book;
import xfxpositions.LogoLibrary.repository.BookRepository;

import java.util.List;
import java.util.Optional;
@RestController
public class BookController {
    @Autowired
    public BookRepository repository;

    @PostMapping("api/book/add")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "book added";
    }

    @GetMapping("/api/book/list")
    public List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping("/api/book/findbyid/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return repository.findById(id);
    }

    @GetMapping("/api/book/find/{name}")
    public Optional<Book> getBook(@PathVariable Book book){
        return repository.findOne(book);
    }

    @DeleteMapping("/api/book/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "book deleted with id" + id;
    }

}
