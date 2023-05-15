package com.techtalk.graphql.app.services;

import com.techtalk.graphql.app.domain.Author;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorService {

  private List<Author> authorList;

  public AuthorService() {
    authorList = new ArrayList<>(Arrays.asList(
        new Author(1, "Gabriel", "Garcia Marquez"),
        new Author(2, "Julio", "Cortazar"),
        new Author(3, "Eduardo", "Galeano")
    ));
  }

  public Author getAuthorById(int id) {
    log.info("Calling getAuthorById service");
    return authorList.stream().filter(author -> author.getId() == id).findFirst().get();
  }

  public List<Author> getAllAuthors() {
    log.info("Calling getAllAuthors service");
    return authorList;
  }
}
