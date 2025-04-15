import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    // declaring the instaance members
    private long prn;
    private String name;
    private Date dob;
    private double marks;

    // declaring constructors
    public Student(long prn, String name, Date dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    // getters and setters
    public long getPrn() {
        return prn;
    }

    public void setPrn(long prn) {
        this.prn = prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // display method
    public void displayStudentDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("PRN: " + prn);
        System.out.println("Name: " + name);
        System.out.println("DOB: " + sdf.format(dob));
        System.out.println("Marks: " + marks);
    }
}