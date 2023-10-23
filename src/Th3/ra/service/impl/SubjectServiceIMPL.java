package Th3.ra.service.impl;

import Th3.ra.model.Student;
import Th3.ra.model.Subject;
import Th3.ra.service.ISubjectService;

import java.util.ArrayList;
import java.util.List;

public class SubjectServiceIMPL implements ISubjectService {
    static List<Subject> SubjectList = new ArrayList<>();

    @Override
    public List<Subject> findAll() {
        return null;
    }

    @Override
    public void save(Subject subject) {

    }

    @Override
    public void update(Subject subject) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Subject findById(int id) {
        return null;
    }
}
