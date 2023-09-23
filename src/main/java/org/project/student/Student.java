package org.project.student;

public class Student {

    private String surname;
    private String name;
    private String phoneNumber;
    private int classID;
    private String classData;
    private String password;
    private String gender;   // "Male" / "Female"

    public Student() {
    }
    public Student(String surname, String name, String phoneNumber, int classID) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.classID = classID;
    }
    public Student(String surname, String name, String phoneNumber, int classID, String gender, String password) {
        if(!gender.equals("Male") && !gender.equals("Female")) throw new IllegalArgumentException("gender to input is incorrect");
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.classID = classID;
        this.gender = gender;
        this.password = password;
    }
    public Student(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
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

    public String getClassData() {
        return classData;
    }

    public void setClassData(String classData) {
        this.classData = classData;
    }

    public String getPassword() {
        return password;
    }
    public String getGender() {
        return gender;
    }
}
