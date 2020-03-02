public abstract class Student implements Comparable {
    public static final int PART_TIME_FEE = 846;
    public static final int FULL_TIME_FEE = 1441;
    public static final int PART_TIME_CUTOFF = 12;
    public static final int CREDIT_CUTOFF = 15;
    private String fname;
    private String lname;
    protected int credit;
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
    public int compareTo(Object obj){
        String thisName = this.fname + this.lname;
        String objName = ((Student) obj).fname + ((Student) obj).lname;
        return thisName.compareToIgnoreCase(objName);
    }
    //return a string with fname, lname and credit hours; subclasses will be using this method.
    public String toString() {
        return this.fname + " " + this.lname + " Credits:" + this.credit;
    }
    //compute the tuition due; concrete implementation is required in the subclasses.
    public abstract int tuitionDue();
}