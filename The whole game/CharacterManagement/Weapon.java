public class Weapon {
  String name;
  int damage;
  int durability;
  boolean Aquired;
  Weapon (String name, int damage, int durability, boolean Aquired) {
    this.name = name;
    this.damage = damage;
    this.durability = durability;
    this.Aquired = Aquired;
    if (Aquired = true) {
      // add to weapons
    }
    if (durability <= 0) {
      // remove from weapons
    }
  }

}