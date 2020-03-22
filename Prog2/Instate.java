/**
 * This class defines the properties and methods of Instate, a subclass of Student.
 * An Instate has all the properties of a student, but with a different implementation of tuitionDue due to
 * class-specific funds int variable, which it is dependent on.
 * Methods are included for constructing a Instate, calculating tuition, and returning a String representation,
 * which overrides the parent toString().
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

public class Instate extends Student {
    public static final int IN_STATE_CREDIT = 433;
    private int funds;

    /**
     * Constructor for Instate
     * @param fname First name of student
     * @param lname Last name of student
     * @param credit Number of credits student is taking
     * @param funds Total value of funding for in-state student
     */
    public Instate(String fname, String lname, int credit, int funds){
        super(fname, lname, credit);
        this.funds = funds;
    }

    /**
     * Calculates tuition for Instate student, consisting of a university fee, and a
     * per-credit fee.
     * The total tuition is decreased by the value of funds of the Instate student.
     * @return Total tuition for Instate student
     */
    public int tuitionDue(){
        int fee = 0;
        if (credit < PART_TIME_CUTOFF){
            fee = PART_TIME_FEE;
        }
        else {
            fee = FULL_TIME_FEE;
        }
        int total = 0;
        if (credit > CREDIT_CUTOFF){
            total = CREDIT_CUTOFF * IN_STATE_CREDIT;
        }
        else {
            total = this.credit * IN_STATE_CREDIT;
        }
        total += fee;
        if (credit >= 12) total -= funds;
        return total;
    }

    /**
     * Overrides toString of parent class Student, calling the super method and adding funds value to the end
     * of the return value
     * @return String representation of an instance of Instate
     */
    public String toString() {
        return super.toString() + " Funds:" + funds;
    }

    public static void main(String[] args){
        Student peter = new Instate("Peter", "Parker", 8, 0);
        System.out.println(peter.tuitionDue());
        System.out.println(peter);
        Student john = new Instate("John", "Young", 12, 1000);
        System.out.println(john.tuitionDue());
        System.out.println(john);
    }

}