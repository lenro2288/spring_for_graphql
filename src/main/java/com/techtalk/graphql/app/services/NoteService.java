package com.techtalk.graphql.app.services;

import com.techtalk.graphql.app.domain.Note;
import com.techtalk.graphql.app.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NoteService {
  private NoteRepository noteRepository;

  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public List<Note> getNotesByAuthorId(int authorId) {
    log.info("Calling getNotesByAuthorId service");
    return noteRepository.getByAuthorId(authorId);
  }
}
