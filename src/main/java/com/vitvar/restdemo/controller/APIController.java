package com.vitvar.restdemo.controller;

import com.vitvar.restdemo.Dataset;
import com.vitvar.restdemo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Collection;

@RestController
@RequestMapping("/data")
public class APIController {


    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseBody
    public void reset() {
        Dataset.reset();
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Collection<Student> getAllStudents(@RequestParam(value = "name", required = false) String name) {
        return Dataset.allStudents(name);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        return Dataset.getStudent(id);
    }

    @RequestMapping(value = "/students/{id}/", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeStudent(@PathVariable int id) {
        Dataset.removeStudent(id);
    }

    @RequestMapping(value = "/students/{id}/", method = RequestMethod.PUT)
    @ResponseBody
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        Dataset.updateStudent(id, student);
    }

    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student, HttpServletResponse resp) {
        Dataset.createStudent(student);
        resp.addHeader("Location", student.link().href());
    }

}
