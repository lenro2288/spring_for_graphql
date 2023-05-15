package com.techtalk.graphql.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NOTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

  @Id
  @Column(name = "NOTE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer noteId;
  @Column(name = "NOTE")
  private String note;
  @Column(name = "AUTHOR_ID")
  private Integer authorId;
}
