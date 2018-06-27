package Entities;

import java.util.Date;

public class Vaccine {

    private String name;
    private Date time;
    private String description;

    public Vaccine(String name, Date time, String description) {
        this.name = name;
        this.time = time;
        this.description = description;
    }

    public Vaccine(String name, Date time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", description='" + description + '\'' +
                '}';
    }
}
