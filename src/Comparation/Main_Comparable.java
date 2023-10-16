package Comparation;

import AtClass.TreeMap.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_Comparable {
    // student co kha nang so sanh
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(0);
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Collections.sort(students);

        System.out.println(s1.compareTo(s2) == 0 ? " s1==s2 " : (s1.compareTo(s2) > 0 ? "s1>s2" : "s1 <s2"));

        Student student = Collections.max(students);
        System.out.println(student);
    }
}
