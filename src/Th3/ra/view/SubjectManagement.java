package Th3.ra.view;

import Th3.ra.config.Config;

public class SubjectManagement {
    public static void main(String[] args) {

    }

    public void menu() {
        int choice;
        do {
            System.out.println("********************** CLASSROOM-MANAGEMENT ************************");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học môn học theo mã id");
            System.out.println("4. Xóa môn học theo mã id (kiểm tra nếu môn học  có điểm thi thì không được xóa)");
            System.out.println("5. Quay lại");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
