package sample;

import java.util.List;

public class Player {

    //variables
    String name;
    String country;
    int age;
    double height;
    String club;
    String position;
    int jerseyNumber;
    double salary;

    //default constructor
    Player() {

    }

    // constructor
    Player(String name, String country, int age, double height, String club, String position, int jerseyNumber, double salary) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.club = club;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.salary = salary;
    }

    //set method
    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    //get method

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public double getSalary() {
        return salary;
    }

}
