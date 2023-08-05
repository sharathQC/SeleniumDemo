package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Locators {

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Forgot your password')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        Thread.sleep(2000);
        String msg = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        String msg_array[] = msg.split("'");
        String new_pwd = " ";

        for(int i=0;i< msg_array.length;i++){
            if(msg_array[i].equalsIgnoreCase("rahulshettyacademy")){
                new_pwd = msg_array[i];
            }
        }


        return new_pwd;
    }


    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);


        //Login - Test Case -1
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("sharath.ganji@gmail.com");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();

        //verifying the page title after login and Log out of the site
        Assert.assertEquals(driver.getTitle(),"Rahul Shetty Academy - Login page","page Title is not matching");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='logout-btn']")).click();

        String updated_pwd = getPassword(driver);



        WebDriverWait wait_login = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait_login.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='go-to-login-btn']")))).click();


        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("sharath.ganji@gmail.com");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(updated_pwd);
        WebElement signin_button = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));

        System.out.println("signin button is displayed: "+signin_button.isDisplayed());
        System.out.println("signin button enabled: "+signin_button.isEnabled());

        //Thread.sleep(2000);







        System.out.println("page title: "+driver.getTitle());



//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0, 500)");

        //Thread.sleep(3000);
//        WebDriverWait wait_sign_in = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait_sign_in.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='submit signInBtn']")))).click();

//        WebDriverWait wait_sign_in = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait_sign_in.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='submit signInBtn']"))).click();

        //driver.findElement(By.className("signInBtn")).click();
        //driver.quit();



    }
}
