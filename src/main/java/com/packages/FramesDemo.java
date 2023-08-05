package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FramesDemo {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===Frames Demo====");
        driver.get("https://jqueryui.com/droppable/");

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("size: "+frames.size()+" "+frames.toString());

        //switch to frame using index
        driver.switchTo().frame(0);

        //switch to frame using webelement
//        WebElement frm1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
//        driver.switchTo().frame(frm1);

        WebElement  drag = driver.findElement(By.id("draggable"));
         WebElement drop = driver.findElement(By.id("droppable"));
        Actions a = new Actions(driver);
        a.dragAndDrop(drag,drop).build().perform();

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@href='/resources/demos/droppable/accepted-elements.html']")).click();

    }

}
