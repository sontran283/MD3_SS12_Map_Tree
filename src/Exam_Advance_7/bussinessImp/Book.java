package Exam_Advance_7.bussinessImp;

import Exam_Advance_7.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook {

    private static int idCount = 1;
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = idCount++;
        this.bookStatus = true;
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Nhap thong tin sach ***");

        System.out.println("Moi nhap ten sach: ");
        while (true) {
            this.bookName = scanner.nextLine();
            if (!this.bookName.isEmpty()) {
                break;
            } else {
                System.out.println("Ten sach khong duoc de trong, moi nhap lai");
            }
        }

        System.out.println("Moi nhap tieu de sach: ");
        while (true) {
            this.title = scanner.nextLine();
            if (!this.title.isEmpty()) {
                break;
            } else {
                System.out.println("tieu de sach khong duoc de trong, moi nhap lai");
            }
        }

        System.out.println("Moi nhap so trang sach: ");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());


        System.out.print("Moi nhap gia nhap khau: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        while (this.importPrice <= 0) {
            System.out.println("Gia nhap khau phai lon hon 0");
            System.out.print("Moi nhap importPrice: ");
            this.importPrice = Float.parseFloat(scanner.nextLine());
        }

        System.out.print("Nhap gia xuat khau: ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.println("Gia xuat khau phai toi thieu bang 1/2 gia nhap khau");
            System.out.print("Moi nhap exportPrice: ");
            this.exportPrice = Float.parseFloat(scanner.nextLine());
        }

        System.out.println("Tinh toan loi nhuan (interest): ");
        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.println(
                "Book{" +
                        "bookId=" + bookId +
                        ", bookName='" + bookName + '\'' +
                        ", title='" + title + '\'' +
                        ", numberOfPages=" + numberOfPages +
                        ", importPrice=" + importPrice +
                        ", exportPrice=" + exportPrice +
                        ", interest=" + interest +
                        ", bookStatus=" + bookStatus +
                        '}'
        );
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
