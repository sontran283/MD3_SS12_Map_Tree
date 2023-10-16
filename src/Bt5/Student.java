package Bt5;

import java.util.Scanner;

public class Student {
    // Tạo ra 1 class Student có thuộc tính sau:
    // int id;
    // String name;
    // int age;
    // boolean status;
    // Viết 1 chương trình cho phép thêm vào danh sách sinh viên
    // Mỗi khi thêm vào cần sắp xếp lại danh sách theo thứ tự alphabet
    // Hiển thị ra danh sách sinh viên

    private static int idCount = 1;
    private int id;
    private String name;
    private int age;
    private boolean status;

    public Student() {
        this.id = idCount++;
    }

    public Student(int id, String name, int age, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin hoc sinh");

        System.out.println("nhap ten: ");
        this.name = scanner.nextLine();

        System.out.println("nhap tuoi: ");
        this.age = Integer.parseInt(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("" +
                "Student{" + "id=" + id + "" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}');
    }
}
