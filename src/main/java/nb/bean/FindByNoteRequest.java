package nb.bean;

/**
 * Created by Iryna Filipava on 06.10.2016.
 */

public class FindByNoteRequest extends Request {

    private String finding;

    public FindByNoteRequest() {
    }

    public String getFindingString() {
        return finding;
    }

    public void setFindString(String finding) {
        this.finding = finding;
    }
}