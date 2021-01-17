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
    private Room ominiousRoom;
    private Room oasis;
    private Room miningSite;
    private Room corridor;
    private Room rockWall;
    private Room quizRoom;
    private Room treasure;
    private Room well;
    private Room crittersRoom;
    
    ArrayList<Items> inventory = new ArrayList<Items>();
    
    public Map()
    {
        createRooms();
        setLocations();
        setRequiredItems();
    }
    
    private void createRooms()
    {
      caveEnterance = new Room("a dark cave.. many options lie ahead of you.. You must GET courage!", Items.COURAGE);
      noteCorridor = new Room("a dull corridor.There's something in the north... Something intimidating.. Don't go there!", Items.COURAGE);
      ominiousRoom = new Room("a rebel.. I like that.. take this: ", Items.TORCH);
      oasis = new Room("Coming across a break from the dark, and a sword laying in front of a large tree.", Items.SWORD);
      miningSite = new Room("at a abandoned mining site.. Is that.. Explosives!?", Items.EXPLOSIVES);
      corridor = new Room("moving forward barely seeing your feet..", Items.COURAGE);
      rockWall = new Room("met with a large rock wall.. How do you break this?...", Items.COURAGE);
      treasure = new Room("there! You found the treasure! Thanks for playing, type quit.", Items.COURAGE);
      well = new Room("at the bottom of a well.. maybe some of your belongings are around?", Items.LIGHTER);
      crittersRoom = new Room("surronded by critters, you use your lit torch to guide them out of the way.", Items.TORCH);
      
      startRoom = caveEnterance;
    }
    
    private void setLocations()
    {
        caveEnterance.setExit("west", miningSite);
        caveEnterance.setExit("east", noteCorridor);
        caveEnterance.setExit("south", corridor);
        caveEnterance.setExit("north", well);
        
        miningSite.setExit("east", caveEnterance);
        
        corridor.setExit("north", caveEnterance);
        corridor.setExit("south", crittersRoom);
        
        crittersRoom.setExit("south", treasure);
        
        rockWall.setExit("north", corridor);
        rockWall.setExit("south", treasure);
        
        ominiousRoom.setExit("south", noteCorridor);
        
        noteCorridor.setExit("north", ominiousRoom);
        noteCorridor.setExit("east", oasis);
        noteCorridor.setExit("west", caveEnterance);
        
        
        oasis.setExit("west", noteCorridor);
        
        well.setExit("south", caveEnterance);
    }
    
    private void setRequiredItems()
    {
        ominiousRoom.setRequiredItem(Items.LIGHTER);
        caveEnterance.setRequiredItem(Items.COURAGE);
        miningSite.setRequiredItem(Items.COURAGE);
        oasis.setRequiredItem(Items.COURAGE);
        noteCorridor.setRequiredItem(Items.COURAGE);
        treasure.setRequiredItem(Items.EXPLOSIVES);
        corridor.setRequiredItem(Items.SWORD);
        crittersRoom.setRequiredItem(Items.TORCH);
        well.setRequiredItem(Items.COURAGE);
    }
        
    public Room getStartRoom()
    {
        return startRoom;
    }
}