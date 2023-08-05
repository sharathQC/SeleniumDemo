package com.packages;
/* siblings xpath traverse, from parent to child and child to parent

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathLocators {
    public static void main(String args[]) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site===");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        System.out.println("===traversing parent to child====");
        WebElement login_button = driver.findElement(By.xpath("//header//div//button[1]//following-sibling::button[1]"));
        login_button.click();
        System.out.println(login_button.getText());
        System.out.println("===traversing child to parent====");
        WebElement signup_btn = driver.findElement(By.xpath("//div/button[2]/parent::div/parent::header/div/button[1]/following-sibling::button[2]"));
        System.out.println(signup_btn.getText());
    }


}
