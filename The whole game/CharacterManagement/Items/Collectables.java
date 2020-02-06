import java.util.Scanner;
import java.util.Random;
class Collectables extends Items {
  boolean collected = false;
  String Name;
  int HealthUp;
  int AttackUp;
  int DefenceUp;
  int CritChanceUp;
  String ability;
  Collectables (String Name, int HealthUp, int AttackUp, int DefenceUp, int CritChanceUp) {
    this.Name = Name;
    this.HealthUp = HealthUp;
    this.AttackUp = AttackUp;
    this.DefenceUp = DefenceUp;
    this.CritChanceUp = CritChanceUp;
  }
  Collectables (String Name, String ability) {
    this.Name = Name;
    this.ability = ability;
  }
  
}