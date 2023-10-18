package Exam_Advance_6.ra.entity;

import config.Config;

import java.util.Scanner;

public class Product {
    private String productId;
    private static int count = 100;
    private String productName;
    private String manufacturer;
    private boolean productStatus;

    public Product() {
        this.productId = "A" + Product.count++;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin: ");

        while (true) {
            System.out.print("Nhập productName: ");
            String input = scanner.nextLine();

            if (input.length() > 0) {
                this.productName = input;
                break;
            } else {
                System.out.println("Lỗi: productName không hợp lệ. Vui lòng nhập lại.");
            }
        }

        System.out.println("nhap nha san xuat: ");
        this.manufacturer = Config.scanner().nextLine();

        while (true) {
            System.out.print("Nhập productStatus (0 - hoạt động, 1 - không hoạt động): ");
            String input = scanner.nextLine();

            if (input.equals("0") || input.equals("1")) {
                this.productStatus = input.equals("0");
                break;
            } else {
                System.out.println("Lỗi: productStatus không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    public void displayData() {
        System.out.println("Thông tin sản phẩm:");
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Product Status: " + (productStatus ? "Hoạt động" : "Không hoạt động"));
    }
}
