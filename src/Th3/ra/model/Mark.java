package Th3.ra.model;

import java.io.Serializable;

import static Th3.ra.service.impl.ClassroomServiceIMPL.classroomList;
import static Th3.ra.service.impl.MarkServiceIMPL.MarkList;

public class Mark implements Serializable {
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    public Mark() {
        if (MarkList.isEmpty()) {
            this.markId = 1;
        } else {
            this.markId = (MarkList.get(MarkList.size() - 1).getMarkId()) + 1;
        }
    }

    public Mark(Student student, Subject subject, double point) {
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public int getMarkId() {
        return markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Th3.ra.model.Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", student=" + student +
                ", subject=" + subject +
                ", point=" + point +
                '}';
    }
}