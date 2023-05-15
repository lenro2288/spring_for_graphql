package com.techtalk.graphql.app.services;

import com.techtalk.graphql.app.domain.Book;
import com.techtalk.graphql.app.domain.BookInfo;
import com.techtalk.graphql.app.domain.BookInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService {

  private List<Book> bookList;

  public BookService() {
    this.bookList = new ArrayList<>(Arrays.asList(
        new Book(1, "Cien años de soledad", 1),
        new Book(2, "Cronica de una muerte anunciada", 1),
        new Book(3, "Rayuela", 2),
        new Book(4, "Las venas abiertas de America Latina", 3)
    ));
  }

  public Book getBookById(int id) {
    log.info("Calling getBookById service");
    return bookList.stream().filter(book -> book.getId() == id).findFirst().get();
  }

  public List<Book> getAllBooks() {
    log.info("Calling getAllBooks service");
    return bookList;
  }

  public Book createBook(BookInput bookInput) {
    log.info("Calling createBook service");
    this.bookList.add(bookInput);
    return getBookById(bookInput.getId());
  }

  public List<BookInfo> getBooksByAuthorId(int authorId) {
    log.info("Calling getBooksByAuthorId service");
    return bookList.stream().filter(book -> book.getAuthorId() == authorId)
        .map(book -> new BookInfo(book.getId(), book.getName(), book.getAuthorId()))
        .collect(Collectors.toList());
  }
}
