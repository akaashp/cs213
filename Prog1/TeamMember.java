/**
 * This class defines the properties and methods of a team member, an object which makes up a full team in the container class.
 * Each instance of a TeamMember will contain his/her name and start date. Methods are included for constructing a new instance,
 * object equality, string outputs, and retreival of start date.
 *
 * @author Yanheng Zhang, Akaash Patel
 */
public class TeamMember {
    private String name;
    private Date startDate;

    /**
     * Constructor for team member
     *
     * @param nm   Name of the team member
     * @param date Team member's start date
     */
    public TeamMember(String nm, Date date) {
        name = nm;
        startDate = date;
    }


    /**
     * Getter for start date
     *
     * @return start date of TeamMember
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Compares properties of a TeamMember and an object to see if they are equal
     *
     * @param obj Object to be compared to for equality
     * @return true if both are TeamMembers and both name and start date are equal, false otherwise
     */
    public boolean equals(Object obj) {
        //name and startDate must be the same
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return name.equals(((TeamMember) obj).name) && startDate.equals(((TeamMember) obj).startDate);
    }

    /**
     * Creates string representation of a TeamMember for visualization
     *
     * @return concatenation of the name and start date, separated by a space
     */
    public String toString() {
        //name + " " + startDate;
        return name + " " + startDate;
    }

    public static void main(String[] args) {
        //testbed main; you must include test cases that exercise
        //the constructor and all methods in this class.
        Date d = new Date("2/29/2011");
        TeamMember m1 = new TeamMember("Henri", d);
        System.out.println(m1.getStartDate());
        TeamMember m2 = new TeamMember("Jack", d);
        System.out.println(m2.equals(m1));
        System.out.println(m1);

    }
}