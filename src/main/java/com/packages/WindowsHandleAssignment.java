package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandleAssignment {
    public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===window handle assignment====");
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();


        driver.findElement(By.linkText("Click Here")).click();

        Set<String> handles = driver.getWindowHandles();
        Iterator itr = handles.iterator();

        String parentWindow = itr.next().toString();
        String childWindow = itr.next().toString();

        driver.switchTo().window(childWindow);
        System.out.println("child window text: " + driver.findElement(By.xpath("//div[@class='example']")).getText());

        driver.switchTo().window(parentWindow);
        System.out.println("parent window text: " + driver.findElement(By.xpath("//div[@class='example']//h3 ")).getText());


    }
}
