package AtClass.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class DemoTreeMap {
    // co che hoat dong khac nhau
    // hashMap danh chi so co key, ko dam bao thu tu them vao
    // LinkedHashMap, co dam bao thu tu them vao
    // TreeMap cay nhi phan de sap xep, dam bao duoc thu tu them vao , sap xep tu nhien

    public static void main(String[] args) {
        StudentComparator comparator = new StudentComparator();
        Map<Student, Student> studentMap = new TreeMap<>(comparator);

        Student student1 = new Student(1);
        Student student2 = new Student(2);

        studentMap.put(student2, student2);
        studentMap.put(student1, student1);
    }
}
