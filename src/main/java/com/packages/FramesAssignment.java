package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class FramesAssignment {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===Frames Assignment====");
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();

        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        System.out.println("frame size: "+frames.size());

        //top frame
        driver.switchTo().frame("frame-top");

        //middle frame
        driver.switchTo().frame("frame-middle");
        System.out.println("middle frame text:"+driver.findElement(By.id("content")).getText());


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println("bottom frame text: "+driver.findElement(By.xpath("//body")).getText());


    }
}
