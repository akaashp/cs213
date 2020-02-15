/**
  
 @author  
 */
import java.util.StringTokenizer;

public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   public Date(String d)
   {
      //use StringTokenizer to parse the String and create a Date object
      StringTokenizer st = new StringTokenizer(d, "/");
      while (st.hasMoreTokens()){
         try {
            this.month = Integer.parseInt(st.nextToken());
            this.day = Integer.parseInt(st.nextToken());
            this.year = Integer.parseInt(st.nextToken());
         }
         catch (Exception e){
            //System.out.println("Error: invalid input");
         }
      }
   }
   
   public Date(Date d)
   {
      //this is a constructor
      day = d.day;
      month = d.month;
      year = d.year;
   }      
   
   public boolean isValid() {
      boolean isLeapYear = false;
      if (this.year % 4 == 0) {
         if (this.year % 100 == 0) {
            if (this.year % 400 == 0) {
               isLeapYear = true;
            }

         } else {
            isLeapYear = true;
         }
      }

      int maxDays = 0;

      if (this.month > 12 || this.day>31) return false;

      if (this.month == 2) {
         maxDays = Month.DAYS_FEB;
         if (isLeapYear) maxDays++;
      }else if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
         maxDays = Month.DAYS_EVEN;
      }else{
         maxDays = Month.DAYS_ODD;
      }

      if (maxDays <this.day){
         return false;
      }

      return true;
   }
   
   @Override
   public String toString()
   {
       //use the format "month/day/year"
      String date = "";
      return  date += this.month + "/" + this.day + "/" + this.year;
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if (obj == null){
         return false;
      }
      if (this.getClass() != obj.getClass()){
         return false;
      }
      return day==((Date)obj).day && month==((Date)obj).month && year==((Date)obj).year;
   }

   public static void main(String [] args)
   {
      Date d = new Date("2/28/2000");
      System.out.println(d);
      System.out.println("valid: " + d.isValid());
      Date e = new Date("2/3/2011");
      Date f = new Date("2/4/2011");
      System.out.println(d.equals(e));
      System.out.println(d.equals(f));
      //testbed main; you must include test cases that exercise
      //the constructor and all methods in this class.
   }
}


