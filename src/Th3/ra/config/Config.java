package Th3.ra.config;

import java.util.Scanner;

public class Config {
    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static int validateInt() {
        int n;
        System.out.println("mời nhập lựa chọn của bạn: ");
        while (true) {
            try {
                n = Integer.parseInt(scanner().nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("sai định dạng, mời nhập lại");
            }
        }
        return n;
    }
}
