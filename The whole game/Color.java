public class Color {
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";
public static final String BB = "\u001B[40m";
public static final String RB = "\u001B[41m";
public static final String GB = "\u001B[42m";
public static final String YB = "\u001B[43m";
public static final String BLB = "\u001B[44m";
public static final String PB = "\u001B[45m";
public static final String CB = "\u001B[46m";
public static final String WB = "\u001B[47m";

public static void Text (String Text, String Color1, String Color2, int PrintON) {
  String TxtColor = "Hi";
  String Bkgrnd = "Hi";
  switch (Color1) {
    case "Red": 
    TxtColor = ANSI_RED;
    break;
    case "Black":
    TxtColor = ANSI_BLACK;
    break;
    case "Green":
    TxtColor = ANSI_GREEN;
    break;
    case "Yellow":
    TxtColor = ANSI_YELLOW;
    break;
    case "Blue":
    TxtColor = ANSI_BLUE;
    break;
    case "Purple":
    TxtColor = ANSI_PURPLE;
    break;
    case "Cyan":
    TxtColor = ANSI_CYAN;
    break;
    case "White":
    TxtColor = ANSI_WHITE;
    break;

  }
  switch (Color2) {
    case "Red":
    Bkgrnd = RB;
    break;
    case "Black":
    Bkgrnd = BB;
    break;
    case "Green":
    Bkgrnd = GB;
    break;
    case "Yellow":
    Bkgrnd = YB;
    break;
    case "Blue":
    Bkgrnd = BLB;
    break;
    case "Purple":
    Bkgrnd = PB;
    break;
    case "Cyan":
    Bkgrnd = CB;
    break;
    case "White":
    Bkgrnd = WB;
    break;
    case "None":
    Bkgrnd = "Null";
    break;
  }
if (PrintON == 1) {
  if (Bkgrnd == "Null") {
  System.out.print(TxtColor + Text + ANSI_RESET);
} else {
    System.out.print(Bkgrnd + TxtColor + Text + ANSI_RESET);
}
} else {
if (Bkgrnd == "Null") {
  System.out.println(TxtColor + Text + ANSI_RESET);
} else {
    System.out.println(Bkgrnd + TxtColor + Text + ANSI_RESET);
}
}


}
}