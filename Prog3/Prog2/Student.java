/**
 * This class defines the properties and methods of Student, an abstract parent class of three subclasses.
 * A Student consists of a first name and last name for identification, and a variable containing total credits.
 * Methods are included for constructing a Student, comparing two students, and returning a String representation.
 * The method signature for tuitionDue() is included in Student; a concrete implementation is defined in each
 * subclass.
 * @author  Akaash Patel, Yanheng Zhang
 */


public abstract class Student implements Comparable {
    public static final int PART_TIME_FEE = 846;
    public static final int FULL_TIME_FEE = 1441;
    public static final int PART_TIME_CUTOFF = 12;
    public static final int CREDIT_CUTOFF = 15;
    private String fname;
    private String lname;
    protected int credit;

    /**
     * Constructor for Outstate
     * @param fname First name of student
     * @param lname Last name of student
     * @param credit Number of credits student is taking
     */
    public Student(String fname, String lname, int credit) {
        this.fname = fname;
        this.lname = lname;
        this.credit = credit;
    } //constructor
    //must implement compareTo method because Student class implements the Comparable Interface
//return 0 if fname and lname of the two students are equal,
//return -1 if this fname and lname is < obj’s, return 1 if this fname and lname is > obj’s
//Hint: use the .equals and compareToIgnoreCase methods of the String class to compare fname
//and lname; names are not case-sensitive

    /**
     * Compares Student to object by typecasting to Student and using compareToIgnoreCase on the sum of first
     * name and last name values for both objects
     * @param obj Object for Student to be compared to
     * @return -1 if this fname and lname is less than object's, 1 if it is greater, and 0 if equal
     */
    public int compareTo(Object obj){
        String thisName = this.fname + this.lname;
        String objName = ((Student) obj).fname + ((Student) obj).lname;
        return thisName.compareToIgnoreCase(objName);
    }
    //return a string with fname, lname and credit hours; subclasses will be using this method.

    /**
     * Returns String representation of Student.
     * @return String containing firstname, lastname, and credit hours of Student
     */
    public String toString() {
        return this.fname + " " + this.lname + " Credits:" + this.credit;
    }
    //compute the tuition due; concrete implementation is required in the subclasses.

    /**
     * Calculates tuition due for Student. Implemented in the subclasses.
     * @return total tuition
     */
    public abstract int tuitionDue();
}