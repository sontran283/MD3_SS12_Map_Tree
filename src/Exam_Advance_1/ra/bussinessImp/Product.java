package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private static int idCountProduct = 1;
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean Boolean;

    public Product() {
        this.productId = idCountProduct++;
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean aBoolean) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        Boolean = aBoolean;
    }

    public static int getIdCountProduct() {
        return idCountProduct;
    }

    public static void setIdCountProduct(int idCountProduct) {
        Product.idCountProduct = idCountProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
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

    public boolean isBoolean() {
        return Boolean;
    }

    public void setBoolean(boolean aBoolean) {
        Boolean = aBoolean;
    }

    @Override
    public void inputData(List<Catalog> catalogs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin san pham: ");

        System.out.println("nhap ten san pham: ");
        this.productName = scanner.nextLine();

        System.out.println("nhap tieu de san pham: ");
        this.title = scanner.nextLine();

        System.out.println("nhap mo ta san pham: ");
        this.descriptions = scanner.nextLine();

        System.out.println("gia nhap san pham: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("danh sach Catalog");
        for (int i = 0; i < catalogs.size(); i++) {
            System.out.println((i + 1) + ": " + catalogs.get(i).getCatalogName());
        }
        System.out.println("moi nhap STT de chon danh muc: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n >= 1 && n <= catalogs.size()) {
            this.catalog = catalogs.get(n - 1);
        } else {
            System.err.println("khong co danh muc de chon");
            return;
        }
//        for (int i = 0; i < catalogs.size(); i++) {
//            System.out.println(catalogs.get(i).getCatalogId() + ": " + catalogs.get(i).getCatalogName());
//        }
//        System.out.println("moi nhap ID de chon danh muc: ");
//        int n = Integer.parseInt(scanner.nextLine());
//        boolean check = false;
//        for (int i = 0; i < catalogs.size(); i++) {
//            if (catalogs.get(i).getCatalogId() == n) {
//                this.catalog = catalogs.get(i);
//                check = true;
//            }
//        }
//        if (check) {
//            System.err.println("khong co id danh muc de chon");
//            return;
//        }

        this.exportPrice = this.importPrice * this.RATE;
    }

    @Override
    public void displayData() {
        System.out.println(
                "Product{" +
                        "productId=" + productId +
                        ", productName='" + productName + '\'' +
                        ", catalog=" + catalog +
                        ", exportPrice=" + exportPrice +
                        ", Boolean=" + (Boolean ? "open" : "closed") +
                        "} " + super.toString()
        );
    }
}
