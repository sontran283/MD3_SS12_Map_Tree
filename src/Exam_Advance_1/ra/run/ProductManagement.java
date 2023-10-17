package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Float.compare;

public class ProductManagement {
    static List<Catalog> catalogs = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("****** Menu ProductManagement ******");
            System.out.println("Chọn 1_ Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("Chọn 2_ Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("Chọn 3_ Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("Chọn 4_ Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("Chọn 5_ Thoát");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                handleMenu(choice);
            } catch (Exception e) {
                System.err.println("Sai định dạng, mời nhập lại");
            }
        }
    }

    private static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                addCatalog();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                subProduct();
                break;
            case 4:
                searchCatalog();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private static void addCatalog() {
        System.out.println("nhap so danh muc san pham can them: ");
        try {
            int countCatalog = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < countCatalog; i++) {
                Catalog catalog = new Catalog();
                catalog.inputData(catalogs);
                catalogs.add(catalog);
                catalog.displayData();
            }
        } catch (Exception e) {
            System.err.println("nhap sai dinh dang, moi nhap lai");
        }
    }

    private static void addProduct() {
        System.out.println("nhap so san pham can them: ");
        try {
            int countProduct = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < countProduct; i++) {
                Product product = new Product();
                product.inputData(catalogs);
                products.add(product);
                product.displayData();
            }
        } catch (Exception e) {
            System.err.println("nhap sai dinh dang, moi nhap lai");
        }
    }

    private static void subProduct() {
        products.sort((product1, product2) -> compare(product1.getExportPrice(), product2.getExportPrice()));
        System.out.println("sap xep thanh cong");
    }

    private static void searchCatalog() {
        System.out.println("nhap ten danh muc san phan can tim: ");
        String name = scanner.nextLine();
        boolean check = false;
        for (Catalog catalog : catalogs) {
            if (catalog.getCatalogName().equals(name)) {
                catalog.displayData();
                check = true;
            }
        }
        if (!check) {
            System.err.println("khong tim thay danh muc co ten: " + name);
        }
    }
}
