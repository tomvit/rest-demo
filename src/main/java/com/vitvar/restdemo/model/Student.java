package com.vitvar.restdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.stream.Collectors;

public class Student {
    @JsonProperty(value = "id")
    public String id;

    @JsonProperty(value = "name")
    public String name;

    @JsonProperty(value = "city")
    public String city;

    public AtomLink link;

    public Student() {
    }

    public Student(String id, String name, String city) {
        this.id=id;
        this.name=name;
        this.city=city;
    }

    @JsonView()
    public AtomLink link() {
        if (link==null)
            link=new AtomLink("self", "/data/students/" + this.id + "/");
        return link;
    }


}
