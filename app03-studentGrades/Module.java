
/**
 * Write a description of class Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Module
{
    private String moduleTitile;
    private String moduleCode;
    private String modulePercentage;
    
    public void grade(String modulePercentage)
    {
        this.modulePercentage = modulePercentage;
    }
    
    public void printGrade()
    {
        System.out.println("Your grade is: " + modulePercentage);
    }
}
