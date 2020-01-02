package com.varian.extentListeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import uiUtils.BaseTestWebDriverManager;



public class ExtentManager {

	private static ExtentReports extent;




	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Rahul Arora");
		extent.setSystemInfo("Organization", "Way2Automation");
		extent.setSystemInfo("Build no", "W2A-1234");


		return extent;
	}


	public static String screenshotPath;
	public static String screenshotName;


	public static void captureScreenshot() {
		BaseTestWebDriverManager basicTestWebMgr=new BaseTestWebDriverManager();

		File scrFile = ((TakesScreenshot)basicTestWebMgr.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date(); 
		screenshotName = d.toString().replace(":",	  "_").replace(" ", "_") + ".jpg";

		try { FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +
				"\\reports\\" + screenshotName)); 
		basicTestWebMgr.logInfo("Failed screenshot is found at: "+System.getProperty("user.dir") +
				"\\reports\\" + screenshotName);
		} catch (IOException e) { 
					// TODOAuto-generated catch block e.printStackTrace(); }
					basicTestWebMgr.logInfo("Failed to take screenshot");

				}


	}
}