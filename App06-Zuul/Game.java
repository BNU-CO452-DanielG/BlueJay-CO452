/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Your name
 */

public class Game 
{
    private int stamina;
    private int score;
    private Player user;
    private Items items;
    private Parser parser;
    private Room currentRoom;
    private Map map;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        map = new Map();
        currentRoom = map.getStartRoom();
        parser = new Parser();
        user = new Player("Danny");
        score = user.setScore();
        stamina = user.setStamina();
    }

        /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Your aim is to reach the treasure.. You need to GET items to do so..");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;
                

            case HELP:
                printHelp();
                break;
                
            case GET:
                grabItem();
                break;
                

            case GO:
                goRoom(command);
                break;
                

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }
     

    // implementations of user commands:
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the dank cave.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println("Your aim is to reach the treasure.. You need to GET items to do so..");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        
        goToRoom(nextRoom);
        }
    
    
    private void grabItem()
    {
        System.out.println("\nYou have taken the " +
                currentRoom.getroomsItem() +"\n");

        user.getItem(currentRoom.getroomsItem());
        currentRoom.removeContainedItem();
        user.printUserInfo();

    }

    private void goToRoom(Room nextRoom)
        {
        if (nextRoom == null)
        {
            System.out.println("There is no door!");
        }
        else
        {
            if (user.hasItem(nextRoom.getRequiredItem()))
            {
                stamina = stamina - 1;
                score = score - 1;
                System.out.println("Your stamina: " + stamina + "\nYour points: " + score);
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                if(stamina == 0)
                {
                    System.out.println("You've ran out of stamina! Better luck next time..");
                    System.exit(0);
                }
            }
            
            
            else {
                System.out.println("You cannot enter this room because you do not have a " + nextRoom.getRequiredItem());

            }

        }
    }
    
    
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}