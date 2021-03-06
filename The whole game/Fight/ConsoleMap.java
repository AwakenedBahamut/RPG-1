import java.util.Random;
import java.util.Scanner;
public class ConsoleMap {
  public static void main( String[] args) {
    Room T = new Room(3, 3, 4);
    T.ConsoleMap();
  }
//major change
}
class Dungeon {
  static int [] [] [] CurrentDungeon = new int [6][6][3];
  /*How does this work? CurrentDungeon is a 3 dimensional array. The first 2 dimensions are coordinates, the last dimension is actually used to store room attributes. CurrentDungeon[0] stores whether it is cleared or not, CurrentDungeon[1] stores if it is in or not. CurrentDungeon[2] stores room type */
  //####################################
  static void createRooms (int times) {
    Random random = new Random();
    for (int i = 0; i < times; i++) {
        roomExist();
    }
  }
  static int createCoordinates () {
    Random random = new Random();
    return random.nextInt(6);
// six because the max room of the map
  }
  static void roomExist () {
    //checks the coordinates for the rooms
      int x = createCoordinates();
      int y = createCoordinates();
      if (CurrentDungeon[y][x][2] >= 1) {
        roomExist();
      }
      CurrentDungeon[y][x][2] = setRoomType();
  }
  static int setRoomType () {
    Random random = new Random();
    int[] roomTypes = { 1, 3, 4, 5};
    return roomTypes[random.nextInt(roomTypes.length)];
  }
  static void RoomUpdate() {
    //Needed?
  }
  public static void DungeonDemo() {
    createRooms(2);
    while (true) {
    //Main.Clear();
    //Clear each time you print map?
    Room.ShowMap();
    navigateDungeon();
    }

  }
  public static void navigateDungeon() {
    Scanner input = new Scanner(System.in);
    System.out.println("Do you want to go: ");
    System.out.println("          {w}Up");
    System.out.println("    {a} Left  {d} Right");
    System.out.println("          {s} Down");
    System.out.println(" {i} Inventory");
    String result = input.nextLine();
    boolean CanGo;
    int CurrentDungeon[] = getCurrentRoom();
    switch (result) {
      
      case "w":
      CanGo = goToRoom(CurrentDungeon[0] - 1, CurrentDungeon[1]);
      break;
      
      case "s":
      CanGo = goToRoom(CurrentDungeon[0] + 1, CurrentDungeon[1]);
      break;
      
      case "a":
      CanGo = goToRoom(CurrentDungeon[0], CurrentDungeon[1] - 1);
      break;
      
      case "d":
      CanGo = goToRoom(CurrentDungeon[0], CurrentDungeon[1] + 1);
      break;

      case "/tp":
        ItemsTable.Teleport2();
      break;

      case "i":
      ActiveItem.show();
      break;

      case "^":
      System.out.println("");
      break;
      
      default:
      System.out.println("Sorry, that is not a valid answer");

    }

    if (CanGo = false) {
      navigateDungeon();
    }
    ApplyRoomType();
  }
  static void ApplyRoomType() {
    int [] CR = getCurrentRoom();
    Random random = new Random();
    if (CurrentDungeon[CR[0]][CR[1]][0] == 1) {
//Don't repeat room start
    } else {
      switch (CurrentDungeon[CR[0]][CR[1]][2]) {
        case 0:
        break;
        case 1:
        EnemyEncounter.Encounter();
        CurrentDungeon[CR[0]][CR[1]][0] = 1;
        break;
        case 3:
        ItemsTable.getRandomItem();
        //supposed to give you an item, and it works now. However, infinite items glitch
        //Now infinite items patched as of 2/1/20
        //Only gives you active items for now
        //Make the following number 0 for infinite items
        CurrentDungeon[CR[0]][CR[1]][0] = 1;
        break;
        case 4:
        CurrentDungeon[CR[0]][CR[1]][0] = 1;
        break;
        case 5:
        CurrentDungeon[CR[0]][CR[1]][0] = 1;
        break;
        default:
        System.out.println("I am error");
        ERRORROOM();
      }
    }
  }
  static void ERRORROOM() {
    Random random = new Random();
    System.out.println("ERROR");
    switch(random.nextInt(5)) {
      case 0:
        ItemsTable.getRandomItem();
      break;
      case 1:
        Enemy2.Battle(EnemyTable.MissingYes);
        ItemsTable.getRandomItem();
      break;
      case 2:
        Enemy2.getCoins(100);
      break;
      case 3:
        Enemy2.Battle(EnemyTable.Dip);
      break;
      case 4:
        System.out.println("      Tip ");
        System.out.println("_______________");
        System.out.println(gameTips[random.nextInt(gameTips.length)]);
      break;
      default:
      break;
    }
  }
  static String [] gameTips = {
    "\t Don't \n \t Die",
    "\t Don't \n \t Resist",
    "\t You aren't \n \t Ready",
    "\t Stop while \n \t you're ahead", 
    "https://cdn.kastatic.org/ka-perseus-images/6c2337f907c1b3550e98911f1e55ec1875c1d68b.png"
  };
  public static int getRooms() {
    int returnRooms = 0;
    for (int i = 0; i < CurrentDungeon.length; i++) {
      for (int j = 0; j < CurrentDungeon[1].length; j++) {
        if (CurrentDungeon[i][j][2] > 0) {
          returnRooms++;
        }
      }
    }
    return returnRooms;
  }
  public static boolean goToRoom(int x, int y) {
    //Will return false if the room is not on the map
    System.out.println("You will go to room: " + x + " , " + y);
    try {
      if (CurrentDungeon[x][y][2] == 0) {
        System.out.println("YoU cAn'T gO tHeRe");
        return false;
      }
    } catch (Exception e) {
      System.out.println("You cannot go there");
      return false;
    }

    //Check if the room given is on the map: if so clear all the rooms, if not return false

    for (int i = 0; i < CurrentDungeon.length; i++) {
      for (int j = 0; j < CurrentDungeon[i].length; j++) {
          
          CurrentDungeon[i][j][1] = 0;
          //Set CurrentDungeon room to not in
      
      }
    }
    // if the room is good, make sure to go to room
    CurrentDungeon[x][y][1] = 1;
    //You are in current room
    return true;
  }
  public static int[] getCurrentRoom() {

    int[] XandY= new int[2];
    for (int i = 0; i < CurrentDungeon.length; i++) {
      for (int j = 0; j < CurrentDungeon[i].length; j++) {
        if (CurrentDungeon[i][j][1] == 1) {
          XandY[0] = i;
          XandY[1] = j;
  //Note: if there are somehow two rooms with 1 as the value, then it will return the 1st room and not the second    
        }
    
      }
    
    }

  return XandY;
  
  }
  public static void setStartRoom() {
    Random random = new Random();
    CurrentDungeon[random.nextInt(6)][random.nextInt(6)][1] = 1;
  }  
  public static void setStartRoom(int x, int y) {
    CurrentDungeon[x][y][1] = 1;
  }  
}
class Room extends Dungeon{
  int type;
  int X;
  int Y;
  Room (int type, int X, int Y) {
    this.type = type;
    this.X = X;
    this.Y = Y;
  }
  void ConsoleMap() {

    // also unused for now
    System.out.println(this.type);
  }
  static void generateMap() {
    // unused for now: should return type char[][]
  }
  static void ShowMap () {
    //36 is the maximum amount of rooms for [6][6]
    // Throws non static context error
    //use this for now because cannot run method without
    int C [][][] = Dungeon.CurrentDungeon;
    String color = "Blue";

    for (int x = 0; x < C.length; x++) {
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y][2] >= 1) {
          Color.Text("+--------+", color, color, 1);
        } else {
          System.out.print("          ");
        }
      }
      System.out.println();
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y][2] >= 1) {
          Color.Text("_", color, color, 1);
          System.out.print("        "); 
          Color.Text("_", color, color, 1);
        } else {
          System.out.print("          ");
        }
      }
      System.out.println();
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y][2] >= 1) {
          Color.Text("_", color, color, 1);
          int [] CurrentDungeon = getCurrentRoom();
          if (CurrentDungeon[0] == x && CurrentDungeon[1] == y){
            System.out.print("    x   "); 
          } else {
            System.out.print("        "); 
          }
          Color.Text("_", color, color, 1);
        } else {
          System.out.print("          ");
        }
      }
      System.out.println();
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y][2] >= 1) {
          Color.Text("_", color, color, 1);
          System.out.print("        "); 
          Color.Text("_", color, color, 1);
        } else {
          System.out.print("          ");
        }
      }
      System.out.println();
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y][2] >= 1) {
          Color.Text("+--------+", color, color, 1);
        } else {
          System.out.print("          ");
        }

    }
    System.out.println();
    }

  }
  public static String setRoomColor(int C [][][], int x, int y) {
      String color = "White";
        switch(C[x][y][2]) {
          case 1:
          //System.out.println("Normal");
          color = "White";
          break;
          case 2:
          //System.out.println("Cleared");
          color = "White";
          break;
          case 3:
          color = "Yellow";
          //Treasure room
          break;
          case 4:
          color = "Purple";
          //Boss room
          break;
          case 5:
          color = "Red";
          //cursed room
          break;
          default:
          break;
        }
    return color;
  }
// end of method GenerateMap
public static void CheckRooms( int x, int y, char [][] C) {
            try {
            if (C[x - 1][y] == 'x') {
            Color.Text("+---------", "Red", "None", 1);
          } else if (C[x - 1][y] == 'x') {
            Color.Text("---------+", "Red", "None", 1);
          } else {
            Color.Text("+---------+", "Red", "None", 1);
          }
            } catch (Exception e) {
            if (C[C.length][y] == 'x') {
            Color.Text("+---------", "Red", "None", 1);
          } else if (C[0][y] == 'x') {
            Color.Text("---------+", "Red", "None", 1);
          } else {
            Color.Text("+---------+", "Red", "None", 1);
          }
            }
//Honestly this method is not needed
}
}