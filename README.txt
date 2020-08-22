GPA Calculator developed for personal use.

The program creates a text file to store all your gpas in 
and what year to associate them with.

How to use:
    Aside from the package name, you can copy and paste the code
    into your own IDE.

    User is first prompted to choose between updating/creating 
    a new text file of gpas or calculating the average gpa from
    an existing text file with already existing gpa values.

    If user chooses to create/edit a file, they can input in an
    existing file name to update it or a new file name to create 
    a new text file to store gpas in. Then they are prompted to enter
    the number of classes and the year to associate those classes
    with. From there, they can specify the level of the class and the
    grade. Gpa is then calculated for that year based on the classes.

How it works:
    It calculates GPA based on the level of the class. A map
    containing the base gpas (the gpas awarded for AP classes) is used.
    The level of the class entered by the user is used to 
    determine a multiple, how many 0.5s to subtract from
    the base gpas. The lower the level of the class, the more 0.5s
    are subtracted from the gpa. This is how the gpa is determined
    for lower level classes. This is also in line with the actual
    gpa values awarded for the class based on the grade and level.

