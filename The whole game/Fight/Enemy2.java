import java.util.Scanner;
import java.util.Random;


public class Enemy2
{
  String currentName;
  int Ehealth;
  int Eattack;
  int EcritChance;
  int Edefence;
  String Lore;
  public static Scanner input = new Scanner(System.in);
  public static Random random = new Random();
  Enemy2 (String currentName, int Ehealth, int Eattack, int EcritChance, int Edefence, String Lore)
  {
    this.currentName = currentName;
    this.Ehealth = Ehealth;
    this.Eattack = Eattack;
    this.EcritChance = EcritChance;
    this.Edefence = Edefence;
    this.Lore = Lore;
  } // End of constructor
  // public 
   public static void Battle (Enemy2 Enemy)
  {
    Random random = new Random();
    // ------------------------------------------------------- \\
    int EnemyBaseHealth = Enemy.Ehealth;
    int EnemyBaseAttack = Enemy.Eattack;
    int EnemyBaseCritChance = Enemy.EcritChance;
    int EnemyBaseDefence = Enemy.Edefence;
    // ------------------------------------------------------- \\
    System.out.println(Enemy.currentName + " has approached you.");
    System.out.println ("\n" + Enemy.Lore);
    boolean BattleOver = false;
    boolean Win = false;
    Scanner input = new Scanner (System.in);
    while (BattleOver != true)
      {
      switch (prompt(Enemy)) {
        case 0: 
        break;
        case 1:
        Win = true;
        BattleOver = true;
        break;
        case 2:
        Win = false;
        BattleOver = true;
        break;
      }
  }
  ItemsTable.chargeActive();
      // give enemy back original stats \\
      // --------------------------------------------------- \\
  System.out.println(EnemyBaseHealth + " = EnemyBase health");
  System.out.println(Enemy.Ehealth + " = Enemy Health");
    Enemy.Ehealth = EnemyBaseHealth;
    Enemy.Eattack = EnemyBaseAttack;
    Enemy.EcritChance = EnemyBaseCritChance;
    Enemy.Edefence = EnemyBaseDefence;
      // --------------------------------------------------- \\
  }
  static double numCrit = 0;
  static double addDmg = 0;
  static double dmgMult = 1;
  public static double getNumCrit() {
    return numCrit;
  }
  public static void setNumCrit(double newCrit) {
    numCrit = newCrit;
  }
  public static double getAddDmg() {
    return addDmg;
  }
  public static void setAddDmg(double newAddDmg) {
    addDmg = newAddDmg;
  }
  public static double getDmgMult() {
    return dmgMult;
  }
  public static void setDmgMult(double newDmgMult) {
    dmgMult = newDmgMult;
  }
  static void ApplyBuff() {
    checkItems();
    Main.Player.attack += getAddDmg();
  }
  static void DeBuff() {
    Main.Player.attack -= getAddDmg();
    setAddDmg(0);
    truePoison = false;
  }

