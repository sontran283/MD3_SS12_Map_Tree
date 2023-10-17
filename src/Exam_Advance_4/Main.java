package Exam_Advance_4;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String newString = "";

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("""
                    ****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************
                    1. Nhập câu
                    2. Đảo ngược câu
                    3. Thoát
                    Chọn 1 thực hiện nhập một câu từ bàn phím (Ví dụ: “Peace and Quiet”). Chọn 2 thực hiện đảo
                    ngược câu và in ra (Ví dụ: “Quiet and Peace”) Chọn 3: Kết thúc chương trình
                    """);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    importString();
                    break;
                case 2:
                    reverseString();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void reverseString() {
        List<String> listStrings = new ArrayList<>(Arrays.asList(newString.split(" ")));
        Collections.reverse(listStrings);
        StringBuilder revString = new StringBuilder(new StringBuilder());
        for (String s : listStrings) {
            revString.append(s).append(" ");
        }
        System.out.println("Chuỗi đã đảo ngược:");
        System.out.println(revString.toString().trim());
    }

    private static void importString() {
        System.out.println("Nhập câu");
        newString = scanner.nextLine();
    }
}
