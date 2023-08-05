package com.packages;
/* printing the no of links on page using a tag name, and printing the footer section links using limiting webdriver scope

 */
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ScopeDemo {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===Scope Demo====");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //counting links on the page

        //parentWindow = driver.getWindowHandle();
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        //footer sections links and title
         List<WebElement> footer_links = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));

         System.out.println("footer links count: "+footer_links.size());

         for(WebElement link :footer_links){
             System.out.println(link.getText());
         }

         System.out.println("=======footer section links count======");

          WebElement footer_section = driver.findElement(By.id("gf-BIG"));
          System.out.println("footer section links count: "+footer_section.findElements(By.tagName("a")).size());

          //1st column links on footer section

        List<WebElement> footer_column_one = driver.findElements(By.xpath("//table[@class='gf-t']//tbody//tr//td[1]//ul//li//a"));
        System.out.println("footer_column_one :"+footer_column_one.size());

        //opening links in new tab
        for(int i=1;i<footer_column_one.size();i++){
            String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footer_column_one.get(i).sendKeys(openLinkInNewTab);
        }
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();

        while(itr.hasNext()){
            driver.switchTo().window(itr.next());
            System.out.println("Page title: "+driver.getTitle());
        }

        System.out.println("==2nd column in footer section===");
        List<WebElement> footer_column_two = driver.findElements(By.xpath("//table[@class='gf-t']//tbody//tr//td[2]//ul//li//a"));
        System.out.println("footer_column_two :"+footer_column_two.size());

        for(WebElement footerTwo:footer_column_two){
            System.out.println(footerTwo.getText());
        }




    }
}
