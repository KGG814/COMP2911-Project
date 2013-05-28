import java.util.*;

public class HighListItem implements Cloneable {
    private String name;
    private int score;

    HighListItem(String aName, int aScore){
        this.name  = aName;
        this.score = aScore;
    }

    public String getRecord() {
        String result = "";
        // result += "<li>";
        result += name;
        // result += "<br />";
        result += "\n";
        result += score;
        // result += "</li>";
        result += "\n";
        return result;
    }

    public String getName()  { return this.name; }
    public int    getScore() { return this.score; }

    public HighListItem clone() {
        HighListItem N = null;
        try{
            N = (HighListItem)super.clone();
        } catch( CloneNotSupportedException e ) {
            e.printStackTrace();
        }
        return N;
    }

}
