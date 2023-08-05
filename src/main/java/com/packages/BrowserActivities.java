package com.packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserActivities {

    public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site - navigation commands practice===");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        System.out.println("1 -Page title: " + driver.getTitle());

        driver.get("http://google.com"); //wait till all the components of the page is loaded
        System.out.println("2 Page title: " + driver.getTitle());


        driver.navigate().to("http://youtube.com/");//won't wait till all the elements present on the page
        System.out.println("3 Page title: " + driver.getTitle());


        driver.navigate().to("https://www.facebook.com/login/");
        System.out.println("4 Page title: " + driver.getTitle());

        driver.navigate().back();
        System.out.println("going back: Page title: " + driver.getTitle());


        driver.navigate().forward();
        System.out.println("going forward: Page title: " + driver.getTitle());


        driver.navigate().refresh();
        System.out.println("refreshing the page: Page title: " + driver.getTitle());
    }
}
