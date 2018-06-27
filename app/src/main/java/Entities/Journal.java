package Entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal {
    private List<JournalEntry> entryList;

    public Journal() {
        entryList = new ArrayList<JournalEntry>();
    }

    public List<JournalEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<JournalEntry> entryList) {
        this.entryList = entryList;
    }

    public void addJournalEntry(String title, String entryBody, String author) {
        entryList.add(new JournalEntry(new Date(),title,entryBody,author));
    }

    @Override
    public String toString() {
        return "Journal{" +
                "entryList=" + entryList +
                '}';
    }
}
