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
            System.out.println("1. Quản lý lớp học");
            System.out.println("2. Quản lý học sinh");
            System.out.println("3. Quản lý môn học");
            System.out.println("4. Quản lí điểm thi");
            System.out.println("0. Thoát chương trình");
            System.out.println("--->> Mời nhập lựa chọn của bạn <<---");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    new ClassroomManagement().menuClassroom();
                    break;
                case 2:
                    new StudentManagement().menuStudent();
                    break;
                case 3:
                    new SubjectManagement().menuSubjec();
                    break;
                case 4:
                    new MarkManagement().menuMark();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }
}
