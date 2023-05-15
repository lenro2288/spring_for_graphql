package com.techtalk.graphql.app.controllers;

import com.techtalk.graphql.app.domain.Author;
import com.techtalk.graphql.app.domain.BookInfo;
import com.techtalk.graphql.app.domain.Note;
import com.techtalk.graphql.app.services.AuthorService;
import com.techtalk.graphql.app.services.BookService;
import com.techtalk.graphql.app.services.NoteService;
import java.util.List;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
  private AuthorService authorService;
  private BookService bookService;
  private NoteService noteService;

  public AuthorController(AuthorService authorService, BookService bookService,
      NoteService noteService) {
    this.authorService = authorService;
    this.bookService = bookService;
    this.noteService = noteService;
  }

  @QueryMapping
  public List<Author> allAuthors() {
    return authorService.getAllAuthors();
  }

  @SchemaMapping
  public List<BookInfo> books(Author author) {
    return bookService.getBooksByAuthorId(author.getId());
  }

  @SchemaMapping
  public List<Note> notes(Author author) {
    return noteService.getNotesByAuthorId(author.getId());
  }

}
