package com.navas.examen.persona.domain.entity;

public class Persona {
    private String name;
    private String lastname;
    private int city;
    private String address;
    private int age;
    private String email;
    private int gender;

    // constructor
    public Persona() {
    }

    public Persona(String name, String lastname, int city, String address, int age, String email, int gender) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.address = address;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }
    
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
