package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===Mouse Actions Amazon.com===");
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);


        //move to sign in button
        WebElement signIn = driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
        //right click on signin button using contect click method
        a.moveToElement(signIn).contextClick().build().perform();
        driver.findElement(By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']")).click();

        WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
        //enter some text on search box and select the entered text using double click method
        a.moveToElement(search_box).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(search_box).click().sendKeys(Keys.ENTER).build().perform();

//        search_box.sendKeys("RRR");
//        search_box.sendKeys(Keys.ENTER);

    }
}
