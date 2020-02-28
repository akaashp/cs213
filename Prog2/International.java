 public class International extends Student {
    public static final int INT_FEE = 350;
    public static final int INT_CREDIT = 945;
    private boolean exchange;
    public International(String fname, String lname, int credit, boolean exchange){
        super(fname, lname, credit);
        this.exchange = exchange;
    }
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

    public static void main(String[] args){
        Student david = new International("David", "Lee", 12, false);
        System.out.println(david.tuitionDue());
        System.out.println(david);

        Student mary = new International("Mary", "Yang", 17, true);
        System.out.println(mary.tuitionDue());
        System.out.println(mary);

    }
}