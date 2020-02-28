/**
 User interface to handle input/output regarding students
 Can process inputs given by user and perform appropriate actions

 @author Akaash Patel, Yanheng Zhang
 */

import java.util.Scanner;

public class TuitionManager{
    Scanner stdin;
    StudentList sList;

    public void run() {
        sList = new StudentList();
        stdin = new Scanner(System.in);
        boolean done = false;

        while (!done) {


            String query = stdin.nextLine();
            String[] inputs = query.split(" ");
            String command = inputs[0];
            String fName, lName, typeSpecificData;
            int credit;



            switch (command) {
                case "I":
                case "O":
                case "N":
                    fName = inputs[1];
                    lName = inputs[2];
                    credit = Integer.valueOf(inputs[3]);
                    if (credit<1 || (credit<9 && command.equals("N"))){
                        System.out.println("invalid number of credits");
                        break;
                    }
                    typeSpecificData = inputs[4];
                    add(command, fName, lName, credit, typeSpecificData);
                    break;
                case "R":
                    fName = inputs[1];
                    lName = inputs[2];
                    remove(fName, lName);
                    break;
                case "P":
                    print();
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    System.out.println("Command '" + command + "' not supported!");//deal with bad command here

                    break;
            }
        }
        System.out.println("Here is the full list of students:");
        print();
    }

    private void add(String command, String fName, String lName, int credit, String typeSpecificData) {


        if (command.equals("I")){
            int funds = Integer.valueOf(typeSpecificData);
            Instate tempStu = new Instate(fName, lName, credit, funds);
            if (containsStudent(tempStu)) return;

            sList.add(tempStu);

        }else if (command.equals("O")){
            boolean triState = typeSpecificData.equals("T");
            Outstate tempStu = new Outstate(fName, lName, credit, triState);
            if (containsStudent(tempStu)) return;

            sList.add(tempStu);

        }else if (command.equals("N")){
            boolean exchange = typeSpecificData.equals("T");
            International tempStu = new International(fName, lName, credit, exchange);
            if (containsStudent(tempStu)) return;

            sList.add(tempStu);

        }

    }

    private boolean containsStudent(Student s){
        if(sList.contains(s)){
            System.out.println("Duplicate Student");
            return true;
        }
        return false;
    }


    private void remove(String fName, String lName){
        Student tempStu = new Instate(fName, lName,5,100);//creates dummy instate student to try to remove based on name
        sList.remove(tempStu);

    }

    private void print(){
        if (sList.isEmpty()){
            System.out.println("There are 0 students on the list!");
        }else {
            sList.print();
        }
    }

}
