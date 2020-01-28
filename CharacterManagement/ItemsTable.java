public class ItemsTable {

  public static Collectables OWO = new Collectables("OWO", 50, 50, 50, 50, false);
  public static Collectables SacredArmor = new Collectables("Holy Armor", 500, 10, 500, 0, false);
  public static Collectables Gun = new Collectables("Gun", 0, 100, 0, 0, false);
  public static Collectables HEALTHDED = new Collectables("Ded", -50, 500, 0, 100, false);
  public static Collectables MOM = new Collectables("MOM", 500, -10, 0, 0, false);
  public static Collectables RPG = new Collectables("RPG", 0, 1000, 0, 0, false);
  public static Collectables [] ItemArray = {
    OWO, SacredArmor, Gun, HEALTHDED, MOM, RPG
  };
}