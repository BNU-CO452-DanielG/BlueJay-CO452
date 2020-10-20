/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Student Name
 */
public class TicketMachine
{
    //The method for using coins for payment.
    public Coin coin;

    // The amount of money entered by a customer so far.
    private int balance;
    
    // The total amount of money collected by this machine.
    private int total;
    
    //Creates a new ticket, inserting the destination and the price.
    public Ticket aylesburyTicket = new Ticket("Aylesbury", 220);
    public Ticket amershamTicket = new Ticket("Amersham", 300);
    public Ticket highWycombeTicket = new Ticket("High Wycombe", 330);

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
    }
    
    public void addCoin(Coin coin)
    {
        System.out.println("You have inserted: " + coin);
        balance = balance + coin.getValue();
        System.out.println("Your balance is: " + balance + "p");
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    public void printAllTickets()
    {
        System.out.println("Our avaliable tickets are: ");
        System.out.println("                           ");
        System.out.println("The Amersham ticket: ");
        amershamTicket.PrintTicketInfo();
        System.out.println("The Aylesbury ticket: ");
        aylesburyTicket.PrintTicketInfo();
        System.out.println("The High Wycombe ticket: ");
        highWycombeTicket.PrintTicketInfo();
    }
    
     /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void buyticket(String destination)
    {
        if (destination.equals("Aylesbury"))
        {
            if (balance < 220)
            {
                System.out.println("Insert: " + (220 - balance) + "p");
            }
            else
            {
            System.out.println("Payment recieved.");
            System.out.println("Please take your ticket:");
            aylesburyTicket.PrintTicket();
            balance = balance - 220;
            System.out.println("   Your refund is: " + balance + "p");
            }
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public void refundBalance()
    {
        System.out.println("You have been refunded: " + balance + "p");
        balance = 0;
    }
}
