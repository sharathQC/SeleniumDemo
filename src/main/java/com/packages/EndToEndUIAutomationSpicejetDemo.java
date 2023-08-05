package com.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EndToEndUIAutomationSpicejetDemo {
    public static void main(String args[]) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site dropdown - practice Calendars===");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();


        System.out.println("===From search dropdown====");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='PNQ']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight')]")).click();

        System.out.println("before: " + driver.findElement(By.id("Div1")).getAttribute("style"));

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        System.out.println("after: " + driver.findElement(By.id("Div1")).getAttribute("style"));


        System.out.println("=======passengers dropdown============");

        //passengers dropdown
        WebElement passgener_dp = driver.findElement(By.id("divpaxinfo"));
        passgener_dp.click();
        WebElement child_plus_btn = driver.findElement(By.id("hrefIncChd"));
        WebElement child_minus_btn = driver.findElement(By.id("hrefDecChd"));
        WebElement infant_plus_btn = driver.findElement(By.id("hrefIncInf"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("divpaxOptions"))));

        System.out.println("before for loop ");
        Thread.sleep(2000);
        for (int i = 1; i <= 3; i++) {
            System.out.println("in for loop ");
            child_plus_btn.click();
            infant_plus_btn.click();
        }
        child_minus_btn.click();

        System.out.println("out of ");

        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println("==== passenger dp: " + passgener_dp.getText() + "===");


        //static dropdown
        System.out.println("====static dropdown====");

        WebElement static_dp = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select s = new Select(static_dp);
        s.selectByVisibleText("USD");
        Thread.sleep(3000);
        s.selectByValue("AED");

        driver.findElement(By.id("autosuggest")).sendKeys("US");
        Thread.sleep(2000);
        List<WebElement> search_options = driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
        System.out.println(search_options.size());

        for (WebElement op : search_options) {
            System.out.println(op.getText());
        }


    }
}
