import java.util.*;
import java.io.*;

public class HighList {
    private ArrayList<HighListItem> list;
    int min;

    /**
     * Construct list of high scores via input file.
     * @param saved input file.
     */
    HighList(String[] saved) {
        list = new ArrayList<HighListItem>();
        min = 1000000; // INIT with large magic num
        try {
            String name;
            int score;
            Scanner s = new Scanner(new FileReader(saved[0]));
            while(s.hasNext()) {
                name = s.next();
                score = s.nextInt();
                HighListItem r = new HighListItem(name,score);
                // System.out.println(r.getRecord());
                this.list.add(r);
                if(score < min) min = score;
            }
        } catch( FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construct list of high scores in program.
     * @param org program generated list.
     */
    HighList(ArrayList<HighListItem> org) {
        list = new ArrayList<HighListItem>();
        min = 1000000; // INIT with large magic num
        for(HighListItem I : org) {
            HighListItem N = I.clone();
            this.list.add(N);
            if(I.getScore() < min) min = I.getScore();
        }
    }

    /**
     * Save high scores to file HighScores.
     */
    public void saveRecord() {
        try {
            FileWriter f = new FileWriter("HighScores");
            f.write(this.getMsg());
            f.close();
        } catch( Exception e ){
            e.printStackTrace();
        }
    }

    public ArrayList<HighListItem> getList() { return list; } 
    public int getMin() { return min; }

    /**
     * Return list rankings.
     */
    public String getMsg() {
        if(list.isEmpty()) {
            return "List Empty.";
        } else {
            String msg = "";
            for(HighListItem I : list){
                msg += I.getRecord();
            }
            return msg;
        }
    }

    /**
     * sort and keep list within limit.
     */
    void enList() {
        // sort list
        Collections.sort(list,new HSLComp());

        // cut to 10 items
        int size = list.size();
        if(size>10) {
            while(size>10){
                size--;
                list.remove(size);
            }
        }
    }

    public boolean isWithinTop(int value){
        return value >= this.min;
    }

    public void destroy() { list.clear(); }

}