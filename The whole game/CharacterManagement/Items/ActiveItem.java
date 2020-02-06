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
  static void activate(ActiveItem item) {
    
  }
  public static void Show() {
    //ItemsTable.ActiveItemArray[3].collectedCharges = 3;
    //Before line doesnt work if there are less than 3 items in ActiveItems
    for (int i = 0; i < ItemsTable.ActiveItemArray.length; i++) {
      System.out.println(ItemsTable.ActiveItemArray[i].collectedCharges);
    }
  }
  static void ArrayOfActiveItems() {
//empty
  }
  public static void Demo() {

    Show();
  }
}