package Th3.ra.service.impl;

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
        StudentList.add(student);
    }

    @Override
    public void update(Student student) {
        Student studentEdit = findById(student.getStudentId());
        studentEdit.setStudentName(student.getStudentName());
        studentEdit.setClassroom(student.getClassroom());
        studentEdit.setAddress(student.getAddress());
        studentEdit.setPhone(student.getPhone());
    }

    @Override
    public void deleteById(int id) {
        Student studentDelete = findById(id);
        StudentList.remove(studentDelete);
    }

    @Override
    public Student findById(int id) {
        for (Student student : StudentList) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }
}
