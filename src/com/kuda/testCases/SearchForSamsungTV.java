package com.kuda.testCases;


import java.util.ArrayList;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kuda.assertions.Assertions;
import com.kuda.base.TestBase;


public class SearchForSamsungTV extends TestBase{

	@Test(description = "Designated to complete the Clipboard health task")
	public void googleSign() throws Exception {
		//Click on the hamburger icon
		click("hamburgerIcon_XPATH");
		System.out.println("Hamburger clicked successfully");
		//Click on TV Appliances
		click("TV-Appliance_XPATH");
		System.out.println("TV appliances button  clicked successfully");
		sleep(2);
		//Click on TV link
		click("TVLink_LINKTEXT");
		System.out.println("TV clicked successfully");
		//Scroll to where Samsung is 
		sleep(3);
		JavascriptExecutor scollDown = (JavascriptExecutor) driver;
		WebElement element =  chooseElement("brandSamsung_XPATH");
		scollDown.executeScript("arguments[0].scrollIntoView();", element);
		//Click brand samsung
		click("brandSamsung_XPATH");
		//sleep(8);
		System.out.println("scrolling  was  successfull and samsung selected");
		//Select price  high to low from the dropdown
		selectDropdowntByVisibleText("Price: High to Low", "sortByBtn_XPATH");
		System.out.println("Price sorting done");
		sleep(4);
		//perform click operation that launches a new window
		click("secondHighestPricedItem_XPATH");
		System.out.println("seoncd highest  done");
		sleep(2);
		//Switching to thew tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		//Scroll to wherre About this item is
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		//Capture and Print the about this product description
		WebElement about =  chooseElement("aboutDisItem_XPATH");
		scroll.executeScript("arguments[0].scrollIntoView();", about);
		String text  = about.getText();
		System.out.println(text);

		Boolean isPresent =  chooseElement("aboutDisItem_XPATH").isDisplayed();
		if(isPresent = true) {
			System.out.println("About product is present");
		}else if (isPresent = false){
			System.out.println("About product no show");
		}else {
			System.out.println("Test didn't get to About this item ");
		}

		String expectedAvoutItemText = "About this item";
		String  actualAboutItemText= getText("aboutItem_XPATH");
		//Asserting that About t		
		Assertions.TextAssertion(actualAboutItemText, expectedAvoutItemText);


		System.out.println(expectedAvoutItemText);

		sleep(5);
	}
}







































































































































































