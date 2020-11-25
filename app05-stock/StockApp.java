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
     * 
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * 
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
            addProduct();
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
            searchProduct();
        }
        else if (choice.equals ("check"))
        {
            manager.checkLowStock();
        }
        else if (choice.equals ("demo"))
        {
            demoDeliever();
        }
        else if (choice. equals ("restock"))
        {
            manager.refillStock();
        }
    }
    
    private void demoDeliever()
    {
        oldStock.demoDeliever();
    }
    
    /**
     * 
     */
    private void addProduct()
    {
        System.out.println("\nAdding a new product!");
        
        System.out.println("Please enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        
        System.out.println("Please enter the name: ");
        String name = input.getInput();
        
        Product product = new Product(id, name);
        
        manager.addProduct(product);
    }
    
    /**
     * 
     */
    private void removeProduct()
    {
        System.out.println("Removing a product:");
        System.out.println("\nPlease enter the ID: ");
        String value = input.getInput();
        int id = Integer.parseInt(value);
        
        manager.removeProduct(id);
    }
    
    private void searchProduct()
    {
        System.out.println("Delivering a product:");
        System.out.println("Please enter the name: ");
        String product = input.getInput();
        String name = product;

        manager.productSearch(product);
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
