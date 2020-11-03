/**
 * This is the course class which adds the modules, grades and calculates the final mark
 * @Daniel Grace
 */
public class Course
{
    //Course names and numbers
    private String courseName;
    private String courseCode;
    private int completedModule;
    public int completionPoints;
    
    //Create new modules
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;
    
    //Final module mark / 100 to module percentage
    private double finalMark;
    private double finalGrade;
    
    //Enum for final grades  
    private Grades gradeLetter;
    private String studentGrade;
    
    
    /**
     * Sets the course name and code. Creates new modules.
    */
    public Course(String courseName, String courseCode)
    {
        this.courseName = courseName;
        this.courseCode = courseCode;
        
        module1 = new Module("Web Design", "1");
        module2 = new Module("Programming Concepts", "2");
        module3 = new Module("User Experience", "3");
        module4 = new Module("Video Editing" , "4");
    }
    
    
     /**
     * Add marks to the modules above, if it doesn't exist
     * an error message is displayed.
     */
     public void addMark(int mark, int moduleCode)
    {
        if(moduleCode == 1)
        {
            module1.awardMark(mark);
            this.completedModule = completedModule + 1;
            this.completionPoints = completionPoints + 15;
        }
        else if(moduleCode == 2)
        {
            module2.awardMark(mark);
            this.completedModule = completedModule + 1;
            this.completionPoints = completionPoints + 15;
        }
        else if(moduleCode == 3)
        {
            module3.awardMark(mark);
            this.completedModule = completedModule + 1;
            this.completionPoints = completionPoints + 15;
        }
        else if(moduleCode == 4)
        {
            module4.awardMark(mark);
            this.completedModule = completedModule + 1;
            this.completionPoints = completionPoints + 15;
        }
        else
        {
            System.out.println("Please input a valid module code!!");
        }
    }
    
    /**
     * Marks from each module are added, then turned into a
     * percentage and then displayed back to the user.
     */  
    public void calcuateFinalMark()
    {
        if(completedModule == 4)
        {
        finalMark = completionPoints + module1.mark + module2.mark + module3.mark + module4.mark;
        finalGrade = Math.round((finalMark / 400) * 100);
        System.out.println("Your marks  "  + courseName + ", " + courseCode + " are: " + finalMark);
        System.out.println("Your course percentage is: " + finalGrade + "%");
        } 
        else
        {
            System.out.println("Please complete your modules first!");
        }
    }
    
     /**
     * Depending on the final grade the student will be placed
     * into the appropriate grade group.
     */
    public Grades convertToGrade()
    {
        if((finalGrade >= 0) && (finalGrade < 40))
        {
            studentGrade = ("F");
            return Grades.F;
        }
        else if((finalGrade >= 40) && (finalGrade <= 49))
        {
            studentGrade = ("D");
            return Grades.D;
        }
        else if((finalGrade >= 50) && (finalGrade <= 59))
        {
            studentGrade = ("C");
            return Grades.C;
        }
        else if((finalGrade >= 60) && (finalGrade <= 69))
        {
            studentGrade = ("B");
            return Grades.B;
        }
        else if ((finalGrade>= 70))
        {
            studentGrade = ("A");
            return Grades.A;
        }
        else
        {
            studentGrade = ("X");
            return Grades.X;
        }
    }
    
    
    /**
     * Prints out the title of the course and the code
     * for the course.
     */
    public void printCourseDetails()
    {
        System.out.println("You are on the course: " + courseName + ", " + courseCode);
    }
    
    /**
     * Prints out the title of the module and the code
     * for the module.
     */
    public void printModuleDetails()
    {
        System.out.println("Module list:      \n ");
        module1.printDetails();
        
        System.out.println("       ");
        module2.printDetails();
        
        System.out.println("       ");
        module3.printDetails();
        
        System.out.println("       ");
        module4.printDetails();
    }
    
    public void printFinalGrade()
    {
        if (completedModule >= 4)
        {
          System.out.println("Your final grade for " + courseName + (", ") + courseCode + (" is: ") + studentGrade);
        }
        else
        {
            System.out.println("You need to complete all modules!");
        }
    }
}

