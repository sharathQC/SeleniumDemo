package com.packages;
/*auto suggestive dropdown, enter one word, dropdown will give you the dynamic search results, find out the one which u needed, click on it

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoSuggestionsDemo {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site dropdown - practice auto suggestions===");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("autosuggest")).sendKeys("US");
        Thread.sleep(3000);
        List<WebElement> coutry_dp_options = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
        System.out.println("list size: "+coutry_dp_options.size());

        for(WebElement option:coutry_dp_options){
            System.out.println(option.getText());
            if((option.getText()).equalsIgnoreCase("Mauritius")){
                option.click();
                break;
            }
        }



    }
}
