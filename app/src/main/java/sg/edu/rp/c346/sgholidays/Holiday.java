package sg.edu.rp.c346.sgholidays;

public class Holiday {

    private String name;
    private String date;
    private String ivHoliday;


    public Holiday(String name, String date, String ivHoliday) {
        this.name = name;
        this.date = date;
        this.ivHoliday = ivHoliday;
    }

    public String getIvHoliday() {
        return ivHoliday;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

}
