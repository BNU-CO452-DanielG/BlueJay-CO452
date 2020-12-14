import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    //Make the list and the clone
    private ArrayList<Product> stock;
    List <Product> listClone = new ArrayList<Product>();
    // Use to get user input 
    private InputReader input;
    
    //Get other classes
    private StockManager manager;
    private StockDemo oldStock;
    
    //Set the min/max limit
    private final int idLimit = 100;
    private int idMax = 110;
    
    //Declaring variables
    private int id = 0;
    private String name;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
        oldStock = new StockDemo(manager);
    }
    
    /**
     * Prints out the heading and starts the program.
     */
    public void run()
    {
        getMenuChoice();
    }
    
    /**
     * Prints out heading with choices, gets user input and converts to lower case.
     * If the choice is quit, program finishes, otherwise executes the choice.
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getInput();
            choice = choice.toLowerCase();
            if(choice.equals("quit"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
    
   
    /**
     * Changes the choice to lower case, and then
     * takes the user to the correct menus.
     */
    private void executeMenuChoice(String choice)
    {
        choice.toLowerCase();
        if(choice.equals ("add"))
        {
            addProduct(id);
        }
        else if (choice.equals ("remove"))
        {
            removeProduct();
        }
        else if (choice.equals ("printall"))
        {
            manager.printAllProducts();
        }
        else if (choice.equals ("deliver"))
        {
            deliverProduct();
        }
        else if (choice.equals ("sell"))
        {
            sellProduct();
        }
        else if (choice.equals ("search"))
        {
            searchProduct(name);
        }
        else if (choice.equals ("check"))
        {
            manager.checkLowStock();
        }
        else if (choice.equals ("demo"))
        {
            oldStock.demoDeliever();
        }
        else if (choice. equals ("restock"))
        {
            manager.refillStock();
        }
        else if (choice.equals("range"))
        {
            System.out.println("The lowest ID is: " + idLimit);
            System.out.println("The highest ID is: " + idMax);
        }
    }
    
    /**
     * Activates demo deliver for ease of access.
     */
    private void demoDeliever()
    {
        oldStock.demoDeliever();
    }
    
     /**
     * Get's the users ID and name. If it passes
     * then the product is made with the max ID's
     * increasing.
     */
    private void addProduct(int id)
    {
        int newId;
        String newName;
        
        System.out.println("\nAdding a new product...");
               
        newId = createNewID();
        System.out.println("\nAdding name of product...");
        newName = createNewName();
        
        Product product = new Product(newId, newName);
        System.out.println("\nThe product has been made!");
        
        idMax = idMax + 1;
        manager.addProduct(product);
    }
    
    /**
     * Gets the ID and takes out the product.
     */
    private void removeProduct()
    {
        System.out.println("Removing a product:");
        System.out.println("\nPlease enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        if (manager.findProduct(id) == null)
        {
            System.out.println("This product doesn't exist, please try again.");
        }
        idMax = idMax - 1;
        manager.removeProduct(id);
    }
    
    /**
     * Get's the users input to lower case and
     * searches.
     */
    private void searchProduct(String name)
    {
        System.out.println("Searching for a product...");
        System.out.println("Please enter the name: ");
        
        name = input.getInput();
        String product = name.toLowerCase();
        
        manager.productSearch(product);
        
    }
    
    /**
     * Gets an ID and checks if the ID exists
     * or it is higher/lower than the limit.
     */
    private Integer createNewID()
    {
        id = input.getInt();
        while (manager.findProduct(id) != null)
        {
            System.out.println("\n The product is exists. Please choose another.");
                
            id = input.getInt();
        }
        
        if(id < idLimit)
        {
            System.out.println("\n The ID is too small, please input one over 100...");
            createNewID();
        }
                    
        return id;
    }
    
    /**
     * Checks if name is greater than 0, and then
     * and then accepts.
     */
    private String createNewName()
    {
        name = input.getInput();
        while(name.length() == 0)
        {
            System.out.println("\n Please enter a name..");
            name = input.getInput();
        }
        System.out.println("\n Name has been accepted.");
        return name;
    }
    
    /**
     * Get's the user ID and then the amount
     * to be delivered.
     */
    private void deliverProduct()
    {
        System.out.println("\nDelivering a product:");
        System.out.println("Please enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        System.out.println("Please enter the amount to be delivered:");
        String choice = input.getInput();
        int amount = Integer.parseInt(choice);
        manager.delivery(id, amount);
    }
    
    /**
     * Gets the ID and the amount to be sold. If the 
     * amount is smaller than zero restart.
     */
    private void sellProduct()
    {
        System.out.println("\nSelling products:");
        System.out.println("Please enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        System.out.println("Please enter the amount to be sold:");
        String choice = input.getInput();
        int amount = Integer.parseInt(choice);
        if(amount < 0)
        {
            System.out.println("\nThis is an invalid amount, try again.");
            sellProduct();
        }
        else
        {
            manager.sellProduct(id, amount);
        }
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Deliver:    Deliver prdoucts");
        System.out.println("    Sell:       Sell products");
        System.out.println("    Search:     Search for a product");
        System.out.println("    Check       Check the stock of items");
        System.out.println("    Demo        Demo buying a number of items");
        System.out.println("    Restock     Restock low items");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Range:      Check the range of ID's used");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Daniel Grace");
        System.out.println("******************************");
    }
}
