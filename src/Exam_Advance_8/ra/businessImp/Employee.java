package Exam_Advance_8.ra.businessImp;

import Exam_Advance_8.ra.business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String Id;
    private String Name;
    private int Year;
    private float Rate;
    private float Commission;
    private float Salary;
    private boolean Status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        Id = id;
        Name = name;
        Year = year;
        Rate = rate;
        Commission = commission;
        Salary = salary;
        Status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("nhap thong tin cho nhan vien: ");

        System.out.println("nhap ten nhan vien");
        this.Name = scanner.nextLine();

        System.out.println("nhap nam sinh nhan vien");
        this.Year = Integer.parseInt(scanner.nextLine());

        System.out.println("nhap he so luong nhan vien");
        this.Rate = Float.parseFloat(scanner.nextLine());

        System.out.println("nhap hoa hong cua nhan vien hang thang");
        this.Commission = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println(
                "Employee{" +
                        "Id='" + Id + '\'' +
                        ", Name='" + Name + '\'' +
                        ", Year=" + Year +
                        ", Rate=" + Rate +
                        ", Commission=" + Commission +
                        ", Salary=" + Salary +
                        ", Status=" + Status +
                        '};
        );
    }

    public void calSalary() {
//        return this.Rate * super.BASIC_SALARY + this.Commission;
    }
}
