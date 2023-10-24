package Th3.ra.service.impl;

import Th3.ra.model.Classroom;
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
        SubjectList.add(subject);
    }

    @Override
    public void update(Subject subject) {
        Subject subjectEdit = findById(subject.getSubjectId());
        subjectEdit.setSubjectName(subject.getSubjectName());
    }

    @Override
    public void deleteById(int id) {
        Subject subjectDelete = findById(id);
        SubjectList.remove(subjectDelete);
    }

    @Override
    public Subject findById(int id) {
        for (Subject subject : SubjectList) {
            if (subject.getSubjectId() == id) {
                return subject;
            }
        }
        return null;
    }
}
