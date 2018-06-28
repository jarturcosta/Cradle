package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Health {

    private Map<String, Integer> pastDiseases;
    private List<String> currentDiseases;
    private List<Vaccine> vaccines;
    private List<Appointment> medicalAppointments;
    private String description;
    private List<Sleep> sleepList;
    private List<Diaper> diaperList;

    public Health(Map<String, Integer> pastDiseases, List<String> currentDiseases, List<Vaccine> vaccines, List<Appointment> medicalAppointments, String description, List<Sleep> sleepList, List<Diaper> diaperList) {
        this.pastDiseases = pastDiseases;
        this.currentDiseases = currentDiseases;
        this.vaccines = vaccines;
        this.medicalAppointments = medicalAppointments;
        this.description = description;
        this.sleepList = sleepList;
        this.diaperList = diaperList;
    }

    public Health(Map<String, Integer> pastDiseases, List<String> currentDiseases, List<Vaccine> vaccines, List<Appointment> medicalAppointments) {
        this.pastDiseases = pastDiseases;
        this.currentDiseases = currentDiseases;
        this.vaccines = vaccines;
        this.medicalAppointments = medicalAppointments;
        this.description = "";
        this.sleepList = new ArrayList<>();
        this.diaperList = new ArrayList<>();
    }

    public Health() {
        this.pastDiseases = new HashMap<>();
        this.currentDiseases = new ArrayList<>();
        this.vaccines = new ArrayList<>();
        this.medicalAppointments = new ArrayList<>();
        this.description = "";
        this.sleepList = new ArrayList<>();
        this.diaperList = new ArrayList<>();
    }

    public void addCurrentDisease(String disease) {
        currentDiseases.add(disease);
    }

    public void removeCurrentDisease(String disease) {
        if(pastDiseases.containsKey(disease)) {
            pastDiseases.put(disease,pastDiseases.get(disease)+1);
        } else {
            pastDiseases.put(disease,0);
        }
        currentDiseases.remove(disease);
    }


    public Map<String, Integer> getPastDiseases() {
        return pastDiseases;
    }

    public void setPastDiseases(Map<String, Integer> pastDiseases) {
        this.pastDiseases = pastDiseases;
    }

    public List<String> getCurrentDiseases() {
        return currentDiseases;
    }

    public void setCurrentDiseases(List<String> currentDiseases) {
        this.currentDiseases = currentDiseases;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public List<Appointment> getMedicalAppointments() {
        return medicalAppointments;
    }

    public void setMedicalAppointments(List<Appointment> medicalAppointments) {
        this.medicalAppointments = medicalAppointments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sleep> getSleepList() {
        return sleepList;
    }

    public void setSleepList(List<Sleep> sleepList) {
        this.sleepList = sleepList;
    }

    public List<Diaper> getDiaperList() {
        return diaperList;
    }

    public void setDiaperList(List<Diaper> diaperList) {
        this.diaperList = diaperList;
    }

    @Override
    public String toString() {
        return "Health{" +
                "pastDiseases=" + pastDiseases +
                ", currentDiseases=" + currentDiseases +
                ", vaccines=" + vaccines +
                ", medicalAppointments=" + medicalAppointments +
                ", description='" + description + '\'' +
                ", sleepList=" + sleepList +
                ", diaperList=" + diaperList +
                '}';
    }
}
