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
    private String name;
    private Game game;
    private Room startRoom;
    Room outside, theater, pub, lab, office, tennis;
    ArrayList<Items> inventory = new ArrayList<Items>();
    
    public Map()
    {
        createRooms();
    }
    
    private void createRooms()
    {
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        tennis = new Room("in the tennis courts, with items layed around...");
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", tennis);

        theater.setExit("west", outside);

        pub.setExit("east", outside);
        

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        tennis.setExit("south", outside);
        tennis.setItem(new Items("Racket"));
        

        startRoom = outside;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
}