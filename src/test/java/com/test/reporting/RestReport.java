package com.test.reporting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class RestReport {
	
	@BeforeTest
	public void onStart() {
		
	}
	
	@Test(priority=1,description="First Test")
	public void ModellingProcess() {
		
		System.out.println("Test Case ETL Running");
		
		
	}
	
	@Test(priority=0,description="Second Test")
	public void TrainingProcess() throws Exception {
		
		System.out.println("Test Case Scanning Running");
		
		throw new Exception();
		
		
	}

}
