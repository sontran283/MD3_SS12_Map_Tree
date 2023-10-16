package Comparation;

import java.util.Comparator;

// <Student>   gọi là rennerick
// Comparator  là bộ so sánh student
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // c1:
        // return s1.getId() - s2.getId();
        // c2:
        return s1.compareTo(s2);
    }
}
