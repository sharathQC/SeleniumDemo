package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class UIAssignment {
    public static void main(String args[]){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===UI assignment====");
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Sharath");

        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='email']")).sendKeys("sharath123@gmail.com");

        driver.findElement(By.id("exampleInputPassword1")).sendKeys("sharath123");

        driver.findElement(By.id("exampleCheck1")).click();
        WebElement gender_dp = driver.findElement(By.id("exampleFormControlSelect1"));
        Select s = new Select(gender_dp);
        s.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.xpath("//input[@class='form-control' and @name = 'bday']")).sendKeys("01/02/2023");

        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

        System.out.println("Success msg: "+driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText());


    }
}
