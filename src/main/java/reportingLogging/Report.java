package reportingLogging;
import org.testng.Reporter;

public class Report {
	
	public static void message(String desc) {
		Reporter.log(desc);
	}

}
