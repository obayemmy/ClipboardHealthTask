package com.kuda.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static Object fetchProperty(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/config.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key);
    }

    public static String fetchLocator(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/Locators.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }

    ////	public static void captureScreenshot(WebDriver driver,String screenshotName){
    ////
    ////		try
    ////		{
    ////			TakesScreenshot ts=(TakesScreenshot)driver;
    ////
    ////			File source=ts.getScreenshotAs(OutputType.FILE);
    ////
    ////			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
    ////
    ////			System.out.println("Screenshot taken");
    ////		}
    ////		catch (Exception e)
    ////		{
    ////
    ////			System.out.println("Exception while taking screenshot "+e.getMessage());
    ////		}
    //	}

}
