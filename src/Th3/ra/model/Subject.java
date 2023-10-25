package Th3.ra.model;

import java.io.Serializable;
import java.util.Scanner;

import static Th3.ra.service.impl.StudentServiceIMPL.StudentList;
import static Th3.ra.service.impl.SubjectServiceIMPL.SubjectList;

public class Subject implements Serializable {
    private int subjectId;
    private String subjectName;

    public Subject() {
        if (SubjectList.isEmpty()) {
            this.subjectId = 1;
        } else {
            this.subjectId = (SubjectList.get(SubjectList.size() - 1).getSubjectId()) + 1;
        }
    }

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }


    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}