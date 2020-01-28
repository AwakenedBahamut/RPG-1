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
  static int [] [] CurrentRoom = new int [6][6];
  static void RoomUpdate() {
    //Needed?
  }
  public static void DungeonDemo() {
    Room.createRooms(25);
    while (true) {
    //Main.Clear();
    //Clear each time you print map?
    Room.ShowMap();
    navigateDungeon();
    System.out.println("Check");
    }

  }
  public static void navigateDungeon() {
    Scanner input = new Scanner(System.in);
    System.out.println("Do you want to go: ");
    System.out.println("          {w}Up");
    System.out.println("    {a} Left  {d} Right");
    System.out.println("          {s} Down");
    String result = input.nextLine();
    boolean CanGo;
    int CurrentRoom[] = getCurrentRoom();
    switch (result) {
      
      case "w":
      CanGo = goToRoom(CurrentRoom[0] - 1, CurrentRoom[1]);
      break;
      
      case "s":
      CanGo = goToRoom(CurrentRoom[0] + 1, CurrentRoom[1]);
      break;
      
      case "a":
      CanGo = goToRoom(CurrentRoom[0], CurrentRoom[1] - 1);
      break;
      
      case "d":
      CanGo = goToRoom(CurrentRoom[0], CurrentRoom[1] + 1);
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
    switch (Room.Rooms[CR[0]][CR[1]]) {
      case 1:
      EnemyEncounter.Encounter();
      Room.Rooms[CR[0]][CR[1]] = 2;
      break;
      case 3:
      //Items.activate(ItemsTable[random.nextInt(ItemsTable.Collectables.length)]);
      //supposed to give you an item
      break;
      default:

    }
  }
  public static boolean goToRoom(int x, int y) {
    //Will return false if the room is not on the map
    System.out.println("You will go to room: " + x + " , " + y);
    try {
      int [][] room = Room.getRooms();
      if (room[x][y] == 0) {
        System.out.println("YoU cAn'T gO tHeRe");
        return false;
      }
    } catch (Exception e) {
      System.out.println("You cannot go there");
      return false;
    }

    //Check if the room given is on the map: if so clear all the rooms, if not return false

    for (int i = 0; i < CurrentRoom.length; i++) {
      for (int j = 0; j < CurrentRoom[i].length; j++) {
          
          CurrentRoom[i][j] = 0;
      
      }
    }
    // if the room is good, make sure to go to room
    CurrentRoom[x][y] = 1;
    return true;
  }
  public static int[] getCurrentRoom() {

    int[] XandY= new int[2];
    for (int i = 0; i < CurrentRoom.length; i++) {
      for (int j = 0; j < CurrentRoom[i].length; j++) {
        if (CurrentRoom[i][j] == 1) {
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
    CurrentRoom[random.nextInt(6)][random.nextInt(6)] = 1;
  }  
  public static void setStartRoom(int x, int y) {
    CurrentRoom[x][y] = 1;
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
  static int[][] Rooms = new int[6][6];
  //RoomTaken?
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
      if (Rooms[y][x] >= 1) {
        roomExist();
      }
      Rooms[y][x] = setRoomType();
  }
  static int setRoomType () {
    Random random = new Random();
    int[] roomTypes = { 1, 2, 3, 4, 5};
    return roomTypes[random.nextInt(roomTypes.length)];
  }
  void ConsoleMap() {

    // also unused for now
    System.out.println(this.type);
  }
  static void generateMap() {
    // unused for now: should return type char[][]
  }
  public static int[][] getRooms () {
    return Rooms;
  }
  static void ShowMap () {
    //36 is the maximum amount of rooms for [6][6]
    // Throws non static context error
    //use this for now because cannot run method without
    int C [][] = Rooms;
    String color = "Blue";

    for (int x = 0; x < C.length; x++) {
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y] >= 1) {
          Color.Text("+--------+", color, color, 1);
        } else {
          System.out.print("          ");
        }
      }
      System.out.println();
      for (int y = 0; y < C[1].length; y++) {
        color = setRoomColor(C, x, y);
        if (C[x][y] >= 1) {
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
        if (C[x][y] >= 1) {
          Color.Text("_", color, color, 1);
          int [] CurrentRoom = getCurrentRoom();
          if (CurrentRoom[0] == x && CurrentRoom[1] == y){
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
        if (C[x][y] >= 1) {
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
        if (C[x][y] >= 1) {
          Color.Text("+--------+", color, color, 1);
        } else {
          System.out.print("          ");
        }

    }
    System.out.println();
    }

  }
  public static String setRoomColor(int C [][], int x, int y) {
      String color = "White";
        switch(C[x][y]) {
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
}
}