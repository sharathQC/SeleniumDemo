package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UIAssignmentTwo {
    public static void main(String args[]){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement chkBox2 = driver.findElement(By.id("checkBoxOption2"));
        chkBox2.click();
        String checkBoxTwoText = chkBox2.getAttribute("value");

        System.out.println("check box2 is selected?: "+chkBox2.isSelected());

        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByValue(checkBoxTwoText);
        //s.selectByVisibleText(checkBoxTwoText);

        driver.findElement(By.id("name")).sendKeys(checkBoxTwoText);
        driver.findElement(By.id("alertbtn")).click();



        String alert_text = driver.switchTo().alert().getText();

        if(alert_text.contains(checkBoxTwoText))
            System.out.println("checkbox2 text is matching with the alert");
        else
            System.out.println("checkbox2 text is not matching with the alert");

        driver.switchTo().alert().accept();






    }
}
