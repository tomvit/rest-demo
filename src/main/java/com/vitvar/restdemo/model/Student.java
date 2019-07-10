package com.vitvar.restdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class Student {
    private static int counter = 1;

    @JsonProperty(value = "id")
    public int id;

    @JsonProperty(value = "name")
    public String name;

    @JsonProperty(value = "city")
    public String city;

    public AtomLink link;

    public Student() {
    }

    public Student(int id) {
        this.id=id;
    }

    public Student(String name, String city) {
        this.id=Student.generateId();
        this.name=name;
        this.city=city;
    }

    public int id() {
        return id;
    }

    @JsonView()
    public AtomLink link() {
        if (link==null)
            link=new AtomLink("self", "/data/students/" + this.id + "/");
        return link;
    }

    public Student update(Student s) {
        this.name = s.name;
        this.city = s.city;
        return this;
    }

    public static int generateId() {
        return Student.counter++;
    }


}
