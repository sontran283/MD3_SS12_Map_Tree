package Exam_Advance_7.config;

import java.util.Scanner;

public class config {
    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static int getValidateInteface() {
        int interger;
        System.out.println("moi nhap lua chon");
        while (true) {
            String s = scanner().nextLine();
            if (s.matches("\\d+")) {
                interger = Integer.parseInt(s);
                break;
            }
            System.err.println("sai dinh dang so, moi nhap lai");
        }
        return interger;
    }
}
