package nb.service;


import nb.bean.entity.Note;
import nb.service.exeption.ServiceException;

import java.util.Date;
import java.util.List;

public interface NoteBookService {

    void addNote(String note, Date date) throws ServiceException;

    void createNewBook();

    List<Note> findByDate(int day, int month, int year) throws ServiceException;

    List<Note> findByNote(String note);

    void readFile() throws ServiceException;

    List<Note> showNotebook();

    void writeFile() throws ServiceException;
}