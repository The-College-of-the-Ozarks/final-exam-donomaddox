/*
Coordinator Class:
There are no issues with this class. 

Documentation:

@param
@return

*/
public class Coordinator extends Employee
{
   public final static double PAY_RATE = 20.00;
   public void setPayRate(double rate)
   {
      if(rate > PAY_RATE)
        payRate = PAY_RATE;
      else
        payRate = rate;
   }
   public void setJobTitle()
   {
      jobTitle = "coordinator";
   }
}
