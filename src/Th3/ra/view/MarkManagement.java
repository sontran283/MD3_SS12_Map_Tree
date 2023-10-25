package Th3.ra.view;

import Th3.ra.config.Config;
import Th3.ra.model.Mark;
import Th3.ra.service.IClassroomService;
import Th3.ra.service.IMarkService;
import Th3.ra.service.IStudentService;
import Th3.ra.service.ISubjectService;
import Th3.ra.service.impl.ClassroomServiceIMPL;
import Th3.ra.service.impl.MarkServiceIMPL;
import Th3.ra.service.impl.StudentServiceIMPL;
import Th3.ra.service.impl.SubjectServiceIMPL;

public class MarkManagement {
    IMarkService markService = new MarkServiceIMPL();
    IClassroomService classroomService = new ClassroomServiceIMPL();
    IStudentService studentService = new StudentServiceIMPL();
    ISubjectService subjectService = new SubjectServiceIMPL();

    public void menuMark() {
        int choice;
        do {
            System.out.println("********************** MARK-MANAGEMENT ************************");
            System.out.println("1. Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2. Hiển thị danh sách tất cả điểm thi");
            System.out.println("3. Sắp xếp điểm thi theo thứ tự giảm dần");
            System.out.println("4. Thay đổi điểm theo mã id ");
            System.out.println("5. Xóa điểm theo mã id ");
            System.out.println("6. Hiển thị danh sách điểm thi theo mã môn học (Chọn từng mã môn học để hiển thị) ");
            System.out.println("7. Hiển thị đánh giá học lực của từng học sinh theo mã môn học  ");
            System.out.println("0. Quay lại");
            System.out.println("--->> Mời nhập lựa chọn của bạn <<---");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    addMark();
                    break;
                case 2:
                    showMark();
                    break;
                case 3:
                    sortMark();
                    break;
                case 4:
                    editMark();
                    break;
                case 5:
                    deleteMark();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void deleteMark() {

    }

    private void editMark() {

    }

    private void sortMark() {

    }

    private void addMark() {
        System.out.println("moi nhap so luong diem thi can nhap");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhap diem thi thu " + (i + 1) + ", ");
            Mark mark = new Mark();
            System.out.println("danh sach sinh vien chon lua");  // chon sinh vien nhap diem
            for (int j = 0; j < studentService.findAll().size(); j++) {
                System.out.println((j + 1) + ", " + studentService.findAll().get(j).getStudentName());
            }

            System.out.println("moi chon: ");
            while (true) {
                int choice = Config.validateInt();
                if (choice >= 0 && choice <= studentService.findAll().size()) {
                    System.out.println();
                    mark.setStudent(studentService.findAll().get(choice - 1));
                    break;
                } else {
                    System.out.println("lua chon ko dung, moi chon lai");
                }
            }

            // chon mon hoc
            System.out.println("danh sach mon hoc can chon");
            for (int j = 0; j < subjectService.findAll().size(); j++) {
                System.out.println((j + 1) + ", " + subjectService.findAll().get(j).getSubjectName());
            }
            System.out.println("moi chon");
            while (true) {
                int choice = Config.validateInt();
                if (choice >= 0 && choice >= studentService.findAll().size()) {
                    System.out.println();
                    mark.setSubject(subjectService.findAll().get(choice - 1));
                    break;
                } else {
                    System.out.println("lua chon ko dung, moi chon lai");
                }
            }

            // nhap diem cho diem thi
            System.out.println("moi nhap diem ");
            mark.setPoint(Double.parseDouble(Config.scanner().nextLine()));

            // goi den phuong thuc save cua lop MarkServiceIMPL de luu doi tuong mark vua nhap thong tin vao listMark
            markService.save(mark);
        }
    }

    private void showMark() {
        System.out.println("danh sach diem");
        for (Mark mark : markService.findAll()) {
            System.out.println(mark);
        }
    }
}
