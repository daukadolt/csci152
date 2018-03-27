package csci152.adt_tests;

public class Student implements Comparable<Student> {

    private int ID;
    private String name;

    public Student(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }

    public int compareTo(Student s) {
        return this.name.compareTo(s.getName());
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{name:" + this.name + "; ID:"+ this.ID + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student sobj = (Student) obj;
            return ID == sobj.ID && name == sobj.name;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.ID;
    }
}
