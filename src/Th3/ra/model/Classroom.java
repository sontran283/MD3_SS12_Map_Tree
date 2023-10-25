package Th3.ra.model;

import java.io.Serializable;

import static Th3.ra.service.impl.ClassroomServiceIMPL.*;

public class Classroom implements Serializable {
    private int classroomId;
    private String classroomName;
    private boolean status;

    public Classroom() {
        if (classroomList.isEmpty()) {
            this.classroomId = 1;
        } else {
            this.classroomId = (classroomList.get(classroomList.size() - 1).getClassroomId()) + 1;
        }
    }

    public Classroom(String classroomName, boolean status) {
        this.classroomName = classroomName;
        this.status = status;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", classroomName='" + classroomName + '\'' +
                ", status=" + status +
                '}';
    }
}