package nb.command.impl;

import nb.bean.Request;
import nb.bean.Response;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.service.NoteBookService;
import nb.service.ServiceFactory;

public class CreateNewNoteBook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();
        nbService.createNewBook();

        Response response = new Response();
        response.setErrorStatus(true);
        response.setResultMessage("New notebook is created!");
        return response;
    }
}