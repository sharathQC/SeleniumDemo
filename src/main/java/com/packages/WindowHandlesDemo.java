package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;

public class WindowHandlesDemo {
    public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        System.out.println("===Mouse Actions Amazon.com===");
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

         String parentWindow = driver.getWindowHandle().toString();
         System.out.println("parent window: "+parentWindow+" page title:"+driver.getTitle());

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        Set<String> handles= driver.getWindowHandles();
        int count = 1;

        for(String handle:handles){
            if(!parentWindow.equalsIgnoreCase(handle)){
                driver.switchTo().window(handle);
            }
            }

        System.out.println("window: "+driver.getWindowHandle()+" page title: "+driver.getTitle());
        String email_info = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        String email_text[] = email_info.split(" ");
        String email_id = " ";

        for(int i=0;i<email_text.length;i++){
            if(email_text[i].equals("mentor@rahulshettyacademy.com"))
                email_id = email_text[i];
            //System.out.println("string array: "+email_text[i]);
        }
        System.out.println("email id: "+email_id);
        driver.switchTo().window(parentWindow);
        System.out.println("parent page title: "+driver.getWindowHandle());
        driver.findElement(By.id("username")).sendKeys(email_id);






        }
    }
