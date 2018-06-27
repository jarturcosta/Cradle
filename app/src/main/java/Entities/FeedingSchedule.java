package Entities;

import java.util.ArrayList;
import java.util.List;

public class FeedingSchedule {

    private List<FeedingEntry> feedingEntryList;

    public FeedingSchedule() {
        feedingEntryList = new ArrayList<>();
    }

    public List<FeedingEntry> getFeedingEntryList() {
        return feedingEntryList;
    }

    public void setFeedingEntryList(List<FeedingEntry> feedingEntryList) {
        this.feedingEntryList = feedingEntryList;
    }

    @Override
    public String toString() {
        return "FeedingSchedule{" +
                "feedingEntryList=" + feedingEntryList +
                '}';
    }
}
