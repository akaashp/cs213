/**
 * This class defines the properties and methods of a team, a container class for instances of TeamMember.
 * TeamMembers are stored in an array, with an int to keep track of the total members.
 * Methods are included for finding a member, adding, and removing members.
 *
 * @author Yanheng Zhang, Akaash Patel
 */
public class Team {
    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4; //initial and grow size
    private TeamMember[] team;
    private int numMembers;

    /**
     * Constructor for team member
     *
     * @param name of the team member, team member's start date
     */
    public Team() {
        //this is the default constructor
        team = new TeamMember[GROW_SIZE];
        numMembers = 0;
    }

    /**
     * Finds a specific TeamMember in the team array by looping through it and checking for equality
     *
     * @param m TeamMember to be searched for in array team
     * @return First index of a matching TeamMember in array team if one exists, NOT_FOUND constant otherwise
     */
    private int find(TeamMember m) {
        for (int i = 0; i < numMembers; i++) {
            if (team[i].equals(m)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Copies the array team over to a new array with four additional slots
     */
    private void grow() {
        TeamMember[] newTeam = new TeamMember[numMembers + 4];
        for (int i = 0; i < numMembers; i++) {
            newTeam[i] = team[i];
        }
        team = newTeam;
    }

    /**
     * Checks if team is empty
     *
     * @return True if numMembers if 0, false otherwise
     */
    public boolean isEmpty() {
        return numMembers == 0;
    }

    /**
     * Adds TeamMember to array team, calling grow() on the array if full
     *
     * @param m TeamMember to be added
     */
    public void add(TeamMember m) {
        if (numMembers == team.length) {
            grow();
        }
        team[numMembers] = m;
        numMembers++;
    }

    /**
     * Removes TeamMember from array by finding the removed index through find(), replacing that with the last
     * element and then setting the last element to null
     *
     * @param m TeamMember to be removed
     * @return True if TeamMember was removed, false otherwise
     */
    public boolean remove(TeamMember m) {
        int remInd = this.find(m);
        if (!(remInd == -1)) {
            team[remInd] = team[numMembers - 1];
            team[numMembers - 1] = null;
            numMembers--;
            return true;
        }
        return false;
    }

    /**
     * Checks to see if array team contains a certain TeamMember
     *
     * @param m TeamMember to be checked for inclusion
     * @return False if no match can be found, and true otherwise
     */
    public boolean contains(TeamMember m) {
        return find(m) != -1;
    }

    /**
     * Prints each team member in array team
     */
    public void print() {
        //set up a for loop and call the toString() method
        for (int i = 0; i < numMembers; i++) {
            System.out.println(team[i]);
        }
    }

    public static void main(String[] args) {
        Team testTeam = new Team();
        Date d1 = new Date("2/29/2011");
        TeamMember henri = new TeamMember("Henri", d1);
        Date d2 = new Date("3/13/2013");
        TeamMember akaash = new TeamMember("Akaash", d2);
        Date d3 = new Date("4/20/2013");
        TeamMember jim = new TeamMember("Jim", d3);
        Date d4 = new Date("5/19/2014");
        TeamMember eric = new TeamMember("Eric", d4);
        Date d5 = new Date("5/19/2014");
        TeamMember daniel = new TeamMember("Daniel", d5);
        testTeam.add(henri);
        testTeam.add(akaash);
        testTeam.add(jim);
        testTeam.add(eric);
        testTeam.add(daniel);
        System.out.println(testTeam.isEmpty());
        System.out.println(testTeam.contains(henri));
        System.out.println(testTeam.remove(henri));
        testTeam.print();
    }
}
