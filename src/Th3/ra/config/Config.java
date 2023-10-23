package Th3.ra.config;

import java.util.Scanner;

public class Config {
    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static int validateInt() {
        int n;
        System.out.println("moi nhap: ");
        while (true) {
            try {
                n = Integer.parseInt(scanner().nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("sai dinh dang, moi nhap lai");
            }
        }
        return n;
    }
}
