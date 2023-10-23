package Th3.ra.service;

import Th3.ra.model.Student;

import java.util.List;

public interface IStudentService extends IGeneric<Student> {
    List<Student> findByName(String name);

}
