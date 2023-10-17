package Exam_Advance_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static List<String> string = new ArrayList<>();
    static String input;

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU*************** ");
            System.out.println("1. Nhập câu ");
            System.out.println("2. Đảo ngược câu ");
            System.out.println("3. Thoát ");
            System.out.println("Mời nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            handleMenu(choice);
        }
    }

    private static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Nhập vào 1 câu: ");
                input = scanner.nextLine();
                System.out.println(input);
                break;
            case 2:
                string = Arrays.asList(input.split(" "));
                System.out.println("Chuỗi sau khi đảo ngược: ");
                for (int i = string.size() - 1; i >= 0; i--) {
                    System.out.print(string.get(i) + " ");
                }
                System.out.println();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
