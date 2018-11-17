package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memorizedBooks;

    @Autowired
    public BookController(MemoryBookService memorizedBooks) {
        this.memorizedBooks = memorizedBooks;
    }
    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public List<Book> helloBook(){
        return memorizedBooks.getList();


    }

   @PostMapping
    public Book createBook(@RequestBody Book book) {
       return memorizedBooks.addList(book);

    }

    @PutMapping("/{id}")
    public Book changeBook(@PathVariable("id") Long id, @RequestBody Book book) {
        return memorizedBooks.changeBook(id, book);
    }
    @GetMapping("/helloBook/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return memorizedBooks.getBookById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        memorizedBooks.deleteBook(id);
        }
    }

