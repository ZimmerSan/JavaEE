package com.tsimura.aspect;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotebookImpl implements Notebook {
    private List<String> notes = new ArrayList<>();

    @Override
    public void addNote(String note) {
        notes.add(note);
    }

    @Override
    public List<String> getNotes() {
        return notes;
    }
}
