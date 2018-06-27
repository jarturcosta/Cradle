package Entities;

import android.annotation.SuppressLint;

import java.util.Date;
import java.util.Objects;

public class JournalEntry {

    private Date entryDate;
    private String title;
    private String entryBody;
    private String author;

    public JournalEntry(Date entryDate, String entryBody) {
        this.entryDate = entryDate;
        this.entryBody = entryBody;
    }

    public JournalEntry(Date entryDate, String title, String entryBody) {
        this.entryDate = entryDate;
        this.title = title;
        this.entryBody = entryBody;
    }

    public JournalEntry(String title, String entryBody, String author) {
        this.title = title;
        this.entryBody = entryBody;
        this.author = author;
    }

    public JournalEntry(Date entryDate, String title, String entryBody, String author) {
        this.entryDate = entryDate;
        this.title = title;
        this.entryBody = entryBody;
        this.author = author;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntryBody() {
        return entryBody;
    }

    public void setEntryBody(String entryBody) {
        this.entryBody = entryBody;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalEntry that = (JournalEntry) o;
        return Objects.equals(entryDate, that.entryDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(entryBody, that.entryBody) &&
                Objects.equals(author, that.author);
    }

    @SuppressLint("NewApi")
    @Override
    public int hashCode() {
        return Objects.hash(entryDate, title, entryBody, author);
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "entryDate=" + entryDate +
                ", title='" + title + '\'' +
                ", entryBody='" + entryBody + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
