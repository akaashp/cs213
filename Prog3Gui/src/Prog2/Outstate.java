package Prog2;

/**
 * This class defines the properties and methods of Outstate, a subclass of Student.
 * An Outstate has all the properties of a student, but with a different implementation of tuitionDue due to
 * class-specific tristate boolean variable, which it is dependent on.
 * Methods are included for constructing a Outstate, calculating tuition, and returning a String representation,
 * which overrides the parent toString().
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

public class Outstate extends Student {
    public static final int OUT_STATE_CREDIT = 756;
    public static final int TRISTATE_CREDIT = 556;
    private boolean tristate;

    /**
     * Constructor for Outstate
     * @param fname First name of student
     * @param lname Last name of student
     * @param credit Number of credits student is taking
     * @param tristate Tristate status of student, true/false
     */
    public Outstate(String fname, String lname, int credit, boolean tristate){
        super(fname, lname, credit);
        this.tristate = tristate;
    }

    /**
     * Calculates tuition for Outstate student, consisting of a university fee and a per-credit fee.
     * Outstate full-time students with a 'true' tristate value get a tuition discount of 200 per credit.
     * @return Total tuition for Outstate student
     */
    public int tuitionDue(){
        int fee = 0;
        int total = 0;
        if (credit < PART_TIME_CUTOFF){
            fee = PART_TIME_FEE;
            total = this.credit * OUT_STATE_CREDIT;
        }
        else {
            fee = FULL_TIME_FEE;
            if (tristate){
                if (this.credit > CREDIT_CUTOFF){
                    total = CREDIT_CUTOFF * TRISTATE_CREDIT;
                }
                else {
                    total = this.credit * TRISTATE_CREDIT;
                }
            }
            else{
                if (this.credit > CREDIT_CUTOFF){
                    total = CREDIT_CUTOFF * OUT_STATE_CREDIT;
                }
                else {
                    total = this.credit * OUT_STATE_CREDIT;
                }
            }
        }
        total += fee;
        return total;
    }

    /**
     * Overrides toString of parent class Student, calling the super method and adding tristate value to the end
     * of the return value
     * @return String representation of an instance of Outstate
     */
    public String toString() {
        return super.toString() + " Is Tristate:" + tristate;
    }

    public static void main(String[] args){
        Student simons = new Outstate("Simons", "Michael", 8, false);
        System.out.println(simons.tuitionDue());
        System.out.println(simons);

        Student stiller = new Outstate("Stiller", "Anderson", 8, true);
        System.out.println(stiller.tuitionDue());
        System.out.println(stiller);

    }
}