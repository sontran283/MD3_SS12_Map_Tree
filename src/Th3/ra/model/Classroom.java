package Th3.ra.model;

import java.util.Scanner;

public class Classroom {
    private static int nextClassroomId = 1;
    private int classroomId;
    private String classroomName;
    private boolean status;

    public Classroom() {
        this.classroomId = nextClassroomId++;
    }

    public Classroom(String classroomName, boolean status) {
        this.classroomId = nextClassroomId++;
        this.classroomName = classroomName;
        this.status = status;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên lớp học: ");
        classroomName = scanner.nextLine();

        boolean validStatus = false;
        while (!validStatus) {
            System.out.print("Nhập trạng thái lớp học (true - đang học / false - kết thúc): ");
            try {
                status = Boolean.parseBoolean(scanner.nextLine());
                validStatus = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Trạng thái không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    public void displayData() {
        System.out.println("Thông tin lớp học:");
        System.out.println("Mã lớp học: " + classroomId);
        System.out.println("Tên lớp học: " + classroomName);
        System.out.println("Trạng thái lớp học: " + (status ? "Đang học" : "Kết thúc"));
    }
}