package model;

public class Employee {
    private final String name;
    private final String secondName;
    private final char gender;
    private final String city;

    public Employee(String name, String secondName, char gender, String city) {
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.city = city;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                '}';
    }
}