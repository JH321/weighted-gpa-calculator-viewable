/* Class to run, allows user input of their grades   
 * builds a file of gpas in order to save them and 
 * calculate overall gpa
 */

package GPAPROJECT;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to update file(update) or calculate gpa");
        String str = scan.next();
        //when creating new file for gpa or adding onto a file
        if(str.equals("update"))
        {
            System.out.println("Name the file you want to create/edit with .txt");
            String fileName = scan.next();
            //"D:" + File.separator + "Vscode" + File.separator + 
            //"JAVAPROJECTS" + File.separator + "gpatexts" + File.separator + fileName
            File gpaFiles = new File(fileName);
            if(!gpaFiles.exists())
            {
                gpaFiles.createNewFile();
            }
            boolean stop = false;
            while(!stop)
            {
                System.out.println("How many classes?");
                int periods = scan.nextInt();
                double[] gpaList = new double[periods];
                System.out.println("What year?");
                String year = scan.next();
                for(int count = 0; count < periods; count++)
                {
                    System.out.println("What is your course (AP/IB, Honors, Regular, Basic, Developmental)");
                    String course = scan.next();
                    System.out.println("What grade?");
                    int grade = scan.nextInt();
                    NormalClass aClass = new NormalClass(getTier(grade), course);
                    gpaList[count] = aClass.getGpa();
                    System.out.println(getTier(grade) + aClass.getGpa());
                }
                Gpa yearGpa = new Gpa(gpaList, periods);
                double gpa = yearGpa.getAverage();
                FileWriter updateFile = new FileWriter(gpaFiles, true);
                updateFile.write(gpa + " from " + year + "\n");
                updateFile.close();
                System.out.println("Do you want to add more GPAs? (y/n)");
                if(scan.next().equals("n"))
                {
                    stop = true;
                }
            }
            scan.close();
        }
        //when calculating overall gpa from a file of yearly gpas
        else
        {
            Scanner testScan = new Scanner(System.in);
            System.out.println("Enter file name to calculate.");
            String fileName = testScan.next();
            //"D:" + File.separator + "Vscode" + File.separator + 
            //"JAVAPROJECTS" + File.separator + "gpatexts" + File.separator + fileName
            File calcFile = new File(fileName);
            try
            {
                Scanner fileScanner = new Scanner(calcFile);
                double gpaVal = 0;
                int counter = 0;
                while(fileScanner.hasNextLine())
                {
                    double tempGpa = fileScanner.nextDouble();
                    gpaVal += tempGpa;
                    counter++;
                    fileScanner.nextLine();
                }
                System.out.println(gpaVal / counter);
                fileScanner.close();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("you entered in a file that doesn't exist");
            }
            testScan.close();
        }
    }
    /** Gets letter grade based of numerical grade
     *  @param grade numerical grade of course
     *  @return letter grade of course
     */
    public static String getTier(int grade)
    {
        if(grade >= 97)
        {
            return "A+";
        }
        else if(grade >= 93)
        {
            return "A";
        }
        else if(grade >= 90)
        {
            return "A-";
        }
        else if(grade >= 87)
        {
            return "B+";
        }
        else if(grade >= 83)
        {
            return "B";
        }
        else if(grade >= 80)
        {
            return "B-";
        }
        else if(grade >= 77)
        {
            return "C+";
        }
        else if(grade >= 73)
        {
            return "C";
        }
        else if(grade >= 71)
        {
            return "C-";
        }
        else if(grade == 70)
        {
            return "C--";
        }
        return "F";
    }

}
