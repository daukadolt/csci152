package csci152;

import csci152.adt.IntQueue;
import csci152.adt.IntStack;
import csci152.adt.Queue;
import csci152.impl.ArrayIntQueue;
import csci152.impl.ArrayIntStack;
import csci152.impl.ArrayQueue;

public class StudentTest {

    public static void main(String[] args) {
        Student s1 = new Student("Daulet", "Amirkhanov", 201585214);
        Student s2 = new Student("Bekzhan", "Berik", 201565218);
        Student s3 = new Student("Rauan", "Amangeldiyev", 201643215);

        Queue<Student> q = new ArrayQueue();

        q.enqueue(s1);
        q.enqueue(s2);
        q.enqueue(s3);

        print(q);


    }

    public static void print(Object args) {
        System.out.println(args);
    }


}
