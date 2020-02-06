import java.util.*;
public class Items{
  static Random random = new Random();
  Map items = new HashMap ();
  int procChance;
  String description;
  int cost;
  public static int coins = 100;
  public static void main(String[] args) {
    Shop E = new Shop();
    Items I = new Items();
    Shop.Shop("Mah boi's shop of MEMES");
  }
  public static void ItemGetter(int provability) {
    int chance = random.nextInt(100) + 1;
    if (chance >= provability) {
      // aquire item
    }
  }
}
class Pickups extends Items {

}
//proof that "extends" works
class Bounty extends Items{
  int provability;
  String description;
}
class Chest extends Bounty{
  String Name;
  String description;
  double cost;
  int amount;
  Chest (String Name, String description, double cost, int amount){
    this.Name = Name;
    this.description = description;
    this.cost = cost;
    this.amount = amount;
  }

}
class Bag extends Bounty {
  
}
class Shop extends Bounty {
		static int AmountOfItems = 0;
  public static void Shop (String name){
	System.out.println("Welcome to " + name);
    switch (name ){
        case "Mah boi's shop of MEMES":
        Shop.option("chest", "UFO keys", "It pulses with an  otherworldly glow", 500, 10);
        break;
      	case "OWO":
        break;
    }
  }
      public static void option (String type, String product, String description, int cost, int amount){
        Scanner input = new Scanner(System.in);
        AmountOfItems++;
        String N[] = new String[10];
        N[AmountOfItems] = product;
        System.out.println();
    System.out.println(product);
    switch (type){
      case "chest":
        break;
      case "bag":
        break;
      case "item":
        break;
      case "SingleUse":
        break;
    }
    System.out.println(description);
    System.out.print("This costs " + cost);
    if (cost > 1) {
      System.out.print(" coins.");
    } else {
      System.out.print(" coin.");
    }
        
        // Converts the number given to an option to buy the product
    int answer = input.nextInt();
    //Buy(N[answer], cost);
  }
  public static void Buy (Collectables item, int cost) {
      //double cost = item.cost;
      Scanner input = new Scanner(System.in);
      System.out.println("Do you want to purchase " + item.Name + " for " + cost + " coins?");
      System.out.println("{1} Yes " + coins + " -> " + (coins - cost) +  "\n{2} No");
      String answer = input.nextLine();
      switch (answer) {
        case "1":
        if (coins < cost){
          System.out.println("Sorry, you cannot afford this.");
        } else {
          coins -= cost;
          System.out.println(item.Name + " aquired!");
          ItemsTable.getItem(item);
        }
        break;
        case "2":
        break;
        default: 
        System.out.println("Please enter 1 or 2");
        Buy(item, cost);
      }// end of Buy
      
    }
    static void Coins() {
      System.out.println(coins);
    }
    static void PickAttack () {
      
    }
}