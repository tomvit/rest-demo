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
    private static Map<Integer, Student> students = new HashMap();

    static {
        reset();
    }

    public static void reset() {
        students.clear();
        addStudent(new Student("Tomas Petricek", "Liberec"));
        addStudent(new Student("David Sverma", "Tel Aviv"));
        addStudent(new Student("Petr Machacek", "Gablonz"));
    }

    public static void addStudent(Student student) {
        Dataset.students.put(student.id(), student);
    }

    public static void createStudent(Student student) {
        Student s = new Student(Student.generateId()).update(student);
        Dataset.students.put(s.id(), s);
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

    public static Student getStudent(int id) {
        Student student=students.get(id);
        if (student==null)
            throw new Exceptions.ResourceNotFoundException(String.format("Student with id %s does not exist!", id));
        return student;
    }

    public static void removeStudent(int id) {
        Student student=students.get(id);
        if (student==null)
            throw new Exceptions.ResourceNotFoundException(String.format("Student with id %s does not exist!", id));
        students.remove(id);
    }

    public static void updateStudent(int id, Student student) {
        Student s = getStudent(id);
        if (s==null)
            throw new Exceptions.ResourceNotFoundException(String.format("Student with id %s does not exist!", id));
        s.update(student);
    }

}
