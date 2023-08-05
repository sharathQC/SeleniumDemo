package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.w3c.dom.Document;

import java.util.List;

public class ScrollingInTable {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        System.out.println("===Scrolling Web Table====");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']//tbody//tr//td[4]"));
        int sum=0;
        for(int i=0;i<values.size();i++){
            sum = sum+Integer.parseInt(values.get(i).getText());
            System.out.println("values: "+values.get(i).getText());
        }
        System.out.println("sum of Amount Column values: "+sum);


        String totalAmount = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
        String totalAmountArray[] = totalAmount.split(":");
        int total_amount = Integer.parseInt(totalAmountArray[1].trim());

        Assert.assertEquals(sum,total_amount,"total amount is not matching");

    }
}
