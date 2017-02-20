package com.tsimura.aspect;

import java.util.List;

public interface Notebook {

    void addNote(String note);

    List<String> getNotes();
}
