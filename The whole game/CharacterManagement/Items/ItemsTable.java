import java.util.*;
public class ItemsTable {

  //TargetPractice area

  static Collectables TargetPractice = new Collectables("Target Practice:  Crits increase damage","HitDamageIncrease");
  final static int baseHitDamageTP = 10;
  static double HitDamage = 10;
  public static double getHitDamage() {

    double multiplier = Math.pow(2, Enemy2.getNumCrit());
    HitDamage = 10 * multiplier;
    //Will always give at least 10 damage
    if (HitDamage > (Main.Player.attack * 10)) {
      HitDamage = Main.Player.attack * 10;
      //Damage cap at 10 times the player's current attack (minus this)
    }
    return HitDamage;
  }
  static void increaseHitDamage() {
    HitDamage *= 2;

    //Unused
  }

  //TargetPractice area
  //Toxic area

  static Collectables TOXIC = new Collectables ("TOXIC", "Poison");

  static double getDamage () {
    //Deal 10 damage per turn if lucky
    double damage;
    if (DoDamage() == true) {
      damage = 10;
      System.out.println("The enemy was hurt by poison!");
    } else {
      damage = 0;
    }
    return damage;
  }
  static boolean DoDamage() {
    Random random = new Random();
    return random.nextBoolean();
  }
  //Toxic area

  public static Collectables SacredArmor = new Collectables("Holy Armor", 500, 10, 500, 0);
  //Angel room, question mark, question mark?
  public static Collectables Passive = new Collectables("Passive", 500, -10, 0, 0);
  public static Collectables RPG = new Collectables("RPG", 0, 1000, 0, 0);
  public static Collectables AimBot = new Collectables("Aim Bot", 0, 0, 0, 100);
  public static Collectables BreakFast = new Collectables("Break fast!", 100, 0, 0, 0);
  public static Collectables [] ItemArray = {
    SacredArmor, RPG, AimBot, TargetPractice, TOXIC
    
  };
  static ActiveItem Teleport = new ActiveItem("Teleport!", 2);
  static ActiveItem Teleport2 = new ActiveItem("Teleport2.0", 2);
  static ActiveItem Teleport0 = new ActiveItem("Teleport 0.5", 4);
  static ActiveItem Bomberang = new ActiveItem("Bomberang!", 1);
  static ActiveItem D6 = new ActiveItem("the D6", 6);
  //Easier to find provability of whole items array than combining different types of objects in the same array. 
  public static ActiveItem [] ActiveItemArray = {
    Teleport, Teleport2, Bomberang, Teleport0, D6
  };
  public static Collectables [] itemsWithAbilities = {
    //For use with Enemy2's method which checks items with abilities
    TargetPractice, TOXIC
  };
  //The following array is unused, only there to prove that you can have subclass objects in a superclass object
  public static Items [] ItemsArray = {
    SacredArmor, RPG, Bomberang, AimBot, D6
  };
  static void getItem(Collectables item) {
    System.out.println(item.Name + " aquired!");
    item.collected = true;
    Main.Player.health += item.HealthUp;
    Main.Player.attack += item.AttackUp;
    Main.Player.defence += item.DefenceUp;
    Main.Player.critChance += item.CritChanceUp;
    System.out.println("Press enter to continue");
    
    Scanner input = new Scanner(System.in);
    input.nextLine();
  }
  static void getItem(ActiveItem item) {
    //All it does so far is set Aquired to true...
    item.Aquired = true;
    System.out.println(item.Name + " aquired!");
    System.out.println("Press enter to continue");
    Scanner input = new Scanner(System.in);
    input.nextLine();
  }
  public static void getRandomItem() {
    int ItemsAquired = 0;
    //Get a random item from the item pool
    Random random = new Random();
    int total = ActiveItemArray.length + ItemArray.length;
    int randomget = random.nextInt(total);
    for (int i = 0; i < total; i++) {
//Are all the items collected?
      int newI = i;

      if (newI >= ItemArray.length) {
        // use >= because then if item array is 3 long, and newI is also 3, it will be ItemArray[3] which will push an error message
        newI -= ItemArray.length;

        if (ActiveItemArray[newI].Aquired == true) {

          ItemsAquired++;
        
        }
      
      } else if (ItemArray[newI].collected == true) {
      
        //This will detect if it is already aquired
        //Not set yet
        ItemsAquired++;
      
      }
    }

    if (ItemsAquired == total) {
      //If all items collected, give BREAKFAST
      getItem(BreakFast);
      return;
    }

    if (randomget >= ItemArray.length) {
      //See above comment near newI >= ItemArray.length to see reason for >=
    //If the item is an active item, convert to active item
      randomget -= ItemArray.length;
      if (ActiveItemArray[randomget].Aquired == false) {
        getItem(ActiveItemArray[randomget]);
      } else {
        getRandomItem();
      }
    
    } else {
    
      if (ItemArray[randomget].collected == false) {
        getItem(ItemArray[randomget]);
      } else {
        getRandomItem();
      }    
    }
  }
}