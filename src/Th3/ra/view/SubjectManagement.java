package Th3.ra.view;

import Th3.ra.config.Config;
import Th3.ra.model.Mark;
import Th3.ra.model.Subject;
import Th3.ra.service.IMarkService;
import Th3.ra.service.ISubjectService;
import Th3.ra.service.impl.MarkServiceIMPL;
import Th3.ra.service.impl.SubjectServiceIMPL;

import java.util.List;

public class SubjectManagement {

    ISubjectService subjectService = new SubjectServiceIMPL();
    IMarkService markService = new MarkServiceIMPL();

    public void menuSubjec() {
        int choice;
        do {
            System.out.println(".----------------------------SUBJECT MANAGER---------------------------.");
            System.out.println("|                    1. Thêm mới môn học                               |");
            System.out.println("|                    2. Hiển thị danh sách môn học                     |");
            System.out.println("|                    3. Sửa thông tin của lớp môn                      |");
            System.out.println("|                    4. Xóa môn học                                    |");
            System.out.println("|                    0. Quay lai                                       |");
            System.out.println("'----------------------------------------------------------------------'");
            System.out.println("                  --->> Mời nhập lựa chọn của bạn <<---");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    showSubject();
                    break;
                case 3:
                    editSubject();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private void addSubject() {
        System.out.println("nhap so luong mon hoc can them: ");
        int n = Config.validateInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhap mon hoc lop thu " + (i + 1) + " ");
            Subject subject = new Subject();
            System.out.println("nhap ten mon hoc");
            subject.setSubjectName(Config.scanner().nextLine());
            subjectService.save(subject);
        }
    }

    private void showSubject() {
        System.out.println("danh sach cac mon hoc");
        List<Subject> subjectList = subjectService.findAll();
        for (Subject subject : subjectList) {
            System.out.println(subject);
        }
    }

    private void editSubject() {
        System.out.println("nhap ma id cua lop can sua thong tin: ");
        int idEdit = Config.validateInt();
        Subject subjectEdit = subjectService.findById(idEdit);
        if (subjectEdit == null) {
            System.out.println("khong tim thay lop co id: " + idEdit);
        } else {
            System.out.println(subjectEdit);
            System.out.println("nhap ten moi");
            subjectEdit.setSubjectName(Config.scanner().nextLine());
            subjectService.update(subjectEdit);
        }
    }

    private void deleteSubject() {
        System.out.println("moi nhap id");
        int idDelete = Config.validateInt();
        List<Mark> markList = markService.findAll();
        for (Mark mark : markList) {
            if (mark.getSubject().getSubjectId() == idDelete) {
                System.out.println("mon hoc da co diem, ko duoc xoas");
                return;
            }
        }
        boolean check = true;
        for (Subject subject : subjectService.findAll()) {
            if (subject.getSubjectId() == idDelete) {
                subjectService.deleteById(idDelete);
                System.out.println("xoa thanh cong");
                check = false;
            }
        }
        if (check) {
            System.out.println("ko tim thay mon hoc theo id can xoa");
        }
    }
}
