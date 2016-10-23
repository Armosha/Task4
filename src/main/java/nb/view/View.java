package nb.view;

import nb.bean.*;
import nb.bean.entity.Note;
import nb.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {

    private static String menu = "exit - exit from applicaion.\ncreate - addition note.\nadd - find note by content."
            + "\ndate - find note by date.\nshow - show all notes.\nwrite - write notebook into the file."
            + "\nread - read notebook from file.\nfind - find notes";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print(menu);
            Controller controller = new Controller();
            System.out.println("\nEnter your command, please");
            String string = reader.readLine();
            Response response;

            switch (string) {

                case "exit":
                    reader.close();
                    return;

                case "add":
                    AddNoteRequest request = new AddNoteRequest();
                    request.setCommandName("ADD_NEW_NOTE");
                    System.out.println("Enter your note");
                    String myNote = reader.readLine();
                    request.setNote(myNote);
                    response = controller.doRequest(request);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        System.out.println(response.getResultMessage());
                    }
                    break;
                case "show":
                    Request request1 = new Request();
                    request1.setCommandName("SHOW_NOTEBOOK");
                    response = controller.doRequest(request1);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        ShowAllNotesResponse res = (ShowAllNotesResponse) response;
                        List<Note> book = res.getAllNotes();
                        if (!book.isEmpty()) {
                            for (Note note : book) {
                                System.out.println(note);
                            }
                        }
                        System.out.println(response.getResultMessage());
                    }
                    break;
                case "create":
                    Request request2 = new Request();
                    System.out.println("Do you want to create a new notebook? Any unsaved " +
                            "notes will be lost! Y/N");
                    String answer = reader.readLine();
                    if (!("Y".equals(answer) || "y".equals(answer))) {
                        break;
                    }
                    request2.setCommandName("CREATE_NOTEBOOK");
                    response = controller.doRequest(request2);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        System.out.println(response.getResultMessage());
                    }
                    break;

                case "write":
                    Request request4 = new Request();
                    request4.setCommandName("WRITE_FILE");
                    response = controller.doRequest(request4);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        System.out.println(response.getResultMessage());
                    }
                    break;
                case "read":
                    Request request5 = new Request();
                    request5.setCommandName("READ_FILE");
                    response = controller.doRequest(request5);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        System.out.println(response.getResultMessage());
                    }
                    break;

                case "find":
                    FindByNoteRequest request3 = new FindByNoteRequest();
                    System.out.println("Search string, please");
                    String search = reader.readLine();
                    request3.setFindString(search);
                    request3.setCommandName("FIND_BY_NOTE");
                    response = controller.doRequest(request3);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        FindByNoteResponse res = (FindByNoteResponse) response;
                        List<Note> noteFind = res.getFindBook();
                        if (!noteFind.isEmpty()) {
                            for (Note note : noteFind) {
                                System.out.println(note);
                            }
                        }
                        System.out.println(response.getResultMessage());
                    }
                    break;

                case "date":
                    FindByDateRequest request6 = new FindByDateRequest();
                    System.out.println("Enter day");
                    request6.setDay(reader.readLine());
                    System.out.println("Enter month");
                    request6.setMonth(reader.readLine());
                    System.out.println("Enter year");
                    request6.setYear(reader.readLine());
                    request6.setCommandName("FIND_BY_DATE");
                    response = controller.doRequest(request6);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        FindByDateResponse res = (FindByDateResponse) response;
                        List<Note> noteFind = res.getDateNotes();
                        if (!noteFind.isEmpty()) {
                            for (Note note : noteFind) {
                                System.out.println(note);
                            }
                        }
                        System.out.println(response.getResultMessage());
                    }
                    break;
                default:
                    System.out.println("Incorrect command!");
                    break;
            }
        }
    }
}
