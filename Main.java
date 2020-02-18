/******************************************************************************

Version goals:
Add main menu
Add plot which will function as the Main
Add shop
 - have buyable  options
 - Kind of comleted already
Add items
 - numbered
 - give stat bonuses
Current bug report:
*******************************************************************************/
 import java.util.*;

public class Main
{
  //end
  public static NewPlayer Player = new NewPlayer();
  public static NewPlayer Base = new NewPlayer();
  public static void main (String[]args)
  {
    Menu DOWO = new Menu ("Cool menu name", "Cool menu option");
    System.out.println(DOWO.getName());
    DOWO.displayName();
    ItemsTable.getItem(ItemsTable.Teleport);
    ActiveItem.Demo();
    Dungeon.DungeonDemo();
    Room OP = new Room(3, 3, 3);
    OP.ConsoleMap();
    Room.ShowMap();
    Dungeon.navigateDungeon();
    Random random = new Random ();
    Scanner input = new Scanner (System.in);
	  String name = NamePicker.Name();
    System.out.println(name);
    Enemy2.Battle(EnemyTable.Teacher);
    int x = 0;
    while (x < 4) {
      int R = random.nextInt(5);
    //int R = 4;
    if (x == 2) {
      Shop.Buy(ItemsTable.RPG, -50);
    }
    switch (R) {
      case 1:
      Enemy2.Battle(EnemyTable.MissingYes);
        break;
      case 2:
        Shop.Buy(ItemsTable.RPG, 100);
        Shop.Buy(ItemsTable.SacredArmor, 100);
      	break;
      case 3:
      Enemy2.Battle(EnemyTable.Teacher);
        break;
      case 4:
      Enemy2.Battle(EnemyTable.OldMan);
      break;
      case 5:
      Enemy2.Battle(EnemyTable.Boi);
      break;
      default:
        Enemy2.Battle(EnemyTable.Yourself);
    } 
      x++;
    }// end of while loop
  }
// End
public static void RARITY () {
  NewPlayer Player = new NewPlayer();  
  double StatAverage = (Player.health + Player.attack + Player.critChance + Player.defence) / 350;
    String rarity = "Null";
    if (StatAverage >= 0.9)
      {
	rarity = "legendary";
      }
    else if (StatAverage >= 0.6)
      {
	rarity = "epic";
      }
    else if (StatAverage >= 0.35)
      {
	rarity = "rare";
      }
    else
      {
	rarity = "common";
      }
    System.out.println ("\n" + "You hava a " + rarity + " character.");
}

public static void Clear() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  
}
