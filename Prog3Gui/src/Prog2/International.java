package Prog2;

/**
 * This class defines the properties and methods of International, a subclass of Student.
 * An International has all the properties of a student, but with a different implementation of tuitionDue due to
 * class-specific exchange boolean variable, which it is dependent on.
 * Methods are included for constructing a International, calculating tuition, and returning a String representation,
 * which overrides the parent toString().
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

public class International extends Student {
    public static final int INT_FEE = 350;
    public static final int INT_CREDIT = 945;
    private boolean exchange;

    /**
     * Constructor for International
     * @param fname First name of student
     * @param lname Last name of student
     * @param credit Number of credits student is taking
     * @param tristate Exchange status of student, true/false
     */
    public International(String fname, String lname, int credit, boolean exchange){
        super(fname, lname, credit);
        this.exchange = exchange;
    }

    /**
     * Calculates tuition for International student, consisting of a university fee, international fee, and a
     * per-credit fee.
     * International students with a 'true' exchange value only pay the full-time university fee + international fee.
     * @return Total tuition for International student
     */
    public int tuitionDue(){
        int fee = INT_FEE;
        if (exchange){
            fee += FULL_TIME_FEE;
            return fee;
        }
        else {
            if (credit < PART_TIME_CUTOFF){
                fee += PART_TIME_FEE;
            }
            else {
                fee += FULL_TIME_FEE;
            }

        }
        int total = 0;
        if (credit > CREDIT_CUTOFF){
            total = CREDIT_CUTOFF * INT_CREDIT;
        }
        else {
            total = this.credit * INT_CREDIT;
        }
        total += fee;
        return total;
    }

    /**
     * Overrides toString of parent class Student, calling the super method and adding exchange value to the end
     * of the return value
     * @return String representation of an instance of International
     */
     public String toString() {
         return super.toString() + " Is Exchange:" + exchange;
     }

    public static void main(String[] args){
        Student david = new International("David", "Lee", 12, false);
        System.out.println(david.tuitionDue());
        System.out.println(david);

        Student mary = new International("Mary", "Yang", 17, true);
        System.out.println(mary.tuitionDue());
        System.out.println(mary);

    }
}