
/**
 * Write a description of class Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Module
{
    private String moduleTitle;
    private String moduleCode;
    private int mark = 0;
    
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
    
}
