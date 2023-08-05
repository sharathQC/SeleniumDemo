package com.packages;
//broken links, soft assertion
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String args[]) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("===BROKEN LINKS===");
        SoftAssert sa = new SoftAssert();

        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']//a"));

        for(WebElement link : links){
            String URL = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(URL).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println("response code: "+responseCode+" res msg: "+conn.getResponseMessage());

            sa.assertTrue(responseCode<=400,"Broken URL: "+URL+" with status code: "+responseCode);
        }
        sa.assertAll();






    }
}
