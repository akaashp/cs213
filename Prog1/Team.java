/**
 * @author
 */
public class Team {
    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4; //initial and grow size
    private TeamMember[] team;
    private int numMembers;

    public Team() {
        //this is the default constructor
        team = new TeamMember[GROW_SIZE];
        numMembers = 0;
    }

    private int find(TeamMember m) {
        for (int i = 0; i < numMembers; i++) {
            if (team[i].equals(m)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        TeamMember[] newTeam = new TeamMember[numMembers + 4];
        for (int i = 0; i < numMembers; i++) {
            newTeam[i] = team[i];
        }
        team = newTeam;
    }

    public boolean isEmpty() {
        return numMembers == 0;
    }

    public void add(TeamMember m) {
        if (numMembers == team.length) {
            grow();
        }
        team[numMembers] = m;
        numMembers++;
    }

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

    public boolean contains(TeamMember m) {
        return find(m) != -1;
    }

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
