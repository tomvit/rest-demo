package com.vitvar.restdemo.controller;

import com.vitvar.restdemo.Dataset;
import com.vitvar.restdemo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/data")
public class APIController {


    @RequestMapping(value = "/students", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Collection<Student> getAllStudents(@RequestParam(value = "name", required = false) String name) {
        return Dataset.allStudents(name);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Student getStudent(@PathVariable String id) {
        return Dataset.getStudent(id);
    }

    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student, HttpServletResponse resp) {
        Dataset.addStudent(student);
        resp.addHeader("Location", student.link().href());
    }

}
