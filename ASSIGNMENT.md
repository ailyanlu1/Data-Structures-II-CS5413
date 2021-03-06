
Due by March 25 by email to npark@cs.okstate.edu in a zipped file.

CS5413 Data Structures and Algorithm Analysis II 
Programming Assignment (Total 100 points)


This assignment is to exercise and validate the theoretical cost of the sorting
algorithms we covered in class, through practical implementation of them.


Sorting Algorithms and Performance.

Note: You may use any combination of any number of sorting algorithms 
of your own choice in order to solve the problem as fast as possible.


1. Input/Output:
Read in an input data file in a plain text format as an argument.

    Example:
    $pgm1 1000.txt
    or
    $java pgm1 1000.txt

The program should be written in C, C++ or Java (pgm1.c, pgm1.cpp or pgm1.java) and compile and runnable 
on CSX in its final version. 

Submit only a program source file and your own input data files 
(at least two such that one with size 100, another in 1000 records)
by " handin" command on CSA.


The format of your input and output data file is specified as follows:

    10
    Stocker Norris | 3631 W. 8th Ln. #264 | TRUCKEE | CA | 96161
    Saylor Alisya | 1854 W. Green Ln. #89 | LITTLE SUAMICO | WI | 54141
    Moore Lucy | 1471 E. Forest Rd. #139 | TALMAGE | KS | 67482
    Ryals Larson | 8385 E. Hillcrest St. | LEWISTON | MN | 55952
    Sherill Hardy | 7313 N. Franklin Blvd. | TAHLEQUAH | OK | 74464
    Justin Ray | 9251 N. Cherry Way #221 | MAMARONECK | NY | 10543
    Justin Ray | 4357 N. Broadway Way | LAKELAND | LA | 70752
    Earhart Alanis | 7515 N. Washington Way #72 | LOUISE | TX | 77455
    Draudy Joleen | 201 NE 23rd St. | HOUSTON | TX | 77061
    Bishop Holden | PO Box 409 | CARONA | KS | 66773


where 10 is the number of input records. Each line is a record. 
The name should be sorted in ascending order of last name and then first name.
The address should be sorted in ascending order of state, city, zip code, 
and street address.


The format of the output file is the same as the input file format
but in different order.


2. Program:
Your program is to perform sorting of the records in your input data file
by "name", and then save the sorted output data in a text file named 
"name_inputfilename.txt", e.g., name_1000.txt;
and then read back in the output file generated as a result of the sorting
by "name", as an input and then perform another round of sorting by "address" 
then save it as named "address_inputfilename.txt", e.g., address_1000.txt.


    1)sort by last name --> 2)sort by first name -->(save the result) --> 
    (read back again) --> 3)sort by state --> 4)sort by city --> 
    5)sort by zip code --> 6)sort by street address.

Or, you may perform an in-place sorting if that's your preference. 


When you write report, explain what is the sorting algorithm used in each stage 
(1)~(6), and why you chose that particular algorithm for justification.

** Please refer to the example files very carefully. 


3. Performance:
During sorting and generating an output data file, 
measure the performance by "adding each record in a line". 
In other words, re-sort every time you read in a new record of line.
Then plot a performance graph for each algorithm (i.e., name and address). 
In the performance graph, x-axis will be # of data (records of line), 
and y-axis will be the execution time. Note that you may use any plotting 
programs such as MS-Excel, gnuplot, Maple, Matlab or etc. 
The unit of the time should be as accurate as micro second.
Along with the performance graph,
generate and show an output data file named "name_inputfilename_time.txt" and
"address_inputfilename_time.txt".

The format will be as follows:

    1    10
    2    20
    3    40
    4    60
    5    100
    :
    :
    1000 30000

Submit a performance analysis report in pdf format,
in which describe the algorithm(s) you chose to use;
asymptotic analysis of the execution time versus actual execution time
for each different batch of simulation;
and observation and discussion over your results.


4. How to submit:

* Email a zipped file
* Source program file
* at least one input data file that you created and tested.
* Analysis report (pdf format)
  


5. Notice:
Your program must be of your own every line. 


**Late program penalty is 10% per calendar day, according to the latest date 
and time on the submitted files include report.


Your submitted files will be stored in a separate directory 
under your user name on CSA. 
Please do not worry about mixing with others works. You may submit 
same files as many as you want, however, the last file will overwrite the 
previous one. 