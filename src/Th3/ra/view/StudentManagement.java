package Th3.ra.view;

import Th3.ra.config.Config;
import Th3.ra.model.Classroom;
import Th3.ra.model.Mark;
import Th3.ra.model.Student;
import Th3.ra.service.IClassroomService;
import Th3.ra.service.IMarkService;
import Th3.ra.service.IStudentService;
import Th3.ra.service.impl.ClassroomServiceIMPL;
import Th3.ra.service.impl.MarkServiceIMPL;
import Th3.ra.service.impl.StudentServiceIMPL;

public class StudentManagement {

    IStudentService studentService = new StudentServiceIMPL();
    IClassroomService classroomService = new ClassroomServiceIMPL();
    IMarkService markService = new MarkServiceIMPL();

    public void menuStudent() {
        int choice;
        do {
            System.out.println("********************** STUDENT-MANAGEMENT ************************");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học sinh theo mã id (chọn lựa từng trường để thay đổi)");
            System.out.println("4. Xóa học sinh theo mã id (kiểm tra xem nếu sinh viên có điểm thi thì không được xóa)");
            System.out.println("5. Sắp xếp theo tên sinh viên");
            System.out.println("6. Tim kiếm học sinh theo tên hoặc lớp");
            System.out.println("0. Quay lại");
            System.out.println("--->> Mời nhập lựa chọn của bạn <<---");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showListStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudentByName();
                    break;
                case 6:
                    searchStudentByName();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void searchStudentByName() {
        System.out.println("moi nhap ten or lop can tim kiem");
        String search = Config.scanner().nextLine();
        int count = 0;
        System.out.println("danh sach sinh vien can tim kiem");
        for (Student student : studentService.findAll()) {
            if (student.getStudentName().contains(search) || student.getClassroom().getClassroomName().contains(search)) {
                System.out.println(student);
                count++;
            }
        }
        System.out.printf("tim thay %d sinh vien theo tu khoa vua nhap ", count);
    }

    private void sortStudentByName() {
        studentService.findAll().sort((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName()));
        System.out.println("da sap xep theo ten thanh cong");
    }

    private void deleteStudent() {
        System.out.println("nhap id sinh vien can xoa");
        int idDelete = Config.validateInt();
        for (Mark mark : markService.findAll()) {
            if (mark.getStudent().getStudentId() == idDelete) {
                System.out.println("sv dang co diem, ko duoc xoas");
                return;
            }
        }
        boolean check = true;
        for (Student student : studentService.findAll()) {
            if (student.getStudentId() == idDelete) {
                studentService.deleteById(idDelete);
                System.out.println("xoa thanh cong");
                check = false;
            }
        }
        if (check) {
            System.out.println("ko tim thay sv theo id can xoa");
        }
    }

    private void editStudent() {
        System.out.println("nhap id hoc sinh can thay doi");
        int idEdit = Config.validateInt();
        Student studentedit = studentService.findById(idEdit);

        System.out.println("1_ sua ten");
        System.out.println("2_ sua lop hoc");
        System.out.println("3_ sua dia chi");
        System.out.println("4_ sua so dien thoai");
        int choice = Config.validateInt();
        switch (choice) {
            case 1:
                System.out.println("nhap ten moi: ");
                studentedit.setStudentName(Config.scanner().nextLine());
                System.out.println("sua ten thanh cong");
                break;
            case 2:
                System.out.println("danh sach lop hoc can chon");
                for (int j = 0; j < classroomService.findAll().size(); j++) {
                    System.out.println((j + 1) + ", " + classroomService.findAll().get(j).getClassroomName());
                }
                System.out.println("moi lua chon lop hoc: ");
                while (true) {
                    int choiceEdit = Config.validateInt();
                    if (choiceEdit >= 1 && choice <= classroomService.findAll().size()) {
                        studentedit.setClassroom(classroomService.findAll().get(choice - 1));
                        break;
                    } else {
                        System.out.println("ko co lop theo lua chon, moi chon lai");
                    }
                }
                break;
            case 3:
                System.out.println("nhap dia chi moi: ");
                studentedit.setAddress(Config.scanner().nextLine());
                System.out.println("sua dia chi thanh cong");
                break;
            case 4:
                System.out.println("nhap so dien thoai moi: ");
                studentedit.setPhone(Config.scanner().nextLine());
                System.out.println("sua so dien thoai thanh cong");
                break;
            default:
                System.err.println("ko hop le, moi nhap lai");
                break;
        }
    }

    private void addStudent() {
        System.out.println("nhap so luong hoc sinh can them");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhap hoc sinh thu  " + (i + 1) + ", ");
            Student student = new Student();

            // ten hoc sinh
            System.out.println("nhap ten hoc sinh");
            student.setStudentName(Config.scanner().nextLine());

            // danh sach classroom
            System.out.println("danh sach lop co the chon: ");
            for (int j = 0; j < classroomService.findAll().size(); j++) {
                System.out.println((j + 1) + ", " + classroomService.findAll().get(j).getClassroomName());
            }
            System.out.println("moi lua chon lop hoc: ");
            while (true) {
                int choice = Config.validateInt();
                if (choice >= 1 && choice <= classroomService.findAll().size()) {
                    student.setClassroom(classroomService.findAll().get(choice-1));
                    break;
                } else {
                    System.out.println("ko co lop theo lua chon, moi chon lai");
                }
            }

            // nhap ngay sinh
            System.out.println("nhap ngay sinh");
            student.setBirthday(Config.scanner().nextLine());

            // nhap dia chi
            System.out.println("nhap dia chi");
            student.setAddress(Config.scanner().nextLine());

            // nhap gioi tinh
            System.out.println("nhap gioi tinh");
            student.setGender(Boolean.parseBoolean(Config.scanner().nextLine()));

            // nhap so dien thoai
            System.out.println("nhap so dien thoai");
            student.setPhone(Config.scanner().nextLine());

            studentService.save(student);

        }
    }

    private void showListStudent() {
        System.out.println("danh sach hoc sinh");
        for (Student student : studentService.findAll()) {
            System.out.println(student);
        }
    }
}
