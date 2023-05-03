/*
Waitstaff Class:
An intern developer accidentaly deleted the implementation of the 
setPayRate method of this class. This class will also need to be debugged. 

Documentation:
This class sets the pay rate and job title for Waitstaff objects
@param
@return

*/
public class Waitstaff extends Employee
{
   public final static double PAY_RATE = 10.00;
   public void setPayRate(double rate)
   {
     if(rate > PAY_RATE)
        payRate = PAY_RATE;
      else
        payRate = rate;
   }
   public void setJobTitle()
   {
      jobTitle = "waitstaff";
   }
}
