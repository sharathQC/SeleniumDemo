package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class CheckBoxAssignment {
    public static void main(String args[]){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===check box assignment====");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

         WebElement chkBox1 = driver.findElement(By.id("checkBoxOption1"));
         System.out.println("Verifying check box 1 before selecting : "+chkBox1.isSelected());

         chkBox1.click();
        System.out.println("Verifying check box 1 after selecting : "+chkBox1.isSelected());
        chkBox1.click();
        System.out.println("Verifying check box 1 after unselecting : "+chkBox1.isSelected());

        System.out.println("====verifying the no of check boxes present on the page===");
        List<WebElement> chkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("check boxes count: "+chkBoxes.size());


    }
}
