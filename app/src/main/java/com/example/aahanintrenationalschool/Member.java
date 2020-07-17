package com.example.aahanintrenationalschool;

public class Member {
    String fname;
    String lname;
    String Designation;
    String Email;
    String Password;
    String country;
    String religion;
    String mno;
    String dob;
    String gender;



    public Member(String fname, String lname, String designation, String email, String password, String country, String religion, String mno, String dob, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.Designation = designation;
        this.Email = email;
        this.Password = password;
        this.country = country;
        this.religion = religion;
        this.mno = mno;
        this.dob = dob;
        this.gender = gender;
    }



    public Member() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
