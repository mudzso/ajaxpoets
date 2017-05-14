package Server;

/**
 * Created by mudzso on 2017.04.10..
 */
public class Poem {

    private String text;
    private String title;
    private int year;
    private String poet;

    public Poem(String title, int year, String poet) {
        this.title = title;
        this.year = year;
        this.poet = poet;
    }

    public Poem(String text, String title, int year, String poet) {
        this.text = text;
        this.title = title;
        this.year = year;
        this.poet = poet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getPoet() {
        return poet;
    }
}
