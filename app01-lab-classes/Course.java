/**
 * This class will store inforemation on student's classes and
 * numbers.
 *
 * @author Daniel Grace
 */
public class Course
{
    // Attributes/Variables/Fields
    private String title;
    
    private String codeNo;
    
    /**
     * Constructor for objects of class Course it
     * stores the title and the code no
     */
    public Course(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
    }
    
    /**
     * This will pint out the title and codeNo
     */
    public void print()
    {
        System.out.println("Course: " + title + " " + codeNo);
    }
}