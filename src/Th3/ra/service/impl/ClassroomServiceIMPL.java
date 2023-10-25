package Th3.ra.service.impl;

import Th3.ra.config.WriteReadFile;
import Th3.ra.model.Classroom;
import Th3.ra.service.IClassroomService;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {
    static WriteReadFile<Classroom> writeReadFile = new WriteReadFile<>();
    public  static List<Classroom> classroomList;

    static {
        classroomList = writeReadFile.readFile(WriteReadFile.PATH_CLASSROOM);
        classroomList = (classroomList == null) ? new ArrayList<>() : classroomList;
    }


    @Override
    public List<Classroom> findAll() {
        return classroomList;
    }

    @Override
    public void save(Classroom classroom) {
        classroomList.add(classroom);
        writeReadFile.writeFile(WriteReadFile.PATH_CLASSROOM, findAll());
    }

    @Override
    public void update(Classroom classroom) {
        Classroom classroomEdit = findById(classroom.getClassroomId());
        classroomEdit.setClassroomName(classroom.getClassroomName());
        classroomEdit.setStatus(classroom.isStatus());
        updateData();
    }

    @Override
    public void deleteById(int id) {
        Classroom classroomDelete = findById(id);
        classroomList.remove(classroomDelete);

        writeReadFile.writeFile(WriteReadFile.PATH_CLASSROOM, findAll());
    }

    @Override
    public Classroom findById(int id) {
        for (Classroom classroom : classroomList) {
            if (classroom.getClassroomId() == id) {
                return classroom;
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_CLASSROOM, findAll());
    }
}
