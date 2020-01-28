public class Plot {
static void MainMenu() {
  System.out.println("");
}
}
class Menu {
  String name;
  String description;
  Menu (String name, String description) {
    this.name = name;
    this.description = description;
  }
  void displayName() {
    
    this.name = name;
    for (int j = 0; j < name.length() + 3; j++) {
      System.out.print("#");
    }
    System.out.println("#");
    System.out.print("#");

    for (int j = 0; j < name.length() + 2; j++) {
      System.out.print(" ");
    }
    System.out.println("#");

    System.out.println("# " + name + " #");

    System.out.print("#");
    for (int j = 0; j < name.length() + 2; j++) {
      System.out.print(" ");
    }
    System.out.println("#");

    for (int j = 0; j < name.length() + 3; j++) {
      System.out.print("#");
    }
    System.out.println("#");
  }
  String getName() {
    return this.name;
  }
}