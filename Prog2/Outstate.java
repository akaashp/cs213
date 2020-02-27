public class Outstate extends Student {
    public static final int OUT_STATE_CREDIT = 756;
    public static final int TRISTATE_CREDIT = 233;
    private boolean tristate;
    public Outstate(String fname, String lname, int credit, boolean tristate){
        super(fname, lname, credit);
        this.tristate = tristate;
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
            if (tristate){
                total = CREDIT_CUTOFF * TRISTATE_CREDIT;
            }
            else{
                total = CREDIT_CUTOFF * OUT_STATE_CREDIT;
            }
        }
        else {
            if (tristate){
                total = this.credit * TRISTATE_CREDIT;
            }
            else{
                total = this.credit * OUT_STATE_CREDIT;
            }
        }
        total += fee;
        return total;
    }
    public String toString() {
        String triStr = "";
        if (tristate){
            triStr = "Is Tristate";
        }
        else {
            triStr = "Is Not Tristate";
        }
        return super.toString() + " " + triStr;
    }

}