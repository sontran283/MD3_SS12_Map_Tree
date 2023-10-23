package Th3.ra.view;

import Th3.ra.config.Config;

public class MarkManagement {
    public static void main(String[] args) {

    }

    public void menu() {
        int choice;
        do {
            System.out.println("********************** CLASSROOM-MANAGEMENT ************************");
            System.out.println("1. Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2. Hiển thị danh sách tất cả điểm thi");
            System.out.println("3. Sắp xếp điểm thi theo thứ tự giảm dần");
            System.out.println("4. Thay đổi điểm theo mã id ");
            System.out.println("5. Xóa điểm theo mã id ");
            System.out.println("6. Hiển thị danh sách điểm thi theo mã môn học (Chọn từng mã môn học để hiển thị) ");
            System.out.println("7. Hiển thị đánh giá học lực của từng học sinh theo mã môn học  ");
            System.out.println("8. Quay lại");
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
