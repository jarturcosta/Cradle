package Entities;

import android.location.Location;

import java.util.Date;

public class Appointment {

    private Date timeOfAppointment;
    private String local;
    private Location location;
    private String doctor;
    private String description;

    public Appointment(Date timeOfAppointment, String local, Location location, String doctor, String description) {
        this.timeOfAppointment = timeOfAppointment;
        this.local = local;
        this.location = location;
        this.doctor = doctor;
        this.description = description;
    }

    public Appointment(Date timeOfAppointment, String local, String doctor, String description) {
        this.timeOfAppointment = timeOfAppointment;
        this.local = local;
        this.doctor = doctor;
        this.description = description;
    }

    public Date getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(Date timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "timeOfAppointment=" + timeOfAppointment +
                ", local='" + local + '\'' +
                ", doctor='" + doctor + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
