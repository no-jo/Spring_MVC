package pl.spring.demo.service;

import pl.spring.demo.service.impl.AmbiguousIdException;
import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);

    BookTo saveBook(BookTo book);
    void deleteBook(Long id);
	BookTo findBookByID(String id) throws AmbiguousIdException;
}
