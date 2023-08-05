package com.packages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String args[]){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement email_editBox = driver.findElement(By.xpath("//input[@name='email']"));
        System.out.println(": "+driver.findElement(with(By.tagName("label")).above(email_editBox)).getText());

         WebElement chk = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
         driver.findElement(with(By.tagName("input")).toLeftOf(chk)).click();

         System.out.println(driver.findElement(with(By.tagName("label")).below(chk)).getText());

         WebElement student_radio = driver.findElement(By.id("inlineRadio1"));
         driver.findElement(with(By.tagName("input")).toRightOf(student_radio)).click();

    }
}
