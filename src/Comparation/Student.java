package Comparation;

public class Student implements Comparable<Student> {
    // lam the nao de ghi de: co 1 cai Access Modifiel lon hon hoac bang cai ham mk muon ghi de,
    // kieu du lieu, ten, tham so truyen vao giong

    private int id;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Student s1) {
        // this.id la id cua cai doi tuong, cai hien tai can so sanh
        // c1:
        if (this.id == s1.id) {
            return 0;
        } else if (this.id > s1.id) {
            return 1;
        } else {
            return -1;
        }
        // c2:
        // return this.id - s1.id;
    }
}
