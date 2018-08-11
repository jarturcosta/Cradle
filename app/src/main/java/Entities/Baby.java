package Entities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import java.util.Date;
import java.util.Objects;

public class Baby {
    private String name;
    private Gender gender;
    private double weight;
    private double height;
    private String dadName;
    private String momName;
    private Date birthday;
    private Health healthInfo;
    private Food foodInfo;
    private Journal journal;
    private ImageView profilePicture;

    public Baby(String name, Gender gender, String dadName, String momName,double height, double weight, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.dadName = dadName;
        this.momName = momName;
        this.birthday = birthday;
        this.healthInfo = new Health();
        this.foodInfo = new Food();
        this.journal = new Journal();
    }

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


    public Baby(String name, Gender gender, String dadName, String momName, double height, double weight, Date birthday, Health healthInfo, Food foodInfo) {
        this.name = name;
        this.gender = gender;
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

    public ImageView getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ImageView profilePicture) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return Double.compare(baby.weight, weight) == 0 &&
                Double.compare(baby.height, height) == 0 &&
                Objects.equals(name, baby.name) &&
                gender == baby.gender &&
                Objects.equals(dadName, baby.dadName) &&
                Objects.equals(momName, baby.momName) &&
                Objects.equals(birthday, baby.birthday) &&
                Objects.equals(healthInfo, baby.healthInfo) &&
                Objects.equals(foodInfo, baby.foodInfo) &&
                Objects.equals(journal, baby.journal) &&
                Objects.equals(profilePicture, baby.profilePicture);
    }

    @SuppressLint("NewApi")
    @Override
    public int hashCode() {

        return Objects.hash(name, gender, weight, height, dadName, momName, birthday, healthInfo, foodInfo, journal, profilePicture);
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
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
