package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class MemoryBookService {
    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book("9788324631766","Bruce Eckel","Helion","programming"));
        list.add(new Book("9788324627738","Sierra Kathy, Bates Bert","Helion","programming"));
        list.add(new Book("9780130819338","Cay Horstmann, Gary Cornell","Helion","programming"));


    }
    public List<Book> getList() {return list;}
    public void setList(List<Book> list) {this.list = list;}
    public Book addList(Book book) {this.list.add(book); return book;}

    public Book getBookById(Long id) {
        return this.list.stream().filter(p->p.getId() == id).findFirst().orElse(null);
    }

    public Book changeBook(Long id, Book book) {
        Book book1 = getBookById(id);

        book1.setAuthor(book.getAuthor());
        book1.setIsbn(book.getIsbn());
        book1.setPublisher(book.getPublisher());
        book1.setType(book.getType());
        return book1;
    }

    public void deleteBook(Long id) {
        this.list.remove(getBookById(id));
    }
}