/**
 * This class defines the properties and methods of a StudentList, a container class for Students.
 * Students, regardless of their type, are stored in an array, with an int to keep track of the total students.
 * Methods are included for finding, adding, removing students, printing all students.
 *
 * @author  Akaash Patel, Yanheng Zhang
 */
public class StudentList {
    //use array list of Students?
    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4; //initial and grow size
    private Student[] studentList;
    private int numStudents;

    /**
     * Constructor for StudentList
     */
    public StudentList(){
        studentList = new Student[GROW_SIZE];
        numStudents = 0;

    }

    /**
     * Finds a specific Student in the studentList array by looping through it using compareTo
     *
     * @param s Student to be searched for in array studentList
     * @return First index of a matching Student in array team if one exists, NOT_FOUND constant otherwise
     */
    private int find(Student s) {
        for (int i = 0; i < numStudents; i++) {
            if (studentList[i].compareTo(s)==0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Checks to see if array studentList contains a certain Student
     *
     * @param s Student to be checked for inclusion
     * @return False if no match can be found, and true otherwise
     */
    public boolean contains(Student s) {
        return find(s) != -1;
    }

    /**
     * Copies the array studentList over to a new array with four additional slots
     */
    private void grow() {
        Student[] newStudentList = new Student[numStudents + 4];
        for (int i = 0; i < numStudents; i++) {
            newStudentList[i] = studentList[i];
        }
        studentList = newStudentList;
    }

    /**
     * Adds Student to array studentList, calling grow() on the array if full
     *
     * @param s Student to be added
     */
    public void add(Student s){
        if (numStudents == studentList.length) {
            grow();
        }
        studentList[numStudents] = s;
        numStudents++;
    }

    /**
     * Removes Student from array by finding the removed index through find(), replacing that with the last
     * element and then setting the last element to null
     *
     * @param s Student to be removed
     * @return True if Student was removed, false otherwise
     */
    public boolean remove(Student s){
        int remInd = this.find(s);
        if (!(remInd == -1)) {
            studentList[remInd] = studentList[numStudents - 1];
            studentList[numStudents - 1] = null;
            numStudents--;
            return true;
        }
        return false;

    }

    /**
     * Prints each student in the studentList array
     */

    public void print(){
        for(int i = 0; i <numStudents; i++){
            System.out.println(studentList[i]+ " tuition due: $"+ studentList[i].tuitionDue());
        }
    }

    /**
     * Checks if studentList is empty
     *
     * @return True if numStudents is 0, false otherwise
     */
    public boolean isEmpty(){
        return numStudents == 0;

    }

    public static void main(String[] args) {
        StudentList sList = new StudentList();
        Student s1 = new Instate("riley", "zan", 11, 1000);
        Student s2 = new International("henri", "ban", 9,true);
        Student s3 = new Outstate("LIttle", "pump", 12, true);
        Student s4 = new Outstate("beck", "vick", 8, true);
        Student s5 = new Outstate("Mack", "Aveli", 13, true);
        sList.add(s1); sList.add(s2);sList.add(s3);sList.add(s4);sList.add(s5);

        sList.print();

    }
}