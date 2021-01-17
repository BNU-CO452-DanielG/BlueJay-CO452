import java.util.ArrayList;
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{/**
  * Create all the rooms and link their exits together.
  */
    private Room startRoom;
    private Room caveEnterance;
    private Room noteCorridor;
    private Room gameOver;
    private Room oasis;
    private Room miningSite;
    private Room corridor;
    private Room rockWall;
    private Room quizRoom;
    private Room treasure;
    
    ArrayList<Items> inventory = new ArrayList<Items>();
    
    public Map()
    {
        createRooms();
        setLocations();
    }
    
    private void createRooms()
    {
      caveEnterance = new Room("In a dark cave.. many options lie ahead of you..");
      noteCorridor = new Room("There's something in the north... Something intimidating.. Don't go there!");
      gameOver = new Room("You were warned...");
      oasis = new Room("A break from the dark, and a sword laying in front of a large tree.");
      miningSite = new Room("A abandoned mining site.. Is that.. Explosives!?");
      corridor = new Room("You move forward barely seeing your feet..");
      rockWall = new Room("A large rock wall.. How do you break this?...");
      treasure = new Room("You found the treasure!");
      
      startRoom = caveEnterance;
    }
    
    private void setLocations()
    {
        caveEnterance.setExit("west", miningSite);
        caveEnterance.setExit("east", noteCorridor);
        caveEnterance.setExit("south", corridor);
        
        miningSite.setExit("east", caveEnterance);
        
        corridor.setExit("north", caveEnterance);
        corridor.setExit("south", rockWall);
        
        rockWall.setExit("north", corridor);
        rockWall.setExit("south", treasure);
        
        noteCorridor.setExit("north", gameOver);
        noteCorridor.setExit("east", oasis);
        noteCorridor.setExit("west", caveEnterance);
        
        
        oasis.setExit("west", noteCorridor);
    }
    
    private void setRequiredItems()
    {
        treasure.setRequiredItem(Items.EXPLOSIVES);
        corridor.setRequiredItem(Items.SWORD);
        gameOver.setRequiredItem(Items.TORCH);
    }
        
    public Room getStartRoom()
    {
        return startRoom;
    }
}