package Entities;

import java.util.Date;

public class Sleep {
    private Date start;
    private Date end;
    private int numberOfInterruptions;
    private Long timeOfSleep;

    public Sleep(Date start, Date end) {
        this.start = start;
        this.end = end;
        this.numberOfInterruptions = 0;
        this.timeOfSleep = (end.getTime()-start.getTime())/1000;
    }

    public Sleep(Date start, Date end, int numberOfInterruptions) {
        this.start = start;
        this.end = end;
        this.numberOfInterruptions = numberOfInterruptions;
        this.timeOfSleep = (end.getTime()-start.getTime())/1000;
    }

    public void addInterruption(long duration) {
        numberOfInterruptions++;
        timeOfSleep-=duration;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getNumberOfInterruptions() {
        return numberOfInterruptions;
    }

    public void setNumberOfInterruptions(int numberOfInterruptions) {
        this.numberOfInterruptions = numberOfInterruptions;
    }

    public Long getTimeOfSleep() {
        return timeOfSleep;
    }

    public void setTimeOfSleep(Long timeOfSleep) {
        this.timeOfSleep = timeOfSleep;
    }

    @Override
    public String toString() {
        return "Sleep{" +
                "start=" + start +
                ", end=" + end +
                ", numberOfInterruptions=" + numberOfInterruptions +
                ", timeOfSleep=" + timeOfSleep +
                '}';
    }
}
