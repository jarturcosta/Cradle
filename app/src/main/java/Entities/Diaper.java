package Entities;

import java.util.Date;

public class Diaper {

    private DiaperContent content;
    private Date timeOfCheck;
    private String description;

    public Diaper(DiaperContent content, Date timeOfCheck, String description) {
        this.content = content;
        this.timeOfCheck = timeOfCheck;
        this.description = description;
    }

    public Diaper(DiaperContent content, Date timeOfCheck) {
        this.content = content;
        this.timeOfCheck = timeOfCheck;
        this.description = "";
    }

    public DiaperContent getContent() {
        return content;
    }

    public void setContent(DiaperContent content) {
        this.content = content;
    }

    public Date getTimeOfCheck() {
        return timeOfCheck;
    }

    public void setTimeOfCheck(Date timeOfCheck) {
        this.timeOfCheck = timeOfCheck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Diaper{" +
                "content=" + content +
                ", timeOfCheck=" + timeOfCheck +
                ", description='" + description + '\'' +
                '}';
    }
}
