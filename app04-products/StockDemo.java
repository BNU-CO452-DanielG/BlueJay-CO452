import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * @modified Daniel Grace
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    
    Random generator = new Random();
  
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        manager.addProduct(new Product(100, "World Of Warcraft"));
        manager.addProduct(new Product(101, "Final Fantasy 14"));
        manager.addProduct(new Product(102, "Star Wars The Old Republic"));
        manager.addProduct(new Product(103, "Destiny 2"));
        manager.addProduct(new Product(104, "Assassin's Creed"));
        manager.addProduct(new Product(105, "Grand Theft Auto 5"));
        manager.addProduct(new Product(106, "Call Of Duty"));
        manager.addProduct(new Product(107, "Black Desert Online"));
        manager.addProduct(new Product(108, "NBA2k20"));
        manager.addProduct(new Product(109, "Fifa 20"));
        manager.addProduct(new Product(110, "Battlefield 4"));
    }
    
    /**
     * Delievers random amounts of items to the list.
     */
    public void demoDeliever()
    {
        System.out.println("Delievering:");
        
        int amount = 0;
        
        for(int id = 100; id <= 110; id++)
        {
            amount = generator.nextInt(7) + 1;
            manager.delivery(id, amount);
        }
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demoDeliverProduct()
    {
        // Show details of all of the products before delivery.
        manager.printProduct(101);
        
        // Take delivery of 5 items of one of the products.
        manager.delivery(101, 5);
        
        // Show the list of all products after delivery
        manager.printProduct(101);
    }
    

    
}