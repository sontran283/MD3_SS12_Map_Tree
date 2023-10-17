package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        boolean check = true;

        while (check) {
            System.out.println("****** MENU BT2 ******");
            System.out.println("Chọn 1_ Nhập câu");
            System.out.println("Chọn 2_ Đảo ngược câu");
            System.out.println("Chọn 3_ Thoát");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("nhap mot cau (vi du: “Peace and Quiet”): ");
                    str = scanner.nextLine();
                    break;
                case 2:
                    if (!str.isEmpty()) {
                        String reverseTest = hamDaoNguoc(str);
                        System.out.println("cau sau khi dao nguoc la: " + reverseTest);
                    } else {
                        System.err.println("nhap khong dung dinh dang, vui long chon lai");
                    }
                    break;
                case 3:
                    check = false;
                    System.out.println("thoat");
                    break;
                default:
                    System.err.println("khong hop le, vui long nhap lai");
                    break;
            }
        }
    }

    public static String hamDaoNguoc(String str) {
        String[] words = str.split(" ");
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reverseTest = new StringBuilder();
        while (!stack.isEmpty()) {
            reverseTest.append(stack.pop()).append(" ");
        }

        return reverseTest.toString().trim();
    }
}