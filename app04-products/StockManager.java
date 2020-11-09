import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @Daniel Grace
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    List <Product> listClone = new ArrayList<Product>();
    
    private String name;
    
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Finds product and reeplaces the name. 
     */
    public void renameProduct(int id, String replacementName)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            product.replaceName(replacementName);
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
    
    /**
     * If the check amount is true, add and print products.
     * Validate and verifyLow are then ran.
     */
    public void checkLowStock()
    {
        listClone.clear();
        
        for (Product product : stock)
        {
            if (product.checkAmount() == true)
            {
                listClone.add(product);
            }
        }
        
        validate();
        verifyLow();
    }
    
    /**
     * Checks the clone, if something's there returns true.
     */
    private boolean validate()
    {
        if (listClone.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * If the validate is true,print out list. 
     */
    private void verifyLow()
    {
        if (validate() == true)
        {
            System.out.println("The stock of the following products should be refilled");
        
            printClone();
        }
        else
        {
            System.out.println("The quantity of each product is at least 6");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        if(product != null)
        {
          product.increaseQuantity(amount);
          System.out.println("Prodcut Delievered: " + product);
        }
        else
        {
            System.out.println("Product ID " + id + " has not been found!");
        }
    }
    
    /**
     * Allows the user to type in a string and find the 
     * item they are looking for. If it exists, returns
     * the product with stock.
     */
    public void productSearch(String name)
    {
        if(name.startsWith("World"))
        {
            System.out.println(stock.get(0));
        }
        if(name.startsWith("Final"))
        {
            System.out.println(stock.get(1));
        }
        if(name.startsWith("Star"))
        {
            System.out.println(stock.get(2));
        }
        if(name.startsWith("Destiny"))
        {
            System.out.println(stock.get(3));
        }
        if(name.startsWith("Assassin"))
        {
            System.out.println(stock.get(4));
        }
        if(name.startsWith("Grand"))
        {
            System.out.println(stock.get(5));
        }
        if(name.startsWith("Call"))
        {
            System.out.println(stock.get(6));
        }
        if(name.startsWith("Black"))
        {
            System.out.println(stock.get(7));
        }
        if(name.startsWith("NBA"))
        {
            System.out.println(stock.get(8));
        }
        if(name.startsWith("Fifa"))
        {
            System.out.println(stock.get(9));
        }
        if(name.startsWith("Battle"))
        {
            System.out.println(stock.get(10));
        }
    }
    
    /**
     * Remove a product from the stock list.
     *
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            stock.remove(product);        
        }
        
        else
        {
            System.out.println("Unable to find product");
        }
    } 
    
    /**
     * Takes an ID, checks if it exists and returns.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            printProduct(id);
            product.sellQuantity(amount);
            printProduct(id);
        }
    }    

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        System.out.println();
        System.out.println("Grace's Stock List");
        System.out.println("====================");
        System.out.println();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    /**
     * Prints out the cloned list.
     */
    private void printClone()
    {
        listClone.forEach(product ->
        {
            System.out.println(product);
        }); 
    }
}