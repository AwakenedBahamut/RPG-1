import java.lang.Cloneable;
public class EnemyTable {
    public static Enemy2 Teacher = new Enemy2 ("Teacher", 50, 20, 15, 10, "QUICK MATHS");
    public static Enemy2 OldMan = new Enemy2 ("Old Man", 70, 30, 10, 20, "...");
    public static Enemy2 Yourself = new Enemy2 (NamePicker.Name + "(enemy)", Main.Base.health, Main.Base.attack, Main.Base.defence, Main.Base.critChance, "I know everything about you");
    public static Enemy2 Boi = new Enemy2 ("Boi", 50, 20, 15, 10, "\\(owo)/");
    public static Enemy2 MissingYes = new Enemy2 ("MissingYes", 1000, 30, 15, 10, "ERROR 404" + " /n YOU CANNOT ESCAPE ME " + NamePicker.Name);
    public static Enemy2 Dip = new Enemy2 ("Dip", 10, 10, 10, 10, "Dap");
    public static Enemy2 Fly = new Enemy2 ("Fly", 20, 0, 0, 0, "Buzzz...");
    public static Enemy2 Tank = new Enemy2("The Wall", 1000, 0, 0, 0, "Tank it up!");
    public static Enemy2 GetEnemy( Enemy2 enemy) {
      return enemy;
    }
}