package com.example.cis183_example02_objectsarraylists;

public class Employee
{
    //username, firstname, lastname, email
    private String username;
    private String fname;
    private String lname;
    private String email;

    //constructor
    public Employee()
    {

    }

    //overloaded constructor
    public Employee(String u, String f, String l, String e)
    {
        username = u;
        fname = f;
        lname = l;
        email = e;
    }

    //===============================================
    //     Getters/Setters
    //===============================================

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
