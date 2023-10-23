package Th3.ra.model;

public class Student {
    private static int nextStudentId = 1;
    private int studentId;
    private String studentName;
    private Classroom classroom;
    private String birthday;
    private boolean gender;
    private String phone;
    private String address;

    public Student() {
        this.studentId = nextStudentId++;
    }

    public Student(String studentName, Classroom classroom, String birthday, boolean gender, String phone, String address) {
        this.studentId = nextStudentId++;
        this.studentName = studentName;
        this.classroom = classroom;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void displayData() {
        System.out.println("Thông tin học sinh:");
        System.out.println("Mã học sinh: " + studentId);
        System.out.println("Tên học sinh: " + studentName);
        System.out.println("Lớp học: " + classroom.getClassroomName());
        System.out.println("Ngày sinh: " + birthday);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Địa chỉ: " + address);
    }
}