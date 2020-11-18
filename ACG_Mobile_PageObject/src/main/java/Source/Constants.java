package Source;

public class Constants {
	
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable cannot be changed
    // 'String' & 'int' are the data type for storing a type of value	
	
	
	//public static final String Path_OR = "C:\\Appium\\AAA\\Automation\\ACG_Test_Automation_Framework\\src\\configuration\\OR.txt";
	public static final String Path_OR =System.getProperty("user.dir")+ "\\src\\configuration\\OR.txt";
	
	public static final String FileTestData = "Keyword.xlsx";
	
	public static int TotalTestCase;
	public static boolean TestCaseStatus;
	
	
	 public static String getCurrentDirectoryPath() {
		 
	        String currentDirectory = System.getProperty("user.dir");
	        
	        return currentDirectory;
	  }
	 
	 public static String getXMLDirectoryPath(String _filename) {
		 
		 String curdir = getCurrentDirectoryPath();
		 
		 return curdir = curdir+"\\src\\testDataEngine\\"+_filename;
		 
	 }

}
