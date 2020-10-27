import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    private String courseName;
    private String courseCode;
    private int marks = 0;
    
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;
    
    public Course(String courseName, String moduleCode)
    {
        this.courseName = courseName;
        this.courseCode = courseCode;
        
        module1 = new Module("Computing", "50302");
    }
}

