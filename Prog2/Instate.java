public class Instate extends Student {
    public static final int IN_STATE_CREDIT = 433;
    private int funds;
    public Instate(String fname, String lname, int credit, int funds){
        super(fname, lname, credit);
        this.funds = funds;
    }
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
        return total;
    }
    public String toString() {
        return super.toString() + " " + funds;
    }

}