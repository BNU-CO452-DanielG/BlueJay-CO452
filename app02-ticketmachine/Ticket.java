import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    private String destination;
    private int price;
    private Date issueDateTime;
    
    public Ticket(String destination, int price)
    {
        this.destination = destination;
        this.price = price;
        issueDateTime = new Date();
    }
    
    public void PrintTicketInfo()
    {
        System.out.println("------------------------");
        System.out.println("Ticket: " + destination);
        System.out.println("Price: " + price);
        System.out.println("------------------------");
        System.out.println("                         ");
    }
    
    public void PrintTicket()
    {
        System.out.println("   Ticket: " + destination);
        System.out.println("   Price: " + price);
        System.out.println("   Issued: " + issueDateTime);
    }
}
