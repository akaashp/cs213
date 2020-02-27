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
    }

    private void add(String command, String fName, String lName, int credit, String typeSpecificData) {


        if (command.equals("I")){

        }else if (command.equals("O")){

        }else if (command.equals("N")){

        }else{

        }

    }

    private void remove(String fName, String lName){

    }

    private void print(){

    }

}