  static void checkItems() {
    if (ItemsTable.itemsWithAbilities[0].collected == true) {
      addDmg += ItemsTable.getHitDamage();
    }
    if (ItemsTable.itemsWithAbilities[1].collected == true) {
      truePoison = true;
    }
  }
  //Setters and getters for all the important variables regarding attack
  static boolean truePoison = false;
public static int prompt (Enemy2 Enemy) {
  ApplyBuff();
  //Apply any buff effects 
  Scanner input = new Scanner(System.in);
      System.out.println ("\t [ Action ] \n \t {1} [ Action ] \n \t {2} [ Check Stats ] \n \t {3} [ Run Away ]");
    int UserMove = input.nextInt ();
    int Win = 0;
    switch (UserMove)
      {
      case 1:
      int TurnResult = Attack(Enemy);
      Win = TurnResult;
	break;
      case 2:
	System.out.println ("Your stats are:" + "\n" + "Health = " + Main.Player.health + " / " + Main.Base.health + 
			    "\t Attack = " + Main.Player.attack +
			    "\t Critical strike chance = " + Main.Player.critChance +
			    "\t Defence = " + Main.Player.defence);
	System.out.println (Enemy.currentName + "`s stats are:" + "\n" + "Health = " +
			    Enemy.Ehealth + "\t Attack = " +
			    Enemy.Eattack + "\t Critical strike chance = " +
			    Enemy.EcritChance + "\t Defence = " +
			    Enemy.Edefence);
	break;
      case 3:
	int run = random.nextInt (100) + 1;
	if (run > 50)
	  {
	    System.out.println ("You got away!");
	    Win = 1;
	  }
	else
	  {
	    System.out.println ("You didn't get away.");
      int HealthLostNow = Enemy.Eattack -= Main.Player.defence;
      if (HealthLostNow <= 0) {
        HealthLostNow = 0;
      }
	    Main.Player.health -= HealthLostNow;
	    if (Main.Player.health <= 0)
      {
	Win = 2;
	System.out.println ("You lost.");
  return Win;
      }
	    System.out.println ("Your health is " + Main.Player.health);
	    
    }
        break;
      case 4:
      System.out.println("Okie dokie, you ded");
      Main.Player.health = 0;
      Win = 2;
      System.out.println("Wow! Your incredible!");
        break;
      }
    DeBuff();
  return Win;
} // end of prompt
  public static int Attack(Enemy2 Enemy) {
    //Do poison damage
    if (truePoison == true) {
      Enemy.Ehealth -= ItemsTable.getDamage();
    }
    Random random = new Random();
    int Crit = random.nextInt (100) + 1;
    
    	if (Crit < Main.Player.critChance)
	  {
	    Enemy.Ehealth -= Main.Player.attack * 2 - Enemy.Edefence;
	    System.out.println ("You landed a critical strike!");
      numCrit++;
      //Add one to the crits in a row
	  }
	else
	  {
	    Enemy.Ehealth -= Main.Player.attack - Enemy.Edefence;
      numCrit = 0;
	  };
	int Ecrit = random.nextInt (100) + 1;
	int EnemyDamage;
    int PlayerDamage;
	if (Ecrit < Enemy.EcritChance)
	  {
	    EnemyDamage = Enemy.Eattack * 2 - Main.Player.defence;
	    if (EnemyDamage <= 0) {
	        EnemyDamage = 1;
	    }
	    Main.Player.health -= EnemyDamage;
	    System.out.println (Enemy.currentName + " landed a critical strike!");
	  } else
	  {
	   	EnemyDamage = Enemy.Eattack - Main.Player.defence;
	    if (EnemyDamage <= 0) {
	        EnemyDamage = 1;
	    }
	    Main.Player.health -= EnemyDamage;
	  };
    	    if (Enemy.Ehealth <= 0)
      {
	System.out.println ("You won!");
  int CoinGain = random.nextInt(10) + 20;
  getCoins(CoinGain);
return 1;
      }
    else if (Main.Player.health <= 0)
      {
        	System.out.println ("You lost.");
return 2;
      }
	System.out.println ("Your health is " + Main.Player.health + " / " + Main.Base.health);
	System.out.println (Enemy.currentName + "`s health is " + Enemy.Ehealth + " / ");
      return 0;
  }
  public static void getCoins (int coins) {
    Items.coins += coins;
    System.out.println("You gained " + coins + " coins!");
    System.out.println("You now have " + Items.coins + " coins!");
  }
  public static void RunAway() {
    
  }
  public static void CheckStats() {
    
  }
  public static void PressEnter() {
    Scanner input = new Scanner(System.in);
    String Y = input.nextLine();
    int x = 0;
    while (x == 0) {
    switch (Y) {
      case "":
      System.out.println("OK");
      x++;
      break;
      default:
      break;
    }
    }
  }
  public static void Action() {
    System.out.println("What secondary action would you like?" + "\n" + "{1} \t Attack \n \t {2} Inventory \n \t {3} Go back");
    switch (input.nextInt()) {
      case 1:
      break;
      case 2:
      break;
      case 3:
      break;
      default:
      break;
    }
  }
}

