/*
Employee Class:
This class contains multiple typos and needs debugged. There are no logical issues with this class 
besides the aforementioned typos.

Documentation:

@param
@return

*/
public abstract class Employee
{
   private String employeeNumber;
   private String lastName;
   private String firstName;
   protected double payRate
   protected String jobTitle;
   public void setEmployeeNumber(String num)
   {
     employeeumber = Num;
   }
   public void setLastName(String name)
   {
      lastname = name;
   }
   public void setFirstName(String name)
   {
      firstname = name;
   }
   public String getEmployeeNumber()
   {
      return employeeNumber;
   }
   public String getName()
   {
      return firstName + " " + lastname;
   }
   public double getPayRate()
   {
      return payRate;
   }
   public String getJobTitle()
   {
      return jobTitle;
   }
   public abstract void setPayRate(double rate);
   public abstract void setJobTitle()
}
