package Entities;

import android.annotation.SuppressLint;
import android.media.Image;

import java.util.Date;
import java.util.Objects;

public class Baby {
    private String name;
    private double weight;
    private double height;
    private String dadName;
    private String momName;
    private Date birthday;
    private Health healthInfo;
    private Food foodInfo;
    private Journal journal;
    private Image profilePicture;

    public Baby(String name, String dadName, String momName,double height, double weight, Date birthday) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.dadName = dadName;
        this.momName = momName;
        this.birthday = birthday;
        this.healthInfo = new Health();
        this.foodInfo = new Food();
        this.journal = new Journal();
    }

    public Baby(String name, String dadName, String momName,double height, double weight, Date birthday, Health healthInfo, Food foodInfo) {
        this.name = name;
        this.dadName = dadName;
        this.momName = momName;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
        this.healthInfo = healthInfo;
        this.foodInfo = foodInfo;
        this.journal = new Journal();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDadName() {
        return dadName;
    }

    public void setDadName(String dadName) {
        this.dadName = dadName;
    }

    public String getMomName() {
        return momName;
    }

    public void setMomName(String momName) {
        this.momName = momName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Health getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(Health healthInfo) {
        this.healthInfo = healthInfo;
    }

    public Food getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(Food foodInfo) {
        this.foodInfo = foodInfo;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return birthday == baby.birthday &&
                Objects.equals(name, baby.name) &&
                Objects.equals(dadName, baby.dadName) &&
                Objects.equals(momName, baby.momName) &&
                Objects.equals(healthInfo, baby.healthInfo) &&
                Objects.equals(foodInfo, baby.foodInfo) &&
                Objects.equals(journal, baby.journal);
    }

    @SuppressLint("NewApi")
    @Override
    public int hashCode() {
        return Objects.hash(name, dadName, momName, birthday, healthInfo, foodInfo, journal);
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", dadName='" + dadName + '\'' +
                ", momName='" + momName + '\'' +
                ", birthday=" + birthday +
                ", healthInfo=" + healthInfo +
                ", foodInfo=" + foodInfo +
                ", journal=" + journal +
                ", profilePicture=" + profilePicture +
                '}';
    }
}
