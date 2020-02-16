/**
  User interface to handle input/output regarding team
  Can process inputs given by user and perform appropriate actions

 @author Akaash Patel, Yanheng Zhang
 */

import java.util.Scanner;

public class ProjectManager
{
   Scanner stdin;
   Team cs213;

   /**
    * Given an action by a user, chooses appropriate response
    * continually scans stdin for next operation
    */
   public void run()
   {
      cs213 = new Team();
      stdin = new Scanner(System.in);
      boolean done = false;

      while ( !done )
      {
         String nameIn = "";
         String dateInString = "";
         Date dateIn = null;
         String command = stdin.next();

         if (command.equals("A") || command.equals("R")){
            nameIn = stdin.next();
            dateInString = stdin.next();
            dateIn = new Date(dateInString);

         }
         switch (command)
         {   
            case "A": add(nameIn,dateIn);
               break;
            case "R": remove(nameIn,dateIn);
               break;
            case "P": print();
               break;
            case "Q": done = true;
               break;
            default: System.out.println("Command '"+command+"' not supported!");//deal with bad command here
               break;
         }  
      }

      //write java code before you terminate the program
      print();
      System.out.println("The team is ready to go!");
      return;

   } //run()

   /**
    * Adds a given member if date is valid and the member is not already on the team
    * @param memName Name of member to be added
    * @param date Date associated with member to be added
    */
   private void add(String memName, Date date)
   {
      	//must check if the date is valid
      if (!date.isValid()){
         System.out.println(date.toString()+" is not a valid date!");
         return;
      }
	//must call the contains() method to check if a given 
	//team member is in the team already
      TeamMember newMember = new TeamMember(memName, date);
      if (cs213.contains(newMember)){
         System.out.println(newMember.toString()+" is already in the team.");
      }else{
         System.out.println(newMember.toString()+" has joined the team.");
         cs213.add(newMember);
      }

   }

   /**
    * Removes a given member f date is valid and member to be removed exists in the team
    * @param memName Name of member to be removed
    * @param date Date associated with member to be removed
    */
   private void remove(String memName, Date date)
   {
      //must check if the date is valid
      if (!date.isValid()){
         System.out.println(date.toString()+" is not a valid date!");
         return;
      }

      TeamMember newMember = new TeamMember(memName, date);
      if (cs213.contains(newMember)){
         System.out.println(newMember.toString()+"has left the team.");
         cs213.remove(newMember);
      }else{
         System.out.println(newMember.toString()+" is not a team member.");
         cs213.add(newMember);
      }
   }

   /**
    * Prints members on the team
    */
   private void print()
   {
      //must check if the team has 0 members.
      if (cs213.isEmpty()){
         System.out.println("We have 0 team members!");
      }else{
         System.out.println("We have the following team members:");
         cs213.print();
         System.out.println("-- end of the list --");
      }
   }   
} //ProjectManager
