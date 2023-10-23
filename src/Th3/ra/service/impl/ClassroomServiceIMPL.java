package Th3.ra.service.impl;

import Th3.ra.model.Classroom;
import Th3.ra.service.IClassroomService;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {
    static List<Classroom> classroomList = new ArrayList<>();

    @Override
    public List<Classroom> findAll() {
        return null;
    }

    @Override
    public void save(Classroom classroom) {

    }

    @Override
    public void update(Classroom classroom) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Classroom findById(int id) {
        return null;
    }
}
