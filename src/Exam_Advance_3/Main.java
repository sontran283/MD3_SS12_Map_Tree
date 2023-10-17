package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Queue<String> advances = new LinkedList<>();

    public static void main(String[] args) {
        // Chọn 1: thực hiện nhập một tên phụ huynh từ bàn phím và lưu vào queue.
        // Chọn 2: thực hiện in phụ huynh đầu tiên trong danh sách và xóa phụ huynh vừa in
        // Chọn 3: thoát
        while (true) {
            System.out.println("****** menu ******");
            System.out.println("Chọn 1_ Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("Chọn 2_ Phụ huynh tiếp theo");
            System.out.println("Chọn 3_ Thoát");
            System.out.println("moi nhap lua chon cua ban");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                handleAdvance(choice);
            } catch (Exception e) {
                System.err.println("nhap sai dinh dang, moi nhap lai");
            }
        }
    }

    private static void handleAdvance(int choice) {
        switch (choice) {
            case 1:
                addAdvance();
                break;
            case 2:
                continuedAdvance();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private static void addAdvance() {
        System.out.println("nhap ten phu huynh nop ho so: ");
        String name = scanner.nextLine();
        advances.offer(name);
        System.out.println("da them thanh cong");
    }

    private static void continuedAdvance() {
        System.out.println(advances);
        System.out.println("phu huynh vua bi xoa la: " + advances.poll());
    }
}
