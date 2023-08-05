package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalendarUI {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.path2usa.com/travel-companion/");
        System.out.println("===calendar UI====");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)","");

        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("form-field-travel_comp_date")));

        Thread.sleep(2000);



        WebElement cal = driver.findElement(By.id("form-field-travel_comp_date"));
        cal.click();
        cal.sendKeys("20-April-2023");




//        String month = driver.findElement(By.xpath("//div[@class='flatpickr-month']//div//span[text()='December ']")).getText();
//
//        while(!month.contains("December ")){
//            System.out.println("1");
//            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
//        }
//
//        System.out.println("2");
//




//        List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
//        System.out.println(dates.size());
//
//        for(WebElement date:dates){
//            if(date.getText().equalsIgnoreCase("20")){
//                date.click();
//                break;
//            }
//            //System.out.println(date.getText());
//        }


    }
}
