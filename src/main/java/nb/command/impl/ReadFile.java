package nb.command.impl;


import nb.bean.Request;
import nb.bean.Response;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.service.NoteBookService;
import nb.service.ServiceFactory;
import nb.service.exeption.ServiceException;

public class ReadFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();
        try {
            nbService.readFile();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
        Response response = new Response();
        response.setErrorStatus(true);
        response.setResultMessage("Notebook was written!");
        return response;
    }
}