import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    public int score;
    private int count;
    private int stamina;
    public ArrayList<Items> inventory = new ArrayList<Items>();
    /**
     * added another comment
     * @param name
     */
    public Player(String Name)
    {
        this.name = name;
    }
    
        public boolean hasItem(Items targetItem)
    {
        for (Items item : inventory)
        {
            if (item == targetItem)
                return true;
        }
        return false;
    }
    
        public void getItem(Items item)
    {
        inventory.add(item);
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int setScore()
    {
        return score = 25;
    }
    
    public int setStamina()
    {
        return stamina = 25;
    }
    
    public void decreaseScore(int amount)
    {
        if(amount > 0)
        {
            score -= amount;
        } 
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    
    public void rest()
    {
        stamina = stamina + 5;
        score = score - 2;
    }
    
    public void printUserInfo()
    {
        System.out.println("This is the user information: ");
    }
}
