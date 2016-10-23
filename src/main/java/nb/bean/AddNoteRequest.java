package nb.bean;

public class AddNoteRequest extends Request {
	private String note;

	public AddNoteRequest(){

	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
