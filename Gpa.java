/* Builds list of gpas from a course list to get the average gpa
 *
 */

 
package GPAPROJECT;

public class Gpa 
{
    private double[] gpaList;
    private int numbClasses;
    
    /** Constructor for gpa class
     *  @param list list of gpas
     *  @param numb number of courses
     */
    public Gpa(double[] list, int numb)
    {
        gpaList = list;
        numbClasses = numb;
    }

    /** Returns average gpa from course list
     *  @return average gpa from course list
     */
    public double getAverage()
    {
        double sum = 0;
        for(int index = 0; index < gpaList.length; index++)
        {
            sum += gpaList[index];
        }
        return sum / numbClasses;
    }

}