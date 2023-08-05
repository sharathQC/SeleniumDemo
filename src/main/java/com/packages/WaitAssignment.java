package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitAssignment {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        System.out.println("===Wait assignment====");
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@id='usertype' and @value='user']")).click();


        System.out.println("1");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        System.out.println("2");

        driver.findElement(By.id("okayBtn")).click();

        WebElement user_dp = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select s = new Select(user_dp);

        s.selectByVisibleText("Student");


        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info']")));


        List<WebElement> items = driver.findElements(By.xpath("//*[@class='col-lg-3 col-md-6 mb-3']"));
        System.out.println(items.size());

        for (int i = 0; i < items.size(); i++) {
            driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

    }
}
