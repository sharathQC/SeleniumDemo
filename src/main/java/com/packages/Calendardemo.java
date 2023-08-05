package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Calendardemo {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site dropdown - practice Calendars===");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        System.out.println("===Selected From & To Dropdown values, then selected current date in calendar cause, it has unique class name===");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[contains(@value,'BLR')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(@value,'DEL')]")).click();


        WebElement curr_date = driver.findElement(By.xpath("//a[contains(@class, 'ui-state-default ui-state-highlight')]"));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(curr_date));

        curr_date.click();

        /*verifying how to test whether return date calendar is disabled or not, sometimes isenabled() method is not working,
        that is why we used opacity attribute, this one is changed when that calendar is disabled and enabled
         */

        System.out.println("1: " + driver.findElement(By.id("Div1")).getAttribute("style"));


        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

        System.out.println("2:" + driver.findElement(By.id("Div1")).getAttribute("style"));

        Thread.sleep(3000);
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }


    }
}
