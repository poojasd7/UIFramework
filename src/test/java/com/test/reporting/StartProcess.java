package com.test.reporting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reportingLogging.Log;


public class StartProcess {
	
	@BeforeSuite
	public void onStart() {
		
		
		
		
	}
	
	@Test(description="First Test")
	public void ETLProcess() {
		
		Log.info("LOG Info:Test Case ETL Running");
		
		
	}
	
	@Test(description="Second Test")
	public void ScanningProcess() throws Exception {
		
		Log.error("LOG Info:Test Case ETL failing");
		
		throw new Exception();
		
		
	}

}
