package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebTableAssignment {
    public static void main(String args[]){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("===WebTable Assignment====");

        List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr//th"));
        System.out.println("columns: "+columns.size());
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr//td[1]"));
        System.out.println("rows: "+rows.size());



        List<WebElement> second_row = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr[3]//td"));
        for(WebElement row:second_row){
            System.out.println(row.getText());
        }

    }
}
