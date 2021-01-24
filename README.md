# csv-reader
csv-reader will take in a string parameter that is a path to a csv file of insurance enrollees, sort the enrollees by last name, first name, and write them to individual files for each insurance company.

## Assumptions
The assumption is that the file being parsed is in the following csv format:</br>
User_id,Name,Version,Insurance_Company


## Installation and Execution
Clone the repo at https://github.com/lbc2k1385/csv-reader.git

<strong>From the command line:</strong> <br/>
Navigate to the project home directory in your local repo and run mvn clean install. This should generate the following jar file in the target folder:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;csv-reader-0.0.1-SNAPSHOT-jar-with-dependencies.jar <br/>

To run this program use the following example command:<br/>
java -jar target/csv-reader-0.0.1-SNAPSHOT-jar-with-dependencies.jar availity/csv-reader/Availity_Mock_Data.csv

<strong>From Eclipse:</strong> <br/>
Open Eclipse, navigate to File->Import->Existing Maven Projects<br/>
In the root directory drop down, navigate to the project directory in your local repo, select the POM file, and click Finish.<br/>
Right click on the project in the Project Explorer View click on Run As-> Maven Install<br/>
To Run, navigate to Run->Run Configuration->Arguments->Program Arguments, add an argument that represents the file path, and click Run.

