package Report;

import java.io.File;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestManager {

    private static String reportFileName ;
    //private static String reportFileName = "Test-Automaton-Report.html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation ;
    //private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
    
    
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest logger;
	
	 public static ExtentReports getInstance(String fileName) {
	        if (extent == null)
	        	reportFileName = fileName + ".html";
	        	reportFileLocation = reportFilepath +fileSeperator+ reportFileName;
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {

	        String fileName = getReportPath(reportFilepath);
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	 
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //Set environment details
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("AUT", "QA");
	 
	        return extent;
	    }
	    
	    //Create the report path
	    private static String getReportPath (String path) {
	    	File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	        	if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	                return reportFileLocation;
	            } else {
	                System.out.println("Failed to create directory: " + path);
	                return System.getProperty("user.dir");
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
			return reportFileLocation;
	    }
	    
	    
		public static void endReport(){
			// writing everything to document
			//flush() - to write or update test information to your report. 
			               extent.flush();
			               //Call close() at the very end of your session to clear all resources. 
			               //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
			               //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
			               //Once this method is called, calling any Extent method will throw an error.
			               //close() - To close all the operation
			               //extent.close();
			               
			   }
		
	
	
	public static void logTest (String message, Status status){
		
		logger = extent.createTest(message);
		if (status ==Status.PASS){
			logger.log(Status.PASS, MarkupHelper.createLabel("Passed : " + message, ExtentColor.GREEN));
		}else if (status == Status.WARNING){
			
			logger.log(Status.WARNING, MarkupHelper.createLabel("Warning : " + message, ExtentColor.YELLOW));
		}else if (status == Status.SKIP){
			
			logger.log(Status.SKIP, MarkupHelper.createLabel("Skipped : " + message, ExtentColor.GREY));
		}else if (status == Status.ERROR){
			
			logger.log(Status.ERROR, MarkupHelper.createLabel("Error : " + message, ExtentColor.RED));
		}else if (status == Status.FATAL){
			
			logger.log(Status.FATAL, MarkupHelper.createLabel("Fatal : " + message, ExtentColor.RED));
		}else if (status == Status.FAIL){
			
			logger.log(Status.FAIL, MarkupHelper.createLabel("Fail : " + message, ExtentColor.RED));
		}else {
			
			logger.log(Status.DEBUG, MarkupHelper.createLabel("Debug : " + message, ExtentColor.INDIGO));
			
		}
		
	}
	
	public static void createSection (String section){
		extent.createTest(section);
		
	}
		
	
}
