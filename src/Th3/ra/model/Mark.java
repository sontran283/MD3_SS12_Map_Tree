package Th3.ra.model;

public class Mark {
    private static int nextMarkId = 1; // Biến tĩnh để tự động tăng mã điểm
    private int markId;
    private Student student;
    private ra.model.Subject subject;
    private double point;

    public Mark() {
        this.markId = nextMarkId++;
    }

    public Mark(Student student, ra.model.Subject subject, double point) {
        this.markId = nextMarkId++;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public int getMarkId() {
        return markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ra.model.Subject getSubject() {
        return subject;
    }

    public void setSubject(ra.model.Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }


    public void displayData() {
        System.out.println("Thông tin điểm số:");
        System.out.println("Mã điểm: " + markId);
        System.out.println("Tên học sinh: " + student.getStudentName());
        System.out.println("Tên môn học: " + subject.getSubjectName());
        System.out.println("Điểm số: " + point);
    }
}