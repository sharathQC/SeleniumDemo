package com.packages;
//get the text from child window or tab and pasted into parent window
//taking only webelement screenshot
//get height and width of editbox
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class InvokeMultipleWindows {
    public static void main(String args[]) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        String parentWindow = driver.getWindowHandle();
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://rahulshettyacademy.com/");
        String childWindowOne = driver.getWindowHandle();
        js.executeScript("window.scrollBy(0,2000)","");

        List<WebElement> courses = driver.findElements(By.xpath("//h2//a[contains(@href,'https://courses.rahulshettyacademy.com/p/')]"));

        String first_course_title = courses.get(0).getText();
        System.out.println(courses.size()+" : "+courses.get(0).getText());

        driver.switchTo().window(parentWindow);
        name.sendKeys(first_course_title);

        //taking screenshot of whole page
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(f, new File("C:\\Users\\GSHARATH\\Documents\\Automation_Screenshots\\3.png"));

        //taking only webelement screenshot
        File f1 = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f1, new File("C:\\Users\\GSHARATH\\Documents\\Automation_Screenshots\\webelement_1.png"));

        //get height and width of the edit box
       int height =  name.getRect().getDimension().getHeight();
       int width = name.getRect().getDimension().getWidth();
       System.out.println("height: "+height+" width: "+width);

    }
}
