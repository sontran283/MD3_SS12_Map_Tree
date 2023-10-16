package Comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_Comparator {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(0);

        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        StudentComparator comparator = new StudentComparator();
        System.out.println(comparator.compare(s1, s2) == 0 ?
                "s1 ==s2 " : (comparator.compare(s1, s2) > 0 ? "s1 > s2" : "s1 < s2"));

        System.out.println("gia tri lon nhat là: " + Collections.max(students, comparator));
    }
}
