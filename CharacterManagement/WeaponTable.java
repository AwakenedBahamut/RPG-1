public class WeaponTable {
  static Weapon knife = new Weapon("Knife", 100, 5, false);
  public static Weapon Attack[] = new Weapon[0];
  public static void AttackChoice () {
  Attack[0] = knife;
  System.out.println("What attack would you like?");
  for (int x = 0; x <= Attack.length; x++) {
    System.out.println(Attack[x].name);
  }
  }
  public void increaseSize() {
   Weapon Attack2[] = new Weapon[Attack.length + 1];
   for (int i = 0; i < Attack.length; i++){
      Attack2[i] = Attack[i];
   }
}

}