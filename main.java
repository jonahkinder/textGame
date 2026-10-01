import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       
      boolean isDone = false;
      
      int column = 1;
      int row = 1;
      boolean hasRed = false;
      boolean hasYellow = false;
      boolean hasGreen = false;
      
      String[][] rooms = new String[6][10];
      rooms[0][0] = "Wall";
      rooms[0][1] = "Wall";
      rooms[0][2] = "Wall";
      rooms[0][3] = "Wall";
      rooms[0][4] = "Wall";
      rooms[0][5] = "Wall";
      rooms[0][6] = "Wall";
      rooms[0][7] = "Wall";
      rooms[0][8] = "Wall";
      rooms[0][9] = "Wall";
      
      rooms[1][0] = "Wall";
      rooms[1][1] = "Start";
      rooms[1][2] = "Hallway";
      rooms[1][3] = "Red Room";
      rooms[1][4] = "Hallway";
      rooms[1][5] = "Hallway";
      rooms[1][6] = "Hallway";
      rooms[1][7] = "Hallway";
      rooms[1][8] = "Yellow Pedestal";
      rooms[1][9] = "Wall";
      
      rooms[2][0] = "Wall";
      rooms[2][1] = "Hallway";
      rooms[2][2] = "Wall";
      rooms[2][3] = "Wall";
      rooms[2][4] = "Hallway";
      rooms[2][5] = "Wall";
      rooms[2][6] = "Hallway";
      rooms[2][7] = "Wall";
      rooms[2][8] = "Wall";
      rooms[2][9] = "Wall";
      
      rooms[3][0] = "Wall";
      rooms[3][1] = "Hallway";
      rooms[3][2] = "Wall";
      rooms[3][3] = "Wall";
      rooms[3][4] = "Yellow Room";
      rooms[3][5] = "Wall";
      rooms[3][6] = "Green Room";
      rooms[3][7] = "Wall";
      rooms[3][8] = "Wall";
      rooms[3][9] = "Wall";
      
      rooms[4][0] = "Wall";
      rooms[4][1] = "Red Pedestal";
      rooms[4][2] = "Wall";
      rooms[4][3] = "Wall";
      rooms[4][4] = "Green Pedestal";
      rooms[4][5] = "Wall";
      rooms[4][6] = "Exit";
      rooms[4][7] = "Wall";
      rooms[4][8] = "Wall";
      rooms[4][9] = "Wall";
      
      rooms[5][0] = "Wall";
      rooms[5][1] = "Wall";
      rooms[5][2] = "Wall";
      rooms[5][3] = "Wall";
      rooms[5][4] = "Wall";
      rooms[5][5] = "Wall";
      rooms[5][6] = "Wall";
      rooms[5][7] = "Wall";
      rooms[5][8] = "Wall";
      rooms[5][9] = "Wall";

      
      String current_room = "Start";
      Scanner scan = new Scanner(System.in);
      
       
      while (!isDone) {
        System.out.println("\n\nCurrent Room: " + rooms[row][column] + "\n");
       
       if (rooms[row][column].equals("Start")) {
         System.out.println("The start of your adventure, and where you first woke up in this dark dungeon...");
       } else if (rooms[row][column].equals("Hallway")) {
         System.out.println("One of many dusty hallways, seeming to go on forever and ever.");
       } else if (rooms[row][column].equals("Red Room")) {
         System.out.println("A bright red room, stark against the drab hallways. A red door stands at the end.");
       } else if (rooms[row][column].equals("Red Pedestal")) {
         System.out.println("A seemingly normal hallway, except for the altar in the back, a key resting upon it.\n(Hint: type t to take items.)");
       } else if (rooms[row][column].equals("Crumbling Room")) {
         System.out.println("Taking the key seems to have set something off. The whole room is collapsing!");
       } else if (rooms[row][column].equals("Pitfall")) {
         System.out.println("You fall down the pit, and back to the start.");
         row = 1;
         column = 1;
       } else if (rooms[row][column].equals("Yellow Room")) {
         System.out.println("A familiar looking room, now in yellow.");
       } else if (rooms[row][column].equals("Green Room")) {
         System.out.println("Now it's green.");
       } else if (rooms[row][column].equals("Yellow Pedestal")) {
         System.out.println("You see a similar altar, though this time it's yellow. A key rests upon it.");
       } else if (rooms[row][column].equals("Green Pedestal")) {
         System.out.println("Another altar, this one green. Green key atop it.");
       } else if (rooms[row][column].equals("Exit")) {
         System.out.println("You escaped!!");
         break;
       }
       
       
         System.out.println("\nWhat do you want to do? \n(Type the first letter of the direction you want to travel.)");
         System.out.println("\n\n\t\t North: " + rooms[row - 1][column] + "\n\n West:  " + rooms[row][column - 1] + "\t\t\t East:  " + rooms[row][column + 1] +  "\n\n\t\t South: " + rooms[row + 1][column] + "\n\n\n\n\n\n\n");
         String direction = scan.nextLine();
         
         if (direction.equals("N") || direction.equals("n")) {
           if (rooms[row - 1][column].equals("Wall")) {
             System.out.println("\n\n\nCannot move into walls. Pick again.");
           } else if (rooms[row][column].equals("Crumbling Room")) {
             rooms[row][column] = "Pitfall";
            System.out.println("\n\n\nMoved North.");
            row--;
           }else{
            
             System.out.println("\n\n\nMoved North.");
           row --;
           }
         } else if (direction.equals("S") || direction.equals("s")) {
           if (rooms[row][column].equals("Green Room") && !hasGreen) {
             System.out.println("\n\n\nYou don't have the right key.");
           } else if (rooms[row][column].equals("Yellow Room") && !hasYellow) {
             System.out.println("\n\n\nYou don't have the right key.");
           } else if (rooms[row + 1][column].equals("Wall")) {
             System.out.println("\n\n\nCannot move into walls. Pick again.");
           } else {
             System.out.println("\n\n\nMoved South.");
           row ++;
           }
         } else if (direction.equals("E") || direction.equals("e")) {
           if (rooms[row][column].equals("Red Room") && !hasRed) {
             System.out.println("\n\n\nYou don't have the right key.");
           } else if (rooms[row][column + 1].equals("Wall")) {
             System.out.println("\n\n\nCannot move into walls. Pick again.");
           } else {
             System.out.println("\n\n\nMoved East.");
           column ++;
           }
         } else if (direction.equals("W") || direction.equals("w")) {
           if (rooms[row][column - 1].equals("Wall")) {
             System.out.println("\n\n\nCannot move into walls. Pick again.");
           } else {
             System.out.println("\n\n\nMoved West.");
           column --;
           } 
         } else if (direction.equals("T") || direction.equals("t")) {
           if (rooms[row][column].equals("Red Pedestal") && !hasRed) {
             System.out.println("\n\n\nYou take the key.");
             hasRed = true;
             rooms[row][column] = "Crumbling Room";
           } else if (rooms[row][column].equals("Yellow Pedestal") && !hasYellow) {
             System.out.println("\n\n\nYou take the key.");
             hasYellow = true;
           } else if (rooms[row][column].equals("Green Pedestal") && !hasGreen) {
             System.out.println("\n\n\nYou take the key.");
             hasGreen = true;
         }
         
         
       } 
         
       }
        
      }
}
       
        

    
