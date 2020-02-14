/**
 
 @author  
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   public TeamMember(String nm, Date date)
   {
       name = nm;
       startDate = date;
   }
   
   public Date getStartDate()
   {
      return this.startDate;
   }
   
   public boolean equals(Object obj)
   {
      //name and startDate must be the same
      if (obj == null){
         return false;
      }
      if (this.getClass() != obj.getClass()){
         return false;
      }
      return name.equals(((TeamMember)obj).name) && startDate.equals(((TeamMember)obj).startDate);
   }  
   
   public String toString()
   {
       //name + " " + startDate;
      return name + " " + startDate;
   }

   public static void main(String [] args)
   {
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