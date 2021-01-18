import java.util.ArrayList;
/**
 * The class for setting rooms
 *
 * @author Daniel Grace
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
    private Room treasure;
    private Room well;
    private Room crittersRoom;
    
    ArrayList<Items> inventory = new ArrayList<Items>();
    
    /**
     * Initialising map.
     */
    public Map()
    {
        createRooms();
        setLocations();
        setRequiredItems();
    }
    
    /**
     * Creates all the rooms with a description and item.
     */
    private void createRooms()
    {
      caveEnterance = new Room("a dark cave.. many options lie ahead of you.. You must GET courage!", Items.COURAGE);
      noteCorridor = new Room("a dull corridor.There's something in the north... Something intimidating.!", Items.COURAGE);
      ominiousRoom = new Room("a rebel.. I like that.. take this: ", Items.TORCH);
      oasis = new Room("Coming across a break from the dark, and a sword laying in front of a large tree.", Items.SWORD);
      miningSite = new Room("at a abandoned mining site.. Is that.. Explosives!?", Items.EXPLOSIVES);
      corridor = new Room("moving forward barely seeing your feet..", Items.COURAGE);
      rockWall = new Room("met with a large rock wall.. How do you break this?...", Items.COURAGE);
      treasure = new Room("there! With a loud BANG! You found the treasure! Thanks for playing, type quit.", Items.COURAGE);
      well = new Room("treading softly just as you hear... Skittering..?", Items.LIGHTER);
      crittersRoom = new Room("surronded by critters, you use your lit torch to guide them out of the way.", Items.TORCH);
      
      startRoom = caveEnterance;
    }
    
    /**
     * Sets the location for all exits.
     */
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
    
    /**
     * Sets the needed items to go to other rooms.
     */
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
        
    /**
     * Starts player in the start room.
     */
    public Room getStartRoom()
    {
        return startRoom;
    }
}