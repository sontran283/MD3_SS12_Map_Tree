package Bt5;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.CharSequence.compare;

public class Main_bt5 {
    public static void main(String[] args) {
        // tao ra mot class student co thuoc tinh id,name,age,status
        // viet chuong trinh cho phep them vao danh sach sinh vien
        // moi khi them vao can sap xep theo thu tu anphab
        // hien thi ra danh sach sinh vien

        Stack<Student> students = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so luong hoc sinh can them: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            Student student = new Student();
            student.inputData();
            students.add(student);
        }

        System.out.println("danh sach sinh vien");
        for (Student student : students) {
            student.displayData();
        }

        students.sort((student1, student2) -> compare(student1.getName(), student2.getName()));
        System.out.println("sap xep anphab thanh cong ");
        for (Student student : students) {
            student.displayData();
        }
    }
}
