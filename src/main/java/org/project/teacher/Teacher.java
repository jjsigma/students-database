package org.project.teacher;

public class Teacher {
    private String surname;
    private String name;
    private String phoneNumber;
    private int subjectID;
    private String subjectData;
    private String password;

    public Teacher(String surname, String name, String phoneNumber, int subjectID, String password) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.subjectID = subjectID;
        this.password = phoneNumber;
    }
    public Teacher(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectData() {
        return subjectData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSubjectData(String subjectData) {
        this.subjectData = subjectData;
    }
}
