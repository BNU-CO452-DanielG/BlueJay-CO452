import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getInput()
    {
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine();
        
        if (inputLine.length() == 0)
        {
            System.out.println("\n This is not a valid value..");
        }
        
        return inputLine;
    }
    
    public int getInt()
    {
        int number = 0;
        boolean valid = false;
        
        while(!valid)
        {
            String string = getInput();
            try
            {
                number = Integer.parseInt(string);
                valid = true;
            }
            catch(Exception wrong)
            {
                System.out.println("\n Please input a number..");
            }
        }
        return number;
    }
}
