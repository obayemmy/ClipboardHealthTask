package com.kuda.utility;

import com.kuda.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Log {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

            System.out.println("Screenshot taken");
        } catch (Exception e) {

            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}
