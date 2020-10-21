
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    private String courseName;
    private String moduleCode;
    private String percentageMark;
    
    public Course(String courseName, String moduleCode, String percentageMark)
    {
        this.courseName = courseName;
        this.moduleCode = moduleCode;
        this.percentageMark = percentageMark;
    }
    
    public void courseDetails()
    {
        System.out.println("Your course is: " + courseName);
        System.out.println("Your module code is: " + moduleCode);
    }
}

