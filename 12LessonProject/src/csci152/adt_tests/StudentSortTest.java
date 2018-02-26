package csci152.adt_tests;

import csci152.adt.SortedQueue;
import csci152.impl.LinkedListSortedQueue;

public class StudentSortTest {

    public static void main(String[] args) {
        SortedQueue studs = new LinkedListSortedQueue<Student>();

        Student a = new Student(10, "Daulet");
        Student b = new Student(13, "Adlet");
        Student c = new Student(12, "Kairat");
        Student d = new Student(11, "James");


        studs.insert(a);
        studs.insert(b);
        studs.insert(c);
        studs.insert(d);

        print(studs);
    }

    public static void print(Object msg) {
        System.out.println(msg);
    }

}
