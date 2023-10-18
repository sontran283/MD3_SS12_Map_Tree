package Exam_Advance_6.ra.entity;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

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

        // Nhập empName
        while (true) {
            System.out.print("Nhập empName (độ dài từ 10-50 ký tự): ");
            String input = scanner.nextLine();

            if (input.length() >= 10 && input.length() <= 50) {
                this.empName = input;
                break;
            } else {
                System.out.println("Lỗi: empName không hợp lệ. Vui lòng nhập lại.");
            }
        }


        // Nhập birthyear
        int currentYear = Year.now().getValue();
        while (true) {
            System.out.print("Nhập birthyear (năm sinh phải nhỏ hơn năm hiện tại): ");
            String input = scanner.nextLine();

            if (input.length() == 4 && Pattern.matches("\\d{4}", input)) {
                int year = Integer.parseInt(input);

                if (year < currentYear) {
                    this.birthyear = input;
                    break;
                } else {
                    System.out.println("Lỗi: birthyear phải nhỏ hơn năm hiện tại. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Lỗi: birthyear không hợp lệ. Vui lòng nhập lại.");
            }
        }


        // Nhập phone
        while (true) {
            System.out.print("Nhập phone (định dạng theo số điện thoại di động tại Việt Nam): ");
            String input = scanner.nextLine();

            if (Pattern.matches("0\\d{9}", input)) {
                this.phone = input;
                break;
            } else {
                System.out.println("Lỗi: phone không hợp lệ. Vui lòng nhập lại.");
            }
        }


        // Nhập email
        while (true) {
            System.out.print("Nhập email: ");
            String input = scanner.nextLine();

            if (Pattern.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}", input)) {
                this.email = input;
                break;
            } else {
                System.out.println("Lỗi: email không hợp lệ. Vui lòng nhập lại.");
            }
        }

        // Nhập empStatus
        while (true) {
            System.out.print("Nhập empStatus (0 - Đang làm việc, 1 - Nghỉ việc, 2 - Nghỉ chế độ): ");
            String input = scanner.nextLine();

            if (input.equals("0") || input.equals("1") || input.equals("2")) {
                this.empStatus = Boolean.parseBoolean(input);
                break;
            } else {
                System.out.println("Lỗi: empStatus không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    public void displayData() {
        System.out.println("Thông tin nhân viên:");
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Birth Year: " + birthyear);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Status: " + empStatus);
    }
}
