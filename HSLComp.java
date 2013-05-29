import java.util.*;

public class HSLComp implements Comparator<HighListItem> {
    public int compare(HighListItem i1, HighListItem i2) {
        return i1.getScore() - i2.getScore();
    }
}
