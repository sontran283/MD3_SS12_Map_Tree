package Th3.ra.service.impl;

import Th3.ra.config.WriteReadFile;
import Th3.ra.model.Mark;
import Th3.ra.service.IMarkService;

import java.util.ArrayList;
import java.util.List;

public class MarkServiceIMPL implements IMarkService {
    static WriteReadFile<Mark> writeReadFile = new WriteReadFile<>();

    public static List<Mark> MarkList;

    static {
        MarkList = writeReadFile.readFile(WriteReadFile.PATH_MARK);
        MarkList = (MarkList == null) ? new ArrayList<>() : MarkList;
    }

    @Override
    public List<Mark> findAll() {
        return MarkList;
    }

    @Override
    public void save(Mark mark) {
        MarkList.add(mark);
        updateData();
    }

    @Override
    public void update(Mark mark) {
        Mark markEdit = findById(mark.getMarkId());
        markEdit.setPoint(mark.getPoint());
        markEdit.setSubject(mark.getSubject());
        markEdit.setStudent(mark.getStudent());
        updateData();
    }

    @Override
    public void deleteById(int id) {
        Mark markDelete = findById(id);
        MarkList.remove(markDelete);
        updateData();
    }

    @Override
    public Mark findById(int id) {
        for (Mark mark : MarkList) {
            if (mark.getMarkId() == id) {
                return mark;
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_MARK, findAll());
    }
}
