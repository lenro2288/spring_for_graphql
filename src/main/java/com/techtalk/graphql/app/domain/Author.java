package com.techtalk.graphql.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

  private int id;
  private String firstName;
  private String lastName;
}
