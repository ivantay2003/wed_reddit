## Reddit web automation in cucumber bdd and generate a report
<br><br><br>


The youtube is in :
<br>
https://youtu.be/xZhHoQo3r8U

<br><br><br>
BDD format
<br>
	@Scenario1
	Scenario: Log into my account , go to my subreddit and leave a comment
		
		Given I want to launch reddit
		
			And I log into my account
			
		When I go to my subreddits
			
			And I check that the thread "Online secure document collaboration" 
			
			And I add comment on the post "TESTING" with my name "Peter Doe"
			
			And I click down vote in latest comment
			
			And I click up vote in latest comment
		
		Then I check page title is "TESTING"
		
			And I want print the report

<br><br>

A. __Preinstallation__
- Install Eclipse,  maven , java 1.8
- The rest of the installation can be run through maven

<br><br>
Configurate your projects to run
<br>
1.Import the project as maven project in Eclipse. Run it.  You may fail in building so you need to make sure you build the configuration correctly. Refer to your IDE documentations.

<br><br><br><br>
B. __Setting your credentials__

/src/test/java/Credential.java

public static final String user = "username"

public static final String password = "password""

<br>
src/test/java/Control
Set your gecko driver path

<br><br><br><br>
C. __Execute the test__

Go to command line / terminal at project folder. You will need to install the libraries first and then run the test. The profile is "bdd". If you run without the -P parameter, it will run the non bdd (the outcome will be the similar)

1. mvn install
2. mvn test -Pbdd

<br><br>
D. __Report__ 
1. Generated Test report after running the test is located in /TestReport/TestReport.html. Below is a screenshot

![alt text](https://github.com/ivantay2003/wed_reddit/blob/master/report.png)

<br><br>


<br><br>
<br><br><br>
Please contact me at 
<br>
*https://www.linkedin.com/in/ivantay/*


