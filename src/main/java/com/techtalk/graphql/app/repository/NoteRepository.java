package com.techtalk.graphql.app.repository;

import com.techtalk.graphql.app.domain.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface NoteRepository extends JpaRepository<Note, Integer> {

  public List<Note> getByAuthorId(int authorId);
}
