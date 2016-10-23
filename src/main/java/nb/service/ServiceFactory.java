package nb.service;
import nb.service.impl.NoteBookServiceImpl;


public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private NoteBookService nbService = new NoteBookServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public NoteBookService getNoteBookService(){
        return nbService;
    }

}