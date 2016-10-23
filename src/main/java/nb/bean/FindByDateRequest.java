package nb.bean;

/**
 * Created by Iryna Filipava on 06.10.2016.
 */
public class FindByDateRequest extends Request {

    private String day;
    private String month;
    private String year;

    public FindByDateRequest() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}