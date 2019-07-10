package com.vitvar.restdemo;

import com.vitvar.restdemo.model.Exceptions;
import com.vitvar.restdemo.model.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component("dataset")
@Configuration
public class Dataset {
    private static Map<String, Student> students = new HashMap();

    static {
        reset();
    }

    public static void reset() {
        students.clear();
        try {
            addStudent(new Student("1", "Tomas Petricek", "Liberec"));
            addStudent(new Student("2", "David Sverma", "Tel Aviv"));
            addStudent(new Student("3", "Petr Machacek", "Gablonz"));
        } catch (Exceptions.DataException e) {}
    }

    public static void addStudent(Student student) {
        if (Dataset.students.get(student.id)==null)
            Dataset.students.put(student.id, student);
        else
            throw new Exceptions.DataException(String.format("Student with id %s already exists!", student.id));
    }

    public static Collection<Student> allStudents(String name) {
        if (name != null) {
            //Predicate<Student> studentPredicate = student -> student.name.matches(name);
            return students.values()
                    .stream().filter(student -> student.name.matches(name))
                    .collect(Collectors.toList());
        } else
            return students.values();
    }

    public static Student getStudent(String id) {
        Student student=students.get(id);
        if (student==null)
            throw new Exceptions.ResourceNotFoundException(String.format("Student with id %s does not exist!", id));
        return student;
    }

    public static void removeStudent(String id) {
        Student student=students.get(id);
        if (student==null)
            throw new Exceptions.ResourceNotFoundException(String.format("Student with id %s does not exist!", id));
        students.remove(id);
    }

}
