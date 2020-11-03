/**
 * This class is the basis for the modules, creating a title and assigning the mark.
 *
 * @Daniel Grace
 * 
 */
public class Module
{
    private String moduleTitle;
    private String moduleCode;
    public int mark = 0;
    
    /**
     * Creates a module with a title and code.
    */
   public Module(String moduleTitle, String moduleCode)
    {
        this.moduleTitle = moduleTitle;
         this.moduleCode = moduleCode;
    }
    
    
    /**
     * Checks if the mark is 0 through 100 and then gives the marks.
     * If the value is not in this range a error is displayed.
     */
    public void awardMark(int mark)
    {
        if((mark >= 0) && (mark <= 100))
        {
          this.mark = mark;
        }
        else
        {
            System.out.println("This value is invalid!!");
        }
    }
    
     
    /**
     * Takes all modules and displays them. 
     */
    public void printDetails()
    {
        System.out.print("The module code is: " + moduleCode);
        System.out.println(" Title: " + moduleTitle + "\n");
    }
    
}
