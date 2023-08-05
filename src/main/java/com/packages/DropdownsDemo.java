package com.packages;
/* explicit wait is used to avoid Elementinterceptable exception

 */

import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;

public class DropdownsDemo {
    public static void main(String args[]) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site dropdown practice===");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        System.out.println("===Static dropdown===");
        WebElement currency_dropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));

        Select s = new Select(currency_dropdown);
        System.out.println("first selected option in currency dropdown: " + s.getFirstSelectedOption().getText());
        s.selectByVisibleText("AED");
        //Thread.sleep(5000);
        s.selectByValue("INR");
        //Thread.sleep(5000);
        s.selectByIndex(3);

        System.out.println("===passengers dropdown====");
        WebElement passenger_dropdown = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
        WebElement adult_plus_btn = driver.findElement(By.id("hrefIncAdt"));
        WebElement adult_minus_btn = driver.findElement(By.id("hrefDecAdt"));

        WebElement child_plus_btn = driver.findElement(By.id("hrefIncChd"));
        WebElement child_minus_btn = driver.findElement(By.id("hrefDecChd"));

        WebElement done_btn = driver.findElement(By.id("btnclosepaxoption"));

        passenger_dropdown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(adult_plus_btn));


        System.out.println("before selecting the options in passenger dropdown: " + passenger_dropdown.getText());

        for (int i = 1; i <= 4; i++) {
            adult_plus_btn.click();
            child_plus_btn.click();
        }
        adult_minus_btn.click();


        done_btn.click();

        System.out.println("after selecting options on passenger dropdown: " + passenger_dropdown.getText());
        System.out.println("testing with assertion how many are selected are they as expected or not");

        Assert.assertEquals(passenger_dropdown.getText(), "4 Adult, 4 Child", "not matching the text");

        System.out.println("===dynamic dropdown====");

        //From dropdown -HYD
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='HYD']")).click();

        Thread.sleep(2000);
        //To dropdown -DEL
//        driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
//        System.out.println("===handling dynamic dropdown kind of challenge-> using paranthesis and index will get what we needed===");

        System.out.println("===incase anyone rejects the code by identifying the ele with help of index, " +
                "use another way, select the parent tag of entire dropdown values, then add child element xpath, like below, " +
                "give 1 space between the parent and child xpath===");

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();

    }
}
