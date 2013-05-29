import java.util.*;

public class HighListItem implements Cloneable {
    private final String name;
    private final int score;
    private final int difficulty;

    HighListItem(String aName, int aScore, int aDifficulty){
        this.name  = aName;
        this.score = aScore;
        this.difficulty = aDifficulty;
    }

    public String getRecord() {
        String result = "";
        result += name;
        result += " - ";
        result += score;
        result += "[Difficulty ";
        result += difficulty;
        result += "]";
        result += "\n";

        return result;
    }

    public String getName()  { return this.name; }
    public int    getScore() { return this.score; }
    public int    getDifficulty() { return this.difficulty; }

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
