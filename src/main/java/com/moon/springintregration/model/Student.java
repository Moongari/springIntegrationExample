package com.moon.springintregration.model;


import org.springframework.integration.annotation.ServiceActivator;

import java.io.Serializable;

public class Student implements Serializable {

    private  int id;
    private  String name;
    private  String school;


    public Student(){}

    public Student(int id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", School='" + school + '\'' +
                '}';
    }
}
