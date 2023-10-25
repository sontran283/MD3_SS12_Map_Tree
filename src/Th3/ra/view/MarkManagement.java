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

import java.util.Collections;
import java.util.Comparator;

public class MarkManagement {
    IMarkService markService = new MarkServiceIMPL();
    IClassroomService classroomService = new ClassroomServiceIMPL();
    IStudentService studentService = new StudentServiceIMPL();
    ISubjectService subjectService = new SubjectServiceIMPL();

    public void menuMark() {
        int choice;
        do {
            System.out.println(".------------------------------MARK MANAGER----------------------------.");
            System.out.println("|                1. Thêm điểm thi cho sinh viên                        |");
            System.out.println("|                2. Hiển thị danh sách điểm thi                        |");
            System.out.println("|                3. Sắp xếp điểm thi theo thứ tự giảm dần              |");
            System.out.println("|                4. Thay đổi điểm thi theo mã ID                       |");
            System.out.println("|                5. Xóa điểm thi theo mã ID                            |");
            System.out.println("|                6. Hiển thị điểm thi theo môn học                     |");
            System.out.println("|                7. Đánh giá học lực theo từng điểm của môn học        |");
            System.out.println("|                0. Quay lai                                           |");
            System.out.println("'----------------------------------------------------------------------'");
            System.out.println("                  --->> Mời nhập lựa chọn của bạn <<---");
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
                    showListMarkBySubJect();
                    break;
                case 7:
                    rankByPoinOfMark();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void rankByPoinOfMark() {
        // xắp xếp theo môn học
        Collections.sort(markService.findAll(), new Comparator<Mark>() {
            @Override
            public int compare(Mark o1, Mark o2) {
                return o1.getSubject().getSubjectName().compareTo(o2.getSubject().getSubjectName());
            }
        });
        // đánh giá theo điểm
        for (Mark mark : markService.findAll()) {
            if (mark.getPoint() >= 9) {
                System.out.print(mark);
                System.out.println(" - Xếp loại xuất sắc");
            } else if (mark.getPoint() >= 8) {
                System.out.print(mark);
                System.out.println(" - Xếp loại giỏi");
            } else if (mark.getPoint() >= 6.5) {
                System.out.print(mark);
                System.out.println(" - Xếp loại khá");
            } else if (mark.getPoint() > 5) {
                System.out.print(mark);
                System.out.println(" - Xếp loại trung bình");
            } else {
                System.out.print(mark);
                System.out.println(" - Xếp loại yếu");
            }
        }
    }

    private void showListMarkBySubJect() {
        System.out.println("Danh sách các môn học");
        for (int i = 0; i < subjectService.findAll().size(); i++) {
            System.out.println((i + 1) + ". " + subjectService.findAll().get(i).getSubjectName());
        }
        System.out.println("Mời lựa chọn môn học cần hiển thị điểm theo số: ");
        int choice = Config.validateInt();
        System.out.println("Danh sách điểm theo môn học");
        for (Mark mark : markService.findAll()) {
            if (mark.getSubject().getSubjectName().equals(subjectService.findAll().get(choice - 1).getSubjectName())) {
                System.out.println(mark);
            }
        }
    }

    private void deleteMark() {
        System.out.println("Nhập ID điểm cần xóa");
        int idDelete = Config.validateInt();
        Mark markDelete = markService.findById(idDelete);
        if (markDelete == null) {
            System.out.println("Không tồn tại điểm theo ID vừa nhập");
        } else {
            markService.deleteById(idDelete);
            System.out.println("Xóa điểm thành công");
        }
    }

    private void editMark() {
        System.out.println("Nhập ma ID điểm cần sửa: ");
        int idEdit = Config.validateInt();
        Mark markEdit = markService.findById(idEdit);
        if (markEdit == null) {
            System.out.println("Điểm cần sửa theo mã ID vừa nhập không tồn tại");
        } else {
            System.out.println(markEdit);
            System.out.println("Mời nhập điểm mới: ");
            markEdit.setPoint(Double.parseDouble(Config.scanner().nextLine()));
            System.out.println("Sửa điểm thành công");
        }
    }

    private void sortMark() {
        Collections.sort(markService.findAll(), new Comparator<Mark>() {
            @Override
            public int compare(Mark o1, Mark o2) {
                return (int) (o2.getPoint() - o1.getPoint());
            }
        });
        System.out.println("Đã sắp xếp theo điểm thành công");
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
        if (markService.findAll().isEmpty()) System.out.println("Danh sách rỗng !!!");

        System.out.println("danh sach diem");
        for (Mark mark : markService.findAll()) {
            System.out.println(mark);
        }
    }
}
