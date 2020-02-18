class ActiveItem extends Items {

  String Name;
  int totalCharges;
  static int ActiveID = 0;
  boolean Aquired = false;
  static String[] ActiveItems = new String[1];
  int collectedCharges = 0;    
  String realID = Name + " " + ActiveID;

  ActiveItem ( String Name, int TotalCharges) {

    this.Name = Name;
    this.totalCharges = totalCharges;
    //starts at 0 charges
    this.ActiveID = ActiveID + 1;
    System.out.println(ActiveID);

  }
  //start with an empty array
  static void Use(ActiveItem item) {

    if (ChargeFull(item) == false) {
      //If there are not enough charges, terminate the method.
      showCharge(item);
      System.out.println("You do not have enough charges");
      return;
    } 
    switch (item.Name) {
      case "Teleport!": 
      ItemsTable.Teleport();
      break;
      case "Teleport2.0":
      ItemsTable.Teleport2();
      break;
    }
    drainCharge(item);
  }
  static void drainCharge(ActiveItem item) {
    item.collectedCharges -= item.totalCharges;
  }
  static void showCharge (ActiveItem item) {
    System.out.println("Charges: " + item.collectedCharges + " \\ " + item.totalCharges);
  }
  static boolean ChargeFull (ActiveItem item) {
    boolean RETURN = false;
    if (item.collectedCharges >= item.totalCharges) {
      RETURN = true;
    }
    return RETURN;
  }
  public static void Show() {
    //ItemsTable.ActiveItemArray[3].collectedCharges = 3;
    //Before line doesnt work if there are less than 3 items in ActiveItems
    for (int i = 0; i < ItemsTable.ActiveItemArray.length; i++) {
      if (ItemsTable.ActiveItemArray[i].Aquired == true) {
        System.out.println(ItemsTable.ActiveItemArray[i].Name);
      }
    }
  }
  static void ArrayOfActiveItems() {
//empty
  }
  public static void Demo() {

    Show();
  }
}