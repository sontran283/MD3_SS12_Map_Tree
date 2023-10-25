package Th3.ra.view;

import Th3.ra.config.Config;
import Th3.ra.model.Classroom;
import Th3.ra.model.Student;
import Th3.ra.service.IClassroomService;
import Th3.ra.service.IStudentService;
import Th3.ra.service.impl.ClassroomServiceIMPL;
import Th3.ra.service.impl.StudentServiceIMPL;

import java.util.List;

public class ClassroomManagement {
    IClassroomService classroomService = new ClassroomServiceIMPL();

    IStudentService studentService = new StudentServiceIMPL();

    public void menuClassroom() {
        int choice;
        do {
            System.out.println(".---------------------------CLASSROOM MANAGER--------------------------.");
            System.out.println("|                    1. Thêm mới lớp học                               |");
            System.out.println("|                    2. Hiển thị danh sách lớp học                     |");
            System.out.println("|                    3. Sửa thông tin của lớp học                      |");
            System.out.println("|                    4. Xóa lớp học                                    |");
            System.out.println("|                    0. Quay lai                                       |");
            System.out.println("'----------------------------------------------------------------------'");
            System.out.println("                  --->> Mời nhập lựa chọn của bạn <<---");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    addListClassroom();
                    break;
                case 2:
                    showListClassroom();
                    break;
                case 3:
                    editListClassroom();
                    break;
                case 4:
                    deleteListClassroom();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void addListClassroom() {
        System.out.println("nhap so luong lop hoc can them: ");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhap thong tin cho lop thu " + (i + 1) + " ");
            Classroom newClassroom = new Classroom();
            System.out.println("nhap ten lop");
            newClassroom.setClassroomName(Config.scanner().nextLine());
            System.out.println("nhap trang thai lop (true/false)");
            newClassroom.setStatus(Boolean.parseBoolean(Config.scanner().nextLine()));
            classroomService.save(newClassroom);
        }
    }

    private void showListClassroom() {
        System.out.println("danh sach cac lop hoc");
        List<Classroom> classroomList = classroomService.findAll();
        for (Classroom classroom : classroomList) {
            System.out.println(classroom);
        }
    }

    private void editListClassroom() {
        System.out.println("nhap ma id cua lop can sua thong tin: ");
        int idEdit = Config.validateInt();
        Classroom classroomEdit = classroomService.findById(idEdit);
        if (classroomEdit == null) {
            System.out.println("khong tim thay lop co id: " + idEdit);
        } else {
            System.out.println(classroomEdit);
            int choice;
            System.out.println("moi chon thong tin can sua");
            System.out.println("1. sua ten");
            System.out.println("2. sua trang thai");
            choice = Config.validateInt();
            switch (choice) {
                case 1:
                    System.out.println("nhap ten moi: ");
                    classroomEdit.setClassroomName(Config.scanner().nextLine());
                    break;
                case 2:
                    classroomEdit.setStatus(!classroomEdit.isStatus());
                    System.out.println("da thay doi trang thai ");
                    break;
                default:
                    System.err.println("ko hop le, moi nhap lai");
                    break;
            }
            classroomService.update(classroomEdit);
        }
    }

    private void deleteListClassroom() {
        System.out.println("nhap ma id cua lop can xoa: ");
        int idDelete = Config.validateInt();
        List<Student> studentList = studentService.findAll();
        for (Student student : studentList) {
            if (student.getClassroom().getClassroomId() == idDelete) {
                System.out.println("lop hoc da ton tai sinh vien, khong duoc xoa");
                return;
            }
        }

        boolean check = true;
        for (Classroom classroom : classroomService.findAll()) {
            if (classroom.getClassroomId() == idDelete) {
                classroomService.deleteById(idDelete);
                System.out.println("xoa lop hoc thanh cong");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("ko tim thay lop hoc co id: " + idDelete);
        }
    }
}
