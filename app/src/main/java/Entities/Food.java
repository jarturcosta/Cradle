package Entities;

import java.util.List;

public class Food {
    private List<String> intolerances;
    private List<String> favorites;
    private FeedingSchedule feedingSchedule;

    public Food(List<String> intolerances, List<String> favorites) {
        this.intolerances = intolerances;
        this.favorites = favorites;
        this.feedingSchedule = new FeedingSchedule();
    }

    public Food() {
        this.feedingSchedule = new FeedingSchedule();
    }

    public List<String> getIntolerances() {
        return intolerances;
    }

    public void setIntolerances(List<String> intolerances) {
        this.intolerances = intolerances;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public FeedingSchedule getFeedingSchedule() {
        return feedingSchedule;
    }

    public void setFeedingSchedule(FeedingSchedule feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    @Override
    public String toString() {
        return "Food{" +
                "intolerances=" + intolerances +
                ", favorites=" + favorites +
                ", feedingSchedule=" + feedingSchedule +
                '}';
    }
}
