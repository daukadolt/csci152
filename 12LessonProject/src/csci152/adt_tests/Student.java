package csci152.adt_tests;

public class Student implements Comparable<Student> {
    private Integer ID;
    private String name;

    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student student) {
//        return this.ID.compareTo(student.getID());
        return this.name.compareTo(student.getName());
    }

    @Override
    public String toString() {
        return "{name:" + this.name + "; ID:"+ this.ID + "}";
    }
}
