package nb.command.impl;

import nb.bean.FindByNoteRequest;
import nb.bean.FindByNoteResponse;
import nb.bean.Request;
import nb.bean.Response;
import nb.bean.entity.Note;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.service.NoteBookService;
import nb.service.ServiceFactory;
import java.util.ArrayList;
import java.util.List;

public class FindNotes implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        Response response = new FindByNoteResponse();
        FindByNoteResponse res;
        FindByNoteRequest req;

        if (response instanceof FindByNoteResponse) {
            res = (FindByNoteResponse) response;
        } else {
            throw new CommandException("Wrong response");
        }


        if (request instanceof FindByNoteRequest) {
            req = (FindByNoteRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        List<Note> list = new ArrayList<>();

        String noteRec = req.getFindingString();
        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();
        list = nbService.findByNote(noteRec);

        res.setErrorStatus(true);
        if (list.isEmpty()) {
            res.setResultMessage("There is no notes matched your request");
        } else {
            res.setFindBook(list);
            res.setResultMessage("All OK!");
        }
        return res;
    }
}

