package Th3.ra.view;

import Th3.ra.config.Config;

public class StudentManagement {
    public static void main(String[] args) {

    }

    public void menu() {
        int choice;
        do {
            System.out.println("********************** CLASSROOM-MANAGEMENT ************************");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học sinh theo mã id (chọn lựa từng trường để thay đổi)");
            System.out.println("4. Xóa học sinh theo mã id (kiểm tra xem nếu sinh viên có điểm thi thì không được xóa)");
            System.out.println("5. Quay lại");
            System.out.println("--->> mời nhập lựa chọn của bạn <<---");
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
