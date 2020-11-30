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
    private ArrayList<Product> stock;
    List <Product> listClone = new ArrayList<Product>();
    // Use to get user input
    private InputReader input;
    
    private StockManager manager;
    
    private StockDemo oldStock;
    
    private final int idLimit = 100;
    private int idMax = 110;
    
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
        printHeading();
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
            delieverProduct();
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
    
    private void demoDeliever()
    {
        oldStock.demoDeliever();
    }
    
     /**
     * 
     */
    private void addProduct(int id)
    {
        int newId;
        String newName;
        
        System.out.println("\nAdding a new product...");
               
        newId = createNewID();
        newName = createNewName();
        
        Product product = new Product(newId, newName);
        
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
    
    private void searchProduct(String name)
    {
        System.out.println("Searching for a product...");
        System.out.println("Please enter the name: ");
        
        name = input.getInput();
        String product = name.toLowerCase();
        
        manager.productSearch(product);
        
    }
    
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
    
    private String createNewName()
    {
        name = input.getInput();
        while(name.length() == 0)
        {
            System.out.println("\n Please write type a name..");
            name = input.getInput();
        }
        System.out.println("\n Name has been accepted.");
        return name;
    }
    
    private void delieverProduct()
    {
        System.out.println("Delivering a product:");
        System.out.println("Please enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        System.out.println("Please enter the amount to be delivered:");
        String choice = input.getInput();
        int amount = Integer.parseInt(choice);
        
        manager.delivery(id, amount);
    }
    
    private void sellProduct()
    {
        System.out.println("Selling products:");
        System.out.println("Please enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        System.out.println("Please enter the amount to be sold:");
        String choice = input.getInput();
        int amount = Integer.parseInt(choice);
        
        manager.sellProduct(id, amount);
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
