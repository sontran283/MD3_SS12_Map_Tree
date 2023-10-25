package Th3.ra.service.impl;

import Th3.ra.config.WriteReadFile;
import Th3.ra.model.Classroom;
import Th3.ra.model.Student;
import Th3.ra.model.Subject;
import Th3.ra.service.ISubjectService;

import java.util.ArrayList;
import java.util.List;

import static Th3.ra.service.impl.ClassroomServiceIMPL.writeReadFile;

public class SubjectServiceIMPL implements ISubjectService {
    static WriteReadFile<Subject> writeReadFile = new WriteReadFile<>();
    public static List<Subject> SubjectList;

    static {
        SubjectList = writeReadFile.readFile(WriteReadFile.PATH_SUBJECT);
        SubjectList = (SubjectList == null) ? new ArrayList<>() : SubjectList;
    }

    @Override
    public List<Subject> findAll() {
        return SubjectList;
    }

    @Override
    public void save(Subject subject) {
        SubjectList.add(subject);
        updateData();
    }

    @Override
    public void update(Subject subject) {
        Subject subjectEdit = findById(subject.getSubjectId());
        subjectEdit.setSubjectName(subject.getSubjectName());
        updateData();
    }

    @Override
    public void deleteById(int id) {
        Subject subjectDelete = findById(id);
        SubjectList.remove(subjectDelete);
        updateData();
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

    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_SUBJECT, findAll());
    }
}
