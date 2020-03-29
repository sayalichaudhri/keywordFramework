package com.hybrid.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import keywords.constants;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class ReportListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("Test case is passed");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		if(!result.isSuccess())
		{
			String date1=new SimpleDateFormat("dd-MM-YYYY_HH-ss").format(new Date().getTime());
			//String date1=dateformat.format(new Date().getTime());
			String year=date1.substring(6, 10);
			String month=date1.substring(3, 5);
			String day=date1.substring(0, 2);
			File imagefile=(File) ((TakesScreenshot)constants.driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName=result.getMethod().getMethodName() +" "+date1+ ".png";
			File failureImageFile=new File(System.getProperty("user.dir")+"\\screenshots\\"+year+"\\"+month+"\\"+day+"\\"+failureImageFileName);
			try {
				FileUtils.copyFile(imagefile,failureImageFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Test case is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish: test is finish");
		
	}
	
	

}
