package csci152;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private int year;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.year = 1;
    }

    public void incrementYear() {
        this.year++;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return "Full name: " + firstName + " " + lastName + "\n"
                +"ID: " + id + "\n"
                + "Year: " + year + "\n";
    }

}
