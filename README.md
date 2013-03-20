##Build
This app is built via ant. To build, run `ant` in the same folder as the build.xml file. 

The build will create an intermediate build folder called `build` and will store an executable jar in the `dist` folder. 

##Run
This app has 2 mains in it, one for processing a records file and one to generate a random records file. 

####To Run generator

`java -cp path/to/pgm1...jar <number of records to generate>`

####To Run processor/sorter

`java -jar path/to/pgm1...jar <input file>`


##Output
When the processor/sorter is run, it will generate 4 files :

* name\_xxx.txt
* name\_xxx\_time.txt
* address\_xxx.txt
* address\_xxx\_time.txt

The {name|address}\_xxx.txt files will store the sorted output records.
The {name|address}\_xxx\_time.txt files will store the performance data related to the sorting performance.


