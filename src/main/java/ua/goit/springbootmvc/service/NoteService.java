package ua.goit.springbootmvc.service;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ua.goit.springbootmvc.model.Note;

import java.util.*;

@RequiredArgsConstructor
@Data
@Service
public class NoteService {
    private final Note note;
    private Map<Long, Note> notes = new TreeMap<>();
    private  final ApplicationContext context;

    Note add(Note note) {
        long randomID = (long )(Math.random() * (Long.MAX_VALUE));
        note.setId(randomID);
        notes.put(randomID, note);
        return note;
    }
    Map<Long, Note> mapAll() {
        return notes;
    }

    void deleteById(long id) {
        Note noteById = notes.get(id);

        if (noteById == null) {
            throw new RuntimeException("Note not found, id = " + id);
        } else {
            notes.remove(id);
        }
    }

    void update(Note note) {
        Long noteID = note.getId();
        Note noteById = context
                .getBean(NoteService.class)
                .getById(noteID);
        if (noteById == null) {
            throw new RuntimeException("Note not found, id = " + noteID);
        } else {
            notes.replace(noteID, note);
        }
    }

    Note getById(long id) {
        Note noteById = notes.get(id);

        if (noteById == null) {
            throw new RuntimeException("Note not found, id = " + id);
        } else {
            return noteById;
        }

    }

    @PostConstruct
    public void init() {
        note.hello();
    }


}
