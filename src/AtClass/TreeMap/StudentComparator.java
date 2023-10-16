package AtClass.TreeMap;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    // renneric ==>  <Student>
    public int compare(Student s1, Student s2) {
        return s1.getId() - s2.getId();
    }
}
