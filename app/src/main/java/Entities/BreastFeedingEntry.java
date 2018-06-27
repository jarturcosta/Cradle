package Entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreastFeedingEntry extends FeedingEntry {

    private Breast currentBreast;
    private Breast startingBreast;
    private Map<Date,Breast> breastChangingTimes;

    public BreastFeedingEntry(Date timeOfFeeding, int totalDurationOfFeeding, Breast startingBreast) {
        super(timeOfFeeding, totalDurationOfFeeding);
        this.startingBreast = startingBreast;
        this.currentBreast = startingBreast;
        breastChangingTimes = new HashMap<>();
        breastChangingTimes.put(new Date(), startingBreast);
    }

    public void changeBreast() {
        if(currentBreast.equals(Breast.LEFT)) {
            currentBreast = Breast.RIGHT;
        } else {
            currentBreast = Breast.LEFT;
        }
        breastChangingTimes.put(new Date(), currentBreast);
    }

    public Breast getCurrentBreast() {
        return currentBreast;
    }

    public void setCurrentBreast(Breast currentBreast) {
        this.currentBreast = currentBreast;
    }

    public Breast getStartingBreast() {
        return startingBreast;
    }

    public void setStartingBreast(Breast startingBreast) {
        this.startingBreast = startingBreast;
    }

    public Map<Date, Breast> getBreastChangingTimes() {
        return breastChangingTimes;
    }

    public void setBreastChangingTimes(Map<Date, Breast> breastChangingTimes) {
        this.breastChangingTimes = breastChangingTimes;
    }

    @Override
    public String toString() {
        return super.toString() + "BreastFeedingEntry{" +
                "currentBreast=" + currentBreast +
                ", startingBreast=" + startingBreast +
                ", breastChangingTimes=" + breastChangingTimes +
                '}';
    }
}
