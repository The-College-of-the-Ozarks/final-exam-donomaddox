/*
StaffDinnerEvent Class:
We have noticed a large number of complaints from our users that
the program crashes if they accidentaly write out the number of guests (ex. Seventeen instead of 17).
Using topics from Chapter 12, modify the getGuests() method to perform error handling 
so that the user is continuously prompted until they enter the numbers (ints). 



Documentation:
The class prompts the user for the event info such as, guest count, menu choices and employee information.
@param
@return


*/
import java.util.*;
public class StaffDinnerEvent
{
   public static void main(String[] args)
   {
      Employee[] emps = new Employee[15];
      int count;
      String eventNum;
      int guests;
      DinnerEvent event;
      int option;
      int x;
      int y;
      int waitStaff;
      int chefs;
      int[] menuOption = new int[4];
      eventNum = getEventNumber();
      guests = getGuests();
      for(y = 0; y < menuOption.length; ++y)
         menuOption[y] = getMenu(y);   
      event = new DinnerEvent(eventNum, guests, menuOption[0], menuOption[1], menuOption[2], menuOption[3]);
      event.setContactPhone(getPhone());
      event.setEventType(getType());
      waitStaff = (guests / 10) + 1;
      for(count = 0; count < waitStaff; ++count)
         emps[count] = getWaitstaff();
      chefs = (guests / 25) + 1;
      for(count = waitStaff; count < chefs + waitStaff; ++count)
         emps[count] = getChef();
      emps[count] = getCoordinator();
      event.setEmps(emps);
      ++count; 
      
      System.out.println("\n\nNow display the event");
      displayDetails(event, count);

   }
   public static Waitstaff getWaitstaff()
   {
      Scanner in = new Scanner(System.in);
      Waitstaff ws= new Waitstaff();
      System.out.print("Enter Employee number for waitstaff >> ");
      ws.setEmployeeNumber(in.nextLine());
      System.out.print("Enter first name >> ");
      ws.setFirstName(in.nextLine());
      System.out.print("Enter last name >> ");
      ws.setLastName(in.nextLine());
      System.out.print("Enter pay rate >> ");
      ws.setPayRate(in.nextDouble());
      ws.setJobTitle();
      return ws;
   }
   public static Chef getChef()
   {
      Scanner in = new Scanner(System.in);
      Chef bt= new Chef();
      System.out.print("Enter Employee number for Chef >> ");
      bt.setEmployeeNumber(in.nextLine());
      System.out.print("Enter first name >> ");
      bt.setFirstName(in.nextLine());
      System.out.print("Enter last name >> ");
      bt.setLastName(in.nextLine());
      System.out.print("Enter pay rate >> ");
      bt.setPayRate(in.nextDouble());
      bt.setJobTitle();
      return bt;
   }
   public static Coordinator getCoordinator()
   {
      Scanner in = new Scanner(System.in);
      Coordinator co= new Coordinator();
      System.out.print("Enter Employee number for coordinator >> ");
      co.setEmployeeNumber(in.nextLine());
      System.out.print("Enter first name >> ");
      co.setFirstName(in.nextLine());
      System.out.print("Enter last name >> ");
      co.setLastName(in.nextLine());
      System.out.print("Enter pay rate >> ");
      co.setPayRate(in.nextDouble());
      co.setJobTitle();
      return co;
   }

   public static String getEventNumber()
   {
      String num;
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter event number >> ");
      num = input.nextLine();
      return num;
   }  
   public static int getGuests()
   {
      int guests;
      final int MIN_GUESTS = 5;
      final int MAX_GUESTS = 100;
      Scanner input = new Scanner(System.in);
     //try
     //{
      System.out.print("Enter number of guests >> ");
     //}
     //catch(InputMismatchException error)
       //{
       //System.out.print("Please enter a number >> ");
       //}
      guests = input.nextInt();
      while(guests < MIN_GUESTS || guests > MAX_GUESTS)
      {
          System.out.println("The number of guests must be between " +
            MIN_GUESTS + " and " + MAX_GUESTS);
          System.out.print("Please renter >> ");
          guests = input.nextInt();
      } 
      input.nextLine();
      return guests;
   }
   public static int getType()
   {
      int eType;
      Scanner input = new Scanner(System.in);
      System.out.println("Event types are");
      for(int x = 0; x < Event.EVENT_TYPES.length; ++x)
         System.out.println("    " + x + " " + Event.EVENT_TYPES[x]);
      System.out.print("Enter event type >> ");
      eType = input.nextInt();
      return eType;
   }
   public static void displayDetails(DinnerEvent e, int count)
   {
      Employee[] emps = new Employee[15];
      emps = e.getEmps();
      System.out.println("\nEvent #" + e.getEventNumber());
      System.out.println("The price for an event with " + e.getGuests() +
         " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
      System.out.println("Whether this is a large event is " +
         (e.getGuests() >= e.LARGE_EVENT));
      System.out.println("Contact phone number is: " + e.getContactPhone());
      System.out.println("The event is type " + e.getEventType() + " which is the following type: " + e.getEventTypeString());
      System.out.println("The menu includes " + e.getMenu());
      System.out.println("\nThe staff includes:");
      for(int x = 0; x < count; ++x)
         System.out.println(emps[x].getEmployeeNumber() + " " + emps[x].getName() + " " + emps[x].getPayRate() + " " + emps[x].getJobTitle());
   }
   public static DinnerEvent getLarger(DinnerEvent e1, DinnerEvent e2)
   {
      DinnerEvent larger = e2;
      if(e1.getGuests() >= e2.getGuests())
         larger = e1;
      return larger;
   }
   public static String getPhone()
   {
      String phone;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter contact phone number >> ");
      phone = input.nextLine();
      return phone;
   }
   public static int getMenu(int y)
   {
      int choice;
      if(y == 0)
         choice = displayEntreeMenu();
      else if (y == 1 || y == 2)
         choice = displaySidesMenu();
      else choice = displayDessertMenu();
      return choice;
   }
   public static int displayEntreeMenu()
   {
      Scanner keyboard = new Scanner(System.in);
      int x;
      int choice;
      System.out.println("Please select from the following entrees:");
      for(x = 0; x < DinnerEvent.ENTREES.length; ++x)
         System.out.println(x + "  --  " + DinnerEvent.ENTREES[x]);
      System.out.print("               >> ");
      choice = keyboard.nextInt();
      keyboard.nextLine();
      return choice;
   }    
   public static int displaySidesMenu()
   {
      Scanner keyboard = new Scanner(System.in);
      int x;
      int choice;
      System.out.println("Please select from the following sides:");
      for(x = 0; x < DinnerEvent.SIDES.length; ++x)
         System.out.println(x + "  --  " + DinnerEvent.SIDES[x]);
      System.out.print("               >> ");
      choice = keyboard.nextInt();
      keyboard.nextLine();
      return choice;
   }
   public static int displayDessertMenu()
   {
      Scanner keyboard = new Scanner(System.in);
      int x;
      int choice;
      System.out.println("Please select from the following desserts:");
      for(x = 0; x < DinnerEvent.DESSERTS.length; ++x)
         System.out.println(x + "  --  " + DinnerEvent.DESSERTS[x]);
      System.out.print("               >> ");
      choice = keyboard.nextInt();
      keyboard.nextLine();
      return choice;
   }      
      
}
