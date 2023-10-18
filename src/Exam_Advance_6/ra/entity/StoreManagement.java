package Exam_Advance_6.ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreManagement {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("********* Menu Tổng *********");
            System.out.println("Chọn 1_ Quản lý sản phẩm");
            System.out.println("Chọn 2_ Quản lý nhân viên");
            System.out.println("Chọn 3_ Quản lý phiếu nhập");
            System.out.println("Chọn 4_ Quản lý phiếu xuất");
            System.out.println("Chọn 5_ Báo cáo thống kê");
            System.out.println("Chọn 6_ Thoát");
            System.out.println("-->> mời nhập lựa chọn của bạn <<--");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager();
                    break;
                case 2:
                    employManager();
                    break;
                case 3:
                    phieuNhapManager();
                    break;
                case 4:
                    phieuXuatManager();
                    break;
                case 5:
                    thongKeManager();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }


    // Quản lý sản phẩm
    private static void productManager() {
        int choice1;
        do {
            System.out.println("****** Menu Quản lý sản phẩm ******");
            System.out.println("Chọn 1_ Nhập thông tin các sản phẩm");
            System.out.println("Chọn 2_ Hiển thị thông tin các sản phẩm");
            System.out.println("Chọn 3_ Cập nhật thông tin sản phẩm");
            System.out.println("Chọn 4_ Tìm kiếm sản phẩm theo tên");
            System.out.println("Chọn 5_ Cập nhật trạng thái sản phẩm");
            System.out.println("Chọn 6_ Thoát");
            System.out.println("-->> mời nhập lựa chọn của bạn <<--");
            choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    searchByNameProduct();
                    break;
                case 5:
                    editStatusProduct();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    private static void addProduct() {
        System.out.println("nhap so luong san pham can them: ");
        try {
            int productCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productCount; i++) {
                Product product = new Product();
                product.inputData();
                products.add(product);
            }
        } catch (Exception e) {
            System.err.println("khong hop le, moi nhap lai");
        }
    }

    private static void showProduct() {
        System.out.println("danh sach product: ");
//        products.forEach(product -> {
//            product.displayData();
//        });
        for (int i = 0; i < products.size(); i++) {
            products.get(i).displayData();
        }
    }

    private static void editProduct() {
        System.out.println("nhap ma san pham can thay doi: ");
        String idProductChange = scanner.nextLine();
        boolean check = false;
        for (Product product : products) {
            if (product.getProductId().equals(idProductChange)) {
                product.inputData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi thong tin product thanh cong");
        } else {
            System.out.println("khong tim thay ma product voi id " + idProductChange);
        }
    }

    private static void searchByNameProduct() {
        System.out.println("nhap ten san pham can tim: ");
        String productName = scanner.nextLine();
        boolean check = false;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                product.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay san pham co ten: " + productName);
        }
    }

    private static void editStatusProduct() {
        System.out.println("nhap ma san pham can thay doi: ");
        String changeStatus = scanner.nextLine();
        boolean check = false;
        for (Product product : products) {
            if (product.getProductId().equals(changeStatus)) {
                product.setProductStatus(!product.isProductStatus());
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi thong tin trang thai product thanh cong");
        } else {
            System.out.println("khong tim thay ma product voi id " + changeStatus);
        }
    }


    // Quản lý nhân viên
    private static void employManager() {
        int choice2;
        do {
            System.out.println("****** Menu Quản lý nhân viên ******");
            System.out.println("Chọn 1_ Nhập thông tin nhân viên");
            System.out.println("Chọn 2_ Hiển thị thông tin nhân viên");
            System.out.println("Chọn 3_ Cập nhật thông tin nhân viên");
            System.out.println("Chọn 4_ Tìm nhân viên theo tên nhân viên");
            System.out.println("Chọn 5_ Cập nhật trạng thái của nhân viên");
            System.out.println("Chọn 6_ Thoát");
            System.out.println("-->> mời nhập lựa chọn của bạn <<--");
            choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    editStatuSEmployee();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    private static void addEmployee() {
        System.out.println("nhap thong tin nhan vien can them: ");
        try {
            int employeeCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < employeeCount; i++) {
                Employee employee = new Employee();
                employee.inputData();
                employees.add(employee);
            }
        } catch (Exception e) {
            System.err.println("khong hop le, moi nhap lai");
        }
    }

    private static void showEmployee() {
        System.out.println("danh sach employee: ");
//        employees.forEach(employee -> {
//            employee.displayData();
//        });
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).displayData();
        }
    }

    private static void editEmployee() {
        System.out.println("nhap ma nhan vien can thay doi: ");
        int idEmployeeChange = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Employee employee : employees) {
            if (employee.getEmpId() == (idEmployeeChange)) {
                employee.inputData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi thong tin employee thanh cong");
        } else {
            System.out.println("khong tim thay ma employee voi id " + idEmployeeChange);
        }
    }

    private static void searchEmployee() {
        System.out.println("nhap ten nhan vien can tim: ");
        String employeeName = scanner.nextLine();
        boolean check = false;
        for (Employee employee : employees) {
            if (employee.getEmpName().equals(employeeName)) {
                employee.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay nhan vien co ten: " + employeeName);
        }
    }

    private static void editStatuSEmployee() {
        System.out.println("nhap ma nhan vien can thay doi: ");
        int changeStatus = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Employee employee : employees) {
            if (employee.getEmpId() == (changeStatus)) {
                employee.setEmpStatus(!employee.isEmpStatus());
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi thong tin trang thai employee thanh cong");
        } else {
            System.out.println("khong tim thay ma employee voi id " + changeStatus);
        }
    }


    // Quản lý phiếu nhập
    private static void phieuNhapManager() {
        int choice3;
        do {
            System.out.println("****** Menu Quản lý phiếu nhập ******");
            System.out.println("Chọn 1_ Nhập thông tin phiếu nhập");
            System.out.println("Chọn 2_ Hiển thị thông tin phiếu nhập");
            System.out.println("Chọn 3_ Cập nhật thông tin phiếu nhập");
            System.out.println("Chọn 4_ Tìm phiếu nhập từ ngày tạo");
            System.out.println("Chọn 5_ Tìm phiếu nhập theo người tạo");
            System.out.println("Chọn 6_ Tìm phiếu nhập theo người cập nhật");
            System.out.println("Chọn 7_ Thoát");
            System.out.println("-->> mời nhập lựa chọn của bạn <<--");
            choice3 = Integer.parseInt(scanner.nextLine());
            switch (choice3) {
                case 1:
                    addReceipt();
                    break;
                case 2:
                    showReceipt();
                    break;
                case 3:
                    editReceipt();
                    break;
                case 4:
                    searchDateReceipt();
                    break;
                case 5:
                    searchByCreatorReceipt();
                    break;
                case 6:
                    searchByUpdaterReceipt();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    private static void addReceipt() {
        System.out.println("nhap thong tin phieu nhap: ");
        try {
            int orderCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < orderCount; i++) {
                Order order = new Order();
                order.inputData();
                orders.add(order);
            }
        } catch (Exception e) {
            System.err.println("khong hop le, moi nhap lai");
        }
    }

    private static void showReceipt() {
        System.out.println("danh sach orders: ");
//        orders.forEach(order -> {
//            order.displayData();
//        });
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).displayData();
        }
    }

    private static void editReceipt() {
        System.out.println("nhap ma phieu nhap can thay doi: ");
        String idOrderChange = scanner.nextLine();
        boolean check = false;
        for (Order order : orders) {
            if (order.getOrderId() == (idOrderChange)) {
                order.inputData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi thong tin phieu nhap thanh cong");
        } else {
            System.out.println("khong tim thay ma phieu nhap voi id " + idOrderChange);
        }
    }

    private static void searchDateReceipt() {
        System.out.println("Tìm phiếu nhap theo ngày ");
        String ordersDate = scanner.nextLine();
        boolean check = false;
        for (Order order : orders) {
            if (order.getCreated().equals(ordersDate)) {
                order.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay phieu nhap co ngay: " + ordersDate);
        }
    }

    private static void searchByCreatorReceipt() {
        System.out.println("Tìm phiếu nhap theo người tạo: ");
        int ordersPeople = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Order order : orders) {
            if (order.getUserCreatedId() == (ordersPeople)) {
                order.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay phieu nhap co nguoi tao: " + ordersPeople);
        }
    }

    private static void searchByUpdaterReceipt() {
        System.out.println("Tìm phiếu nhap theo người cập nhật: ");
        int ordersUpdater = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Order order : orders) {
            if (order.getUserUpdatedId() == (ordersUpdater)) {
                order.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay phieu nhap theo nguoi cap nhat: " + ordersUpdater);
        }
    }


    // Quản lý phiếu xuất
    private static void phieuXuatManager() {
        int choice4;
        do {
            System.out.println("****** Menu Quản lý phiếu xuất ******");
            System.out.println("Chọn 1_ Nhập thông tin phiếu xuất");
            System.out.println("Chọn 2_ Hiển thị thông tin phiếu xuất");
            System.out.println("Chọn 3_ Cập nhật thông tin phiếu xuất");
            System.out.println("Chọn 4_ Tìm phiếu xuất từ ngày đến ngày");
            System.out.println("Chọn 5_ Tìm phiếu xuất theo người tạo");
            System.out.println("Chọn 6_ Tìm phiếu xuất theo người cập nhật");
            System.out.println("Chọn 7_ Thoát");
            System.out.println("-->> mời nhập lựa chọn của bạn <<--");
            choice4 = Integer.parseInt(scanner.nextLine());
            switch (choice4) {
                case 1:
                    addBill();
                    break;
                case 2:
                    showBill();
                    break;
                case 3:
                    editBill();
                    break;
                case 4:
                    searchDateBill();
                    break;
                case 5:
                    searchByCreatorBill();
                    break;
                case 6:
                    searchByUpdaterBill();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    private static void addBill() {
        System.out.println("nhap thong tin phieu xuat: ");
        try {
            int orderCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < orderCount; i++) {
                Order order = new Order();
                order.inputData();
                orders.add(order);
            }
        } catch (Exception e) {
            System.err.println("khong hop le, moi nhap lai");
        }
    }

    private static void showBill() {
        System.out.println("danh sach orders: ");
//        orders.forEach(order -> {
//            order.displayData();
//        });
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).displayData();
        }
    }

    private static void editBill() {
        System.out.println("nhap ma phieu xuat can thay doi: ");
        String idOrderChange = scanner.nextLine();
        boolean check = false;
        for (Order order : orders) {
            if (order.getOrderId() == (idOrderChange)) {
                order.inputData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thay doi thong tin phieu xuat thanh cong");
        } else {
            System.out.println("khong tim thay ma phieu xuat voi id " + idOrderChange);
        }
    }

    private static void searchDateBill() {
        System.out.println("Tìm phiếu xuat theo ngày ");
        String ordersDate = scanner.nextLine();
        boolean check = false;
        for (Order order : orders) {
            if (order.getCreated().equals(ordersDate)) {
                order.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay phieu xuat co ngay: " + ordersDate);
        }
    }

    private static void searchByCreatorBill() {
        System.out.println("Tìm phiếu xuất theo người tạo: ");
        int ordersPeople = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Order order : orders) {
            if (order.getUserCreatedId() == (ordersPeople)) {
                order.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay phieu xuat co nguoi tao: " + ordersPeople);
        }
    }

    private static void searchByUpdaterBill() {
        System.out.println("Tìm phiếu xuất theo người cập nhật: ");
        int ordersUpdate = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Order order : orders) {
            if (order.getUserUpdatedId() == (ordersUpdate)) {
                order.displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong tim thay phieu xuat theo nguoi cap nhat: " + ordersUpdate);
        }
    }


    // Báo cáo thống kê
    private static void thongKeManager() {
        int choice5;
        do {
            System.out.println("****** Menu Báo cáo thống kê ******");
            System.out.println("Chọn 1_ Thống kê các sản phẩm nhập từ ngày đến ngày");
            System.out.println("Chọn 2_ Thống kê các sản phẩm xuất từ ngày đến ngày");
            System.out.println("Chọn 3_ Thống kê doanh thu từ ngày đến ngày (theo các phiếu xuất)");
            System.out.println("Chọn 4_ Thống kê chi phí từ ngày đến ngày (theo các phiếu nhập)");
            System.out.println("Chọn 5_ Thống kê phiếu thu theo các tháng");
            System.out.println("Chọn 6_ Thống kê chi phí theo các tháng");
            System.out.println("Chọn 7_ Thoát");
            System.out.println("-->> mời nhập lựa chọn của bạn <<--");
            choice5 = Integer.parseInt(scanner.nextLine());
            switch (choice5) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
