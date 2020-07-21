/* Takes in user input of classes and grades to calculate and
 * be able to return gpa
 */

 
package GPAPROJECT;
import java.util.*;
public class NormalClass 
{
    private static Map<String, Double> gpaValues;
    private String tier;
    private double multiple;
    private String course;
    static
    {
        //creates map of gpa values with respective letter grades
        gpaValues = new HashMap<String, Double>();
        gpaValues.put("A+", 5.0);
        gpaValues.put("A", 4.8);
        gpaValues.put("A-", 4.6);
        gpaValues.put("B+", 4.4);
        gpaValues.put("B", 4.2);
        gpaValues.put("B-", 4.0);
        gpaValues.put("C+", 3.8);
        gpaValues.put("C", 3.6);
        gpaValues.put("C-", 3.4);
        gpaValues.put("C--", 3.0);
        gpaValues.put("F", 0.0);
    }
    
    /** Default constructor initializing everything to top most grade and class
     */
    public NormalClass()
    {
        tier = "A+";
        course = "AP";
        multiple = changeMultiple(course);
    }

    /** Overloaded constructor with ability to choose tier and course level
     *  @param tier letter grade if course
     *  @param course level of course
     */
    public NormalClass(String tier, String course)
    {
        this.tier = tier;
        this.course = course;
        multiple = changeMultiple(this.course);
    }

    /** Getter for multiple instance variable
     *  @return multiple variable that helps determine what gpa should be awarded for course level
     */
    public double getMultiple()
    {
        return multiple;
    }
    
    /** Setter for letter grade in course
     *  @param tier the letter grade of course
     */
    public void changeTier(String tier)
    {
        this.tier = tier;
    }

    /** Setter for multiple instance variable
     *  @param numb input to chance multiple variable to
     */
    public void changeMultiple(double numb)
    {
        multiple = numb;
    }

    /** Changes multiple based based of course level
     *  @param whichClass level of course
     *  @return multiple to use when determining gpa
     */
    private double changeMultiple(String whichClass)
    {
        if(whichClass.equals("AP") || whichClass.equals("IB"))
        {
            return 0;
        }
        if(whichClass.equals("Honors"))
        {
            return 1;
        }
        if(whichClass.equals("Regular"))
        {
            return 2;
        }
        if(whichClass.equals("Basic"))
        {
            return 3;
        }
        if(whichClass.equals("Developmental"))
        {
            if(tier.equals("C-"))
            {
                return 4.8;
            }
            else if(tier.equals("C--"))
            {
                return 4;
            }
        }
        return 5;
    }

    /** Returns GPA value
     *  @return gpa value
     */
    public double getGpa()
    {
        if(gpaValues.get(tier) == 0)
        {
            return 0;
        }
        return gpaValues.get(tier) - (0.5 * multiple); //subtracts from a base gpa from a 
                                                       //specified course level. Multiple 
                                                       //variable determined by letter grade in class
    }
    

    
}