package Exam_Advance_6.ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    return;
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
                    return;
            }
        } while (true);
    }

    private static void addEmployee() {
        System.out.println("nhap so luong nhan vien can them: ");
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
                    return;
            }
        } while (true);
    }

    private static void addReceipt() {
        Order order = new Order();
        order.inputData();
        orders.add(order);
        System.out.println("Đã thêm phiếu nhập thành công.");
    }

    private static void showReceipt() {
        if (orders.isEmpty()) {
            System.out.println("Không có phiếu nhập nào để hiển thị.");
        } else {
            System.out.println("Danh sách phiếu nhập:");
            for (Order order : orders) {
                order.displayData();
                System.out.println();
            }
        }
    }

    private static void editReceipt() {
        System.out.print("Nhập mã phiếu cần cập nhật: ");
        String orderId = scanner.next();
        boolean found = false;

        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.inputData();
                order.setUpdated(new Date());
                System.out.println("Đã cập nhật thông tin phiếu thành công.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phiếu có mã " + orderId);
        }
    }

    private static void searchDateReceipt() {
        System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
        String startDateStr = scanner.next();
        System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
        String endDateStr = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            List<Order> resultOrders = new ArrayList<>();
            for (Order order : orders) {
                Date orderDate = order.getCreated();
                if (orderDate.compareTo(startDate) >= 0 && orderDate.compareTo(endDate) <= 0) {
                    resultOrders.add(order);
                }
            }

            if (resultOrders.isEmpty()) {
                System.out.println("Không tìm thấy phiếu nhập trong khoảng thời gian đã cho.");
            } else {
                System.out.println("Danh sách phiếu nhập trong khoảng thời gian từ " + startDateStr + " đến " + endDateStr + ":");
                for (Order order : resultOrders) {
                    order.displayData();
                    System.out.println();
                }
            }
        } catch (ParseException e) {
            System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private static void searchByCreatorReceipt() {
        System.out.print("Nhập mã nhân viên tạo phiếu: ");
        int userCreatedId = scanner.nextInt();

        List<Order> resultOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserCreatedId() == userCreatedId) {
                resultOrders.add(order);
            }
        }

        if (resultOrders.isEmpty()) {
            System.out.println("Không tìm thấy phiếu nhập được tạo bởi nhân viên có mã " + userCreatedId);
        } else {
            System.out.println("Danh sách phiếu nhập được tạo bởi nhân viên có mã " + userCreatedId + ":");
            for (Order order : resultOrders) {
                order.displayData();
                System.out.println();
            }
        }
    }

    private static void searchByUpdaterReceipt() {
        System.out.print("Nhập mã nhân viên cập nhật phiếu: ");
        int userUpdatedId = scanner.nextInt();

        List<Order> resultOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserUpdatedId() == userUpdatedId) {
                resultOrders.add(order);
            }
        }

        if (resultOrders.isEmpty()) {
            System.out.println("Không tìm thấy phiếu nhập được cập nhật bởi nhân viên có mã " + userUpdatedId);
        } else {
            System.out.println("Danh sách phiếu nhập được cập nhật bởi nhân viên có mã " + userUpdatedId + ":");
            for (Order order : resultOrders) {
                order.displayData();
                System.out.println();
            }
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
                    return;
            }
        } while (true);
    }

    private static void addBill() {
        Order order = new Order();
        order.inputData();
        orders.add(order);
        System.out.println("Đã thêm phiếu xuất thành công.");
    }

    private static void showBill() {
        if (orders.isEmpty()) {
            System.out.println("Không có phiếu xuất nào để hiển thị.");
        } else {
            System.out.println("Danh sách phiếu xuất:");
            for (Order order : orders) {
                order.displayData();
                System.out.println();
            }
        }
    }

    private static void editBill() {
        System.out.print("Nhập mã phiếu cần cập nhật: ");
        String orderId = scanner.next();
        boolean found = false;

        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.inputData();
                order.setUpdated(new Date());
                System.out.println("Đã cập nhật thông tin phiếu xuất thành công.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phiếu có mã " + orderId);
        }
    }

    private static void searchDateBill() {
        System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
        String startDateStr = scanner.next();
        System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
        String endDateStr = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            List<Order> resultOrders = new ArrayList<>();
            for (Order order : orders) {
                Date orderDate = order.getCreated();
                if (orderDate.compareTo(startDate) >= 0 && orderDate.compareTo(endDate) <= 0) {
                    resultOrders.add(order);
                }
            }

            if (resultOrders.isEmpty()) {
                System.out.println("Không tìm thấy phiếu xuất trong khoảng thời gian đã cho.");
            } else {
                System.out.println("Danh sách phiếu xuất trong khoảng thời gian từ " + startDateStr + " đến " + endDateStr + ":");
                for (Order order : resultOrders) {
                    order.displayData();
                    System.out.println();
                }
            }
        } catch (ParseException e) {
            System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private static void searchByCreatorBill() {
        System.out.print("Nhập ID người tạo phiếu xuất: ");
        String userId = scanner.next();

        List<Order> resultOrders = new ArrayList<>();
        for (Order order : orders) {
            if (userId.equals(order.getUserCreatedId())) {
                resultOrders.add(order);
            }
        }

        if (resultOrders.isEmpty()) {
            System.out.println("Không tìm thấy phiếu xuất được tạo bởi người có ID " + userId);
        } else {
            System.out.println("Danh sách phiếu xuất được tạo bởi người có ID " + userId + ":");
            for (Order order : resultOrders) {
                order.displayData();
                System.out.println();
            }
        }
    }

    private static void searchByUpdaterBill() {
        System.out.print("Nhập ID người cập nhật phiếu xuất: ");
        String userId = scanner.next();

        List<Order> resultOrders = new ArrayList<>();
        for (Order order : orders) {
            if (userId.equals(order.getUserUpdatedId())) {
                resultOrders.add(order);
            }
        }

        if (resultOrders.isEmpty()) {
            System.out.println("Không tìm thấy phiếu xuất được cập nhật bởi người có ID " + userId);
        } else {
            System.out.println("Danh sách phiếu xuất được cập nhật bởi người có ID " + userId + ":");
            for (Order order : resultOrders) {
                order.displayData();
                System.out.println();
            }
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
                    thongKeSanPhamNhap();
                    break;
                case 2:
                    thongKeSanPhamXuat();
                    break;
                case 3:
                    thongKeDoanhThu();
                    break;
                case 4:
                    thongKeChiPhi();
                    break;
                case 5:
                    thongKePhieuThuTheoThang();
                    break;
                case 6:
                    thongKeChiPhiTheoThang();
                    break;
                case 7:
                    return;
            }
        } while (true);
    }

    private static void thongKeSanPhamNhap() {
        System.out.print("Nhập ngày bắt đầu (dd/mm/yyyy): ");
        String startDate = scanner.next();
        System.out.print("Nhập ngày kết thúc (dd/mm/yyyy): ");
        String endDate = scanner.next();

        System.out.println("Đã thực hiện thống kê các sản phẩm nhập từ ngày " + startDate + " đến ngày " + endDate);
    }

    private static void thongKeSanPhamXuat() {
        System.out.print("Nhập ngày bắt đầu (dd/mm/yyyy): ");
        String startDate = scanner.next();
        System.out.print("Nhập ngày kết thúc (dd/mm/yyyy): ");
        String endDate = scanner.next();

        System.out.println("Đã thực hiện thống kê các sản phẩm xuất từ ngày " + startDate + " đến ngày " + endDate);
    }

    private static void thongKeDoanhThu() {
        System.out.print("Nhập ngày bắt đầu (dd/mm/yyyy): ");
        String startDate = scanner.next();
        System.out.print("Nhập ngày kết thúc (dd/mm/yyyy): ");
        String endDate = scanner.next();

        System.out.println("Đã thực hiện thống kê doanh thu từ ngày " + startDate + " đến ngày " + endDate);
    }

    private static void thongKeChiPhi() {
        System.out.print("Nhập ngày bắt đầu (dd/mm/yyyy): ");
        String startDate = scanner.next();
        System.out.print("Nhập ngày kết thúc (dd/mm/yyyy): ");
        String endDate = scanner.next();

        System.out.println("Đã thực hiện thống kê chi phí từ ngày " + startDate + " đến ngày " + endDate);
    }

    private static void thongKePhieuThuTheoThang() {
        Map<String, Double> thongKePhieuThu = new HashMap<>();

        System.out.println("----- Thống kê phiếu thu theo các tháng -----");
        for (Map.Entry<String, Double> entry : thongKePhieuThu.entrySet()) {
            String thang = entry.getKey();
            Double soTien = entry.getValue();
            System.out.println("Tháng " + thang + ": " + soTien);
        }
    }

    private static void thongKeChiPhiTheoThang() {
        Map<String, Double> thongKeChiPhi = new HashMap<>();

        System.out.println("----- Thống kê chi phí theo các tháng -----");
        for (Map.Entry<String, Double> entry : thongKeChiPhi.entrySet()) {
            String thang = entry.getKey();
            Double soTien = entry.getValue();
            System.out.println("Tháng " + thang + ": " + soTien);
        }
    }
}
