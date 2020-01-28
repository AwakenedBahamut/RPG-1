import java.util.Scanner;
public class NamePicker {
  public static String Name = "o";
  public static void main( String [] args ) {
    String name = Name();
    System.out.println(name);
  }
public static String Name () {
    boolean namePicked = false;
    while (namePicked != true)
      {
      Scanner input = new Scanner (System.in);
      System.out.println ("What is your name?");
      Name = input.nextLine();
      if (Name == "GodMode") {
        // doesn't work yet
        Main.Player.attack += 1000;
        Main.Player.health += 1000;
      }
	  System.out.println ("Your name is " + Name + "? \n \t {1} Yes \n \t {2} No");
	int YesOrNo = input.nextInt ();
	switch (YesOrNo)
	  {
	  case 1:
	    System.out.println ("That's a nice name...");
	    namePicked = true;
	    break;
      case 2:
        System.out.println ("Wat?!");
	    break;
      default:
        System.out.println("Please enter 1 or 2");
	  }
	  System.out.print("\033[H\033[2J");
      }
  return Name;
}
}
