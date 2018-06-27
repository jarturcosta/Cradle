package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class FeedingEntry {

    private Date timeOfFeeding;
    private int totalDurationOfFeeding;
    private List<String> notes;

    public FeedingEntry(Date timeOfFeeding, int totalDurationOfFeeding) {
        this.timeOfFeeding = timeOfFeeding;
        this.totalDurationOfFeeding = totalDurationOfFeeding;
        this.notes = new ArrayList<>();
    }

    public void addNote(String note) {
        notes.add(note);
    }

    public void deleteNoteByIndex(int index) {
        notes.remove(index);
    }

    public Date getTimeOfFeeding() {
        return timeOfFeeding;
    }

    public void setTimeOfFeeding(Date timeOfFeeding) {
        this.timeOfFeeding = timeOfFeeding;
    }

    public int getTotalDurationOfFeeding() {
        return totalDurationOfFeeding;
    }

    public void setTotalDurationOfFeeding(int totalDurationOfFeeding) {
        this.totalDurationOfFeeding = totalDurationOfFeeding;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "FeedingEntry{" +
                "timeOfFeeding=" + timeOfFeeding +
                ", totalDurationOfFeeding=" + totalDurationOfFeeding +
                ", notes=" + notes +
                '}';
    }
}
