package Th3.ra.demo;

import java.io.*;
import java.util.List;

public class WriteReadFile<T> {
    public static final String PATH_STUDENT = "src/Th3/ra/file/student.txt";
    public static final String PATH_CLASSROOM = "src/Th3/ra/file/classroom.txt";
    public static final String PATH_MARK = "src/Th3/ra/file/mark.txt";
    public static final String PATH_SUBJECT = "src/Th3/ra/file/subject.txt";

    public void writeFile(String PATH_FILE, List<T> classroomList) {
        File file = new File(PATH_FILE);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(classroomList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("loi.");
        } catch (IOException e) {
            System.out.println("loi.");
        }
    }

    public List<T> readFile(String PATH_FILE) {
        File file = new File(PATH_FILE);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<T> list = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("ko tim thay file");
        } catch (IOException e) {
            System.out.println("file rong");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
