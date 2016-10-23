package nb.bean;


import nb.bean.entity.Note;

import java.util.List;

/**
 * Created by Iryna Filipava on 06.10.2016.
 */

public class ShowAllNotesResponse extends Response {
    private List<Note> allNotes;

    public List<Note> getAllNotes() {
        return allNotes;
    }

    public void setAllNotes(List<Note> allNotes) {
        this.allNotes = allNotes;
    }
}
