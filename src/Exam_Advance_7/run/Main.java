package Exam_Advance_7.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Exam_Advance_7.bussinessImp.Book;
import Exam_Advance_7.config.config;
public class Main {
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("****** Quản lí sách ******");
            System.out.println("Chon 1_ Nhập số sách (n) cần nhập thông tin từ bàn phím và thực hiện nhập thông tin cho n sách đó");
            System.out.println("Chon 2_ Hiển thị thông tin sách cho tất cả sách đang lưu trữ");
            System.out.println("Chon 3_ Sử dụng Comparable để cài đặt sắp xếp giảm dần cho các sách đang lưu trữ");
            System.out.println("Chon 4_ Nhập mã sách cần xóa từ bàn phím, thực hiện xóa sách trong danh sách");
            System.out.println("Chon 5_ Nhập tên sách từ bàn phím, thực hiện tìm và in ra sách có tên phù hợp");
            System.out.println("Chon 6_ Nhập vào mã sách, thay đổi trạng thái sách (false -true)");
            System.out.println("Chon 7_ Thoát khỏi chương trình");
            System.out.println("*** Mời nhập lựa chọn của bạn ***");
            try {
                int choice = config.getValidateInteface();
                handleMenu(choice);
            } catch (Exception e) {
                System.err.println("___ sai dinh dang, moi nhap lai ___");
            }
        }
    }

    private static void handleMenu(int choise) {
        switch (choise) {
            case 1:
                addBook();
                break;
            case 2:
                allBook();
                break;
            case 3:
                subBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                searchBook();
                break;
            case 6:
                editBooleanBook();
                break;
            case 7:
                System.out.println("Thoat");
                break;
            default:
                System.exit(1);
        }
    }


    private static void addBook() {
        System.out.println("nhap so luong sach can them: ");
        try {
            int count = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < count; i++) {
                Book book = new Book();
                book.inputData();
                books.add(book);
            }
        } catch (Exception e) {
            System.err.println("nhap sai dinh dang,moi nhap lai");
        }
    }

    private static void allBook() {
        System.out.println("danh sach thu vien: ");
//        books.forEach(book -> {
//            book.displayData();
//        });
        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayData();
        }
    }

    private static void subBook() {
        books.sort((book1, book2) -> Float.compare(book2.getInterest(), book1.getInterest()));
        System.out.println("sap xep theo thu tu giam dan thanh cong");
    }

    private static void deleteBook() {
        System.out.println("nhap ma sach can xoa");
        int bookCode = Integer.parseInt(scanner.nextLine());
        Iterator<Book> iterator = books.iterator();
        boolean check = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId() == bookCode) {
                iterator.remove();
                book.displayData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("xoa thanh cong");
        } else {
            System.out.println("khong tim thay cuon sach co id: " + bookCode);
        }
    }

    private static void searchBook() {
        System.out.println("nhap ten sach can tim: ");
        String bookName = scanner.nextLine();
        boolean check = false;
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                book.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay cuon sach co ten: " + bookName);
        }
    }

    private static void editBooleanBook() {
        System.out.println("nhap ma cuon sach can thay doi");
        String bookChange = scanner.nextLine();
        boolean check = false;
        for (Book book : books) {
            if (String.valueOf(book.getBookId()).equals(bookChange)) {
                book.setBookStatus(!book.isBookStatus());
                book.displayData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi trang thai thanh cong");
        } else {
            System.out.println("khong tim thay cuon sach co id: " + bookChange);
        }
    }
}
