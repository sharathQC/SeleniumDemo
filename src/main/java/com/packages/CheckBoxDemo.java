package com.packages;
/*checkboxes

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class CheckBoxDemo {
    public static void main(String args[]) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("===rahul shetty academy site dropdown - practice checkboxes===");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();


        WebElement ind_army_chkbox = driver.findElement(By.xpath("//input[contains(@id,'IndArm')]"));

        System.out.println("==checking if ind_army_check box is selected using assertion===");
        Assert.assertFalse(ind_army_chkbox.isSelected());

        System.out.println("ind army checkbox selected? : " + ind_army_chkbox.isSelected());
        ind_army_chkbox.click();

        System.out.println("==checking if ind_army_check box is selected using assertion===");
        Assert.assertTrue(ind_army_chkbox.isSelected());

        System.out.println("ind army checkbox selected? : " + ind_army_chkbox.isSelected());
        driver.findElement(By.xpath("//input[contains(@name,'friendsandfamily')]")).click();

        System.out.println("======================");
        //List<WebElement> chk_boxes = driver.findElements(By.xpath("//input[contains(@id,'ctl00_mainContent_chk_') and @type= 'checkbox']"));
        List<WebElement> chk_boxes = driver.findElements(By.xpath("//input[contains(@id,'ctl00_mainContent_chk_') and @type= 'checkbox']/following-sibling::label"));
        System.out.println("no of check boxes: " + chk_boxes.size());

        for (WebElement check : chk_boxes) {
            System.out.println("check boxes are: " + check.getText());
        }
        System.out.println("===Using assertion checking no of checkboxes====");
        Assert.assertEquals(chk_boxes.size(), 6, "no of checkboxes are not matching");


    }
}
