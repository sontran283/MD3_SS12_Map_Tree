package Exam_Advance_6.ra.entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Order {
    private String orderId;
    private int quantity;
    private String productId;
    private Date created;
    private int userCreatedId;
    private Date updated;
    private int userUpdatedId;
    private boolean orderType;
    private float price;
    private boolean orderStatus;

    public Order() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.orderId = generateOrderId();
        this.created = new Date();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(int userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getUserUpdatedId() {
        return userUpdatedId;
    }

    public void setUserUpdatedId(int userUpdatedId) {
        this.userUpdatedId = userUpdatedId;
    }

    public boolean isOrderType() {
        return orderType;
    }

    public void setOrderType(boolean orderType) {
        this.orderType = orderType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    private String generateOrderId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String datePart = dateFormat.format(new Date());
        return "PN-" + datePart + "-01";
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin phiếu nhập/xuất:");

        System.out.println("Nhập số lượng:");
        this.quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập mã sản phẩm:");
        this.productId = scanner.nextLine();

        System.out.println("Chọn loại phiếu (true - phiếu nhập, false - phiếu xuất):");
        this.orderType = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Nhập giá nhập/xuất:");
        this.price = Float.parseFloat(scanner.nextLine());

        System.out.println("Chọn trạng thái phiếu (true - hoạt động, false - bị hủy):");
        this.orderStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Thông tin phiếu nhập/xuất:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Ngày tạo: " + dateFormat.format(created));
        System.out.println("Mã nhân viên tạo: " + userCreatedId);
        System.out.println("Ngày cập nhật: " + (updated != null ? dateFormat.format(updated) : "N/A"));
        System.out.println("Mã nhân viên cập nhật: " + userUpdatedId);
        System.out.println("Loại phiếu: " + (orderType ? "Phiếu nhập" : "Phiếu xuất"));
        System.out.println("Giá nhập/xuất: " + price);
        System.out.println("Trạng thái phiếu: " + (orderStatus ? "Hoạt động" : "Bị hủy"));
    }
}