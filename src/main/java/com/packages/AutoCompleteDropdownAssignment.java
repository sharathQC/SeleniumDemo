package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoCompleteDropdownAssignment {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
         WebElement autocomplete_dp = driver.findElement(By.id("autocomplete"));
         autocomplete_dp.click();
         autocomplete_dp.sendKeys("au");
         Thread.sleep(3000);
         List<WebElement> results = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
         System.out.println("size: "+results.size());

         for(WebElement result:results){
             if((result.getText()).equalsIgnoreCase("Mauritania")){
                 //System.out.println(result.getText());
                 result.click();
                 break;
             }
         }

    }
}
