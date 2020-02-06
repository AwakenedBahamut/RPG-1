import java.util.Random;
class EnemyEncounter {
  public static void Encounter () {
    Random random = new Random();
    int EncounterNumber = random.nextInt(EnemyEncounters.length);
    for (int i = 0; i < EnemyEncounters[EncounterNumber].length; i++) {
      Enemy2.Battle(EnemyEncounters[EncounterNumber][i]);
    }
  }
  static Enemy2 EnemyEncounters [][] = {
    {EnemyTable.Teacher},
    {EnemyTable.Dip, EnemyTable.Dip},
    {EnemyTable.Boi, EnemyTable.Dip},
    {EnemyTable.Fly, EnemyTable.Fly, EnemyTable.Fly} ,
    {EnemyTable.Tank}
  };
  
}