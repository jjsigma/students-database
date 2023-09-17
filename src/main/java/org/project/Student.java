package org.project;

public class Student {
    private String surname;
    private String name;
    private String phoneNumber;
    private int classID;

    public Student() {
    }
    public Student(String surname, String name, String phoneNumber, int classID) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.classID = classID;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getClassID() {
        return classID;
    }
}
