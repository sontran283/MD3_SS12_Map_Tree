package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Catalog implements IShop {
    private static int idCount = 1;
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
        this.catalogId = idCount++;
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public Catalog(float RATE, int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Catalog.idCount = idCount;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }


    @Override
    public void inputData(List<Catalog> catalogs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin: ");

        System.out.println("nhap ten danh muc san pham: ");
        this.catalogName = scanner.nextLine();

        System.out.println("nhap do uu tien: ");
        this.priority = Integer.parseInt(scanner.nextLine());

        System.out.println("nhap mo ta danh muc: ");
        this.descriptions = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.println(
                "Catalog{" +
                        "catalogId=" + catalogId +
                        ", catalogName='" + catalogName + '\'' +
                        ", priority=" + priority +
                        ", descriptions='" + descriptions + '\'' +
                        ", catalogStatus=" + (catalogStatus ? "YES" : "NO") +
                        "} " + super.toString()
        );
    }
}
