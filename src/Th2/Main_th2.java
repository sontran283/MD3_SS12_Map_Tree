package Th2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main_th2 {
    // Phân biệt cách dùng HashMap, HashSet
    // Tạo một lớp Student chứa thông tin về tên, tuổi, địa chỉ.
    // Sử dụng HashMap và HashSet để lưu các đối tượng Student.
    // Hiển thị tất cả thông tin sau khi đã lưu.
    // Bước 1: Tạo lớp lớp Student trong package
    // Bước 2: Tạo class Main chứa hàm main để lưu danh sách sinh viên
    public static void main(String[] args) {
        Student student1 = new Student("hoang anh", 12, "ha noi");
        Student student2 = new Student("van toan", 13, "ho chi minh");
        Student student3 = new Student("nguyen tien", 14, "da nang");

        System.out.println("___ Map ___");
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);
        studentMap.put(4, student1);

        for (Map.Entry<Integer, Student> studentEntry : studentMap.entrySet()) {
            System.out.println("test1: " + studentEntry.toString());
        }
        System.out.println("___ set ___");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student1);

        for (Student student : studentSet) {
            System.out.println("test2: " + student.toString());
        }
    }
}
