package Th3.ra.view;

import Th3.ra.config.Config;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("********************** SCHOOL-MANAGEMENT ************************");
            System.out.println("1. quan li lop hoc");
            System.out.println("2. quan li sinh vien");
            System.out.println("3. quan li mon hoc");
            System.out.println("4. quan li diem");
            System.out.println("5. thoat");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    new ClassroomManagement().menu();
                    break;
                case 2:
                    new StudentManagement().menu();
                    break;
                case 3:
                    new SubjectManagement().menu();
                    break;
                case 4:
                    new MarkManagement().menu();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }
}
