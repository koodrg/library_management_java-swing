package models;

import java.util.Date;

public class Student {
    int id;
    String studentName;
    String userName;
    String password;
    int gender;
    Date dob;
    String major;
    String className;
    String contactNumber;
    public String email;
    
    public Student(int id, String studentName, String userName, String password, int gender, Date dob, String major, String className, String email , String contactNumber) {
        this.id = id;
        this.studentName = studentName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.major = major;
        this.className = className;
        this.contactNumber = contactNumber;
    }

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
