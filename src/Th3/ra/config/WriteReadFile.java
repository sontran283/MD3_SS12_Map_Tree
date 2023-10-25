package Th3.ra.config;

import java.io.*;
import java.util.List;

public class WriteReadFile<T> {
    public static final String PATH_STUDENT = "src/Th3/ra/config/student.txt";
    public static final String PATH_CLASSROOM = "src/Th3/ra/config/classroom.txt";
    public static final String PATH_MARK = "src/Th3/ra/config/mark.txt";
    public static final String PATH_SUBJECT = "src/Th3/ra/config/subject.txt";

    public void writeFile(String PATH_FILE, List<T> list) {
        File file = new File(PATH_FILE);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
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
            if (fis != null) {
                fis.close();
            }
            if (ois!=null){
                ois.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("ko tim thay file");
        } catch (IOException e) {
            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
