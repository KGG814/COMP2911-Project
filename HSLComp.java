import java.util.*;

public class HSLComp implements Comparator<HighListItem> {
    public int compare(HighListItem i1, HighListItem i2) {
        return i2.getScore() - i1.getScore();
    }
}
