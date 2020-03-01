public class Outstate extends Student {
    public static final int OUT_STATE_CREDIT = 756;
    public static final int TRISTATE_CREDIT = 556;
    private boolean tristate;
    public Outstate(String fname, String lname, int credit, boolean tristate){
        super(fname, lname, credit);
        this.tristate = tristate;
    }
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