package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertDemo {
    public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site dropdown - practice Calendars===");
        //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        System.out.println("====ALERTS=====");
        driver.findElement(By.id("name")).sendKeys("hello world, sample program");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println("1st Alert: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys("ECIL");
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println("Confirm Alert: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


    }
}
