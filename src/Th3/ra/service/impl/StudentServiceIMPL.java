package Th3.ra.service.impl;

import Th3.ra.config.WriteReadFile;
import Th3.ra.model.Student;
import Th3.ra.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    static WriteReadFile<Student> writeReadFile = new WriteReadFile<>();

    public static List<Student> StudentList ;

    static {
        StudentList = writeReadFile.readFile(WriteReadFile.PATH_STUDENT);
        StudentList = (StudentList == null) ? new ArrayList<>() : StudentList;
    }

    @Override
    public List<Student> findAll() {
        return StudentList;
    }

    @Override
    public void save(Student student) {
        StudentList.add(student);
        updateData();
    }

    @Override
    public void update(Student student) {
        Student studentEdit = findById(student.getStudentId());
        studentEdit.setStudentName(student.getStudentName());
        studentEdit.setClassroom(student.getClassroom());
        studentEdit.setAddress(student.getAddress());
        studentEdit.setPhone(student.getPhone());
        updateData();
    }

    @Override
    public void deleteById(int id) {
        Student studentDelete = findById(id);
        StudentList.remove(studentDelete);
        updateData();
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
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_STUDENT, findAll());
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }
}
