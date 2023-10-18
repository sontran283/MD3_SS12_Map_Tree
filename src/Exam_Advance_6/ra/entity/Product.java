package Exam_Advance_6.ra.entity;

import config.Config;

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
        System.out.println("nhap thong tin: ");

        System.out.println("nhap ten san pham: ");
        this.productName = Config.scanner().nextLine();

        System.out.println("nhap nha san xuat: ");
        this.manufacturer = Config.scanner().nextLine();

        System.out.println("trang thai");
        System.out.println("chon 0_ hoạt động");
        System.out.println("chon 1_ không hoạt động");
        this.productStatus = Boolean.parseBoolean(Config.scanner().nextLine());
    }

    public void displayData() {
        System.out.println(
                "Product{" +
                        "productId='" + productId + '\'' +
                        ", productName='" + productName + '\'' +
                        ", manufacturer='" + manufacturer + '\'' +
                        ", productStatus=" + productStatus +
                        '}'
        );
    }
}
