package Th3.ra.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Classroom> classroomList = new ArrayList<>();
        WriteReadFile writeReadFile = new WriteReadFile();
        classroomList = writeReadFile.readFile(WriteReadFile.PATH_CLASSROOM);

//        classroomList.add(new Classroom(1, "JV06", true));
//        classroomList.add(new Classroom(2, "JV07", true));
//        classroomList.add(new Classroom(3, "JV08", true));
//        writeReadFile.writeFile(WriteReadFile.PATH_CLASSROOM, classroomList);

        for (Classroom classroom : classroomList) {
            System.out.println(classroom);
        }



        System.out.println("chuong trinh chay tiep");

    }
}
