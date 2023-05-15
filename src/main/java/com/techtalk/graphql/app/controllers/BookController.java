package com.techtalk.graphql.app.controllers;

import com.techtalk.graphql.app.domain.Author;
import com.techtalk.graphql.app.domain.Book;
import com.techtalk.graphql.app.domain.BookInput;
import com.techtalk.graphql.app.services.AuthorService;
import com.techtalk.graphql.app.services.BookService;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

  private BookService bookService;
  private AuthorService authorService;

  public BookController(BookService bookService, AuthorService authorService) {
    this.bookService = bookService;
    this.authorService = authorService;
  }

  @QueryMapping
  public Book bookById(@Argument int id) {
    return bookService.getBookById(id);
  }

  @QueryMapping
  public List<Book> allBooks() {
    return bookService.getAllBooks();
  }

  @SchemaMapping
  public Author author(Book book) {
    return authorService.getAuthorById(book.getAuthorId());
  }

  @MutationMapping
  public Book addBook(@Argument("book") BookInput bookInput) {
    return bookService.createBook(bookInput);
  }
}
