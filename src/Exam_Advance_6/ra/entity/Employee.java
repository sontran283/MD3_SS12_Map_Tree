package Exam_Advance_6.ra.entity;

import java.util.Scanner;

public class Employee {
    private static int idCount = 1;
    private int empId;
    private String empName;
    private String birthyear;
    private String phone;
    private String email;
    private boolean empStatus;

    public Employee() {
        this.empId = idCount++;
    }

    public Employee(int empId, String empName, String birthyear, String phone, String email, boolean empStatus) {
        this.empId = empId;
        this.empName = empName;
        this.birthyear = birthyear;
        this.phone = phone;
        this.email = email;
        this.empStatus = empStatus;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Employee.idCount = idCount;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(boolean empStatus) {
        this.empStatus = empStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin");

        System.out.println("nhap ten nhan vien: ");
        this.empName = scanner.nextLine();

        System.out.println("nhap nam sinh: ");
        this.birthyear = scanner.nextLine();

        System.out.println("nhap so dien thoai: ");
        this.phone = scanner.nextLine();

        System.out.println("nhap email: ");
        this.email = scanner.nextLine();

        System.out.println("nhap trang thai cua ban: ");
        System.out.println("chon 0_ Đang làm việc");
        System.out.println("chon 1_ Nghỉ việc");
        System.out.println("chon 2_ Nghỉ chế độ");
        this.empStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println(
                "Employee{" +
                        "empId=" + empId +
                        ", empName='" + empName + '\'' +
                        ", birthyear='" + birthyear + '\'' +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        ", empStatus=" + empStatus +
                        '}'
        );
    }
}
