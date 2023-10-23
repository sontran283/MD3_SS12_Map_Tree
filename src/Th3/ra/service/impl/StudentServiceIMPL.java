package Th3.ra.service.impl;

import Th3.ra.model.Mark;
import Th3.ra.model.Student;
import Th3.ra.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {

    static List<Student> StudentList = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        return StudentList;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }
}
