
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
    
    public Module(String moduleTitle, String moduleCode)
    {
        this.moduleTitle = moduleTitle;
         this.moduleCode = moduleCode;
    }
    
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
    
     public void printDetails()
    {
        System.out.println("This module is: " + moduleTitle);
        System.out.println("The module code is: " + moduleCode);
    }
    
}
