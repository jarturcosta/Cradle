package Entities;

import java.util.Date;

public class BottleFeedingEntry extends FeedingEntry {

    private int volume;

    public BottleFeedingEntry(Date timeOfFeeding, int totalDurationOfFeeding, int volume) {
        super(timeOfFeeding, totalDurationOfFeeding);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + "BottleFeedingEntry{" +
                "volume=" + volume +
                '}';
    }
}
