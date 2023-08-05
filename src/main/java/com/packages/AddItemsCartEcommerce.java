package com.packages;
//ctrl+Alt+L --- to format or beautify the code

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class AddItemsCartEcommerce {


    public void addItemsCart(WebDriver driver, String veggies[]) throws InterruptedException {
        String pag_title_1 = driver.getTitle();
        System.out.println("=======" + pag_title_1 + "========");

        List<WebElement> cart_items = driver.findElements(By.xpath("//div[@class='product']"));
        System.out.println("cart_items size: " + cart_items.size());

        List<String> veg_al = Arrays.asList(veggies);
        System.out.println("veg_al arraylist size: " + veg_al.size());

        for (String v : veg_al) {
            System.out.println("vvvvv: " + v);
        }

        int count = 0;
        for (int i = 1; i < cart_items.size(); i++) {


            String item[] = cart_items.get(i).getText().split("-");
            String formatted_item = item[0].trim();
            System.out.println("=======111111111========================");

            //since Mushroom from veggies array and Mushroom - 1 Kg 75 Add to cart are not same, item should always match with veg_al items,
            // since both are not same, we need to create substring of the item to match with veg_al.


            if (veg_al.contains(formatted_item)) {
                System.out.println("===: " + cart_items.get(i).getText());

                driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
                count++;
            }
            if (count == veggies.length) {
                break;
            }
        }
        driver.findElement(By.xpath("//a[@class='cart-icon']//img")).click();
        String pag_title_2 = driver.getTitle();
        System.out.println("=======" + pag_title_2 + "========");
        driver.findElement(By.xpath("//div[@class='action-block']//button[text()='PROCEED TO CHECKOUT']")).click();


        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        String pag_title_3 = driver.getTitle();
        System.out.println("=======" + pag_title_3 + "========");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='promoInfo']")));


        String promocodeSuccMsg = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        System.out.println(promocodeSuccMsg);
        Assert.assertEquals(promocodeSuccMsg, "Code applied ..!", "promocode is invalid");

        driver.findElement(By.xpath("//div[@class='products']//div//button[text()='Place Order']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//select")));


        WebElement select_country_dp = driver.findElement(By.xpath("//div//select"));
        Select s = new Select(select_country_dp);
        s.selectByVisibleText("Bhutan");
        String pag_title_4 = driver.getTitle();
        System.out.println("=======" + pag_title_4 + "========");


        driver.findElement(By.xpath("//input[@class='chkAgree']")).click();

        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        String pag_title_5 = driver.getTitle();
        System.out.println("=======" + pag_title_5 + "========");
        System.out.println("end of first method");


    }

    public void searchAndAddItems(WebDriver driver) throws InterruptedException {
                /* search with character c, in the search results, searching for Cauliflower printing on the console,
        and trying to add the item to cart, but not working
         */

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        System.out.println("==========Add items to cart by searching=====================");
        WebElement search_c_veg = driver.findElement(By.xpath("//input[@class='search-keyword']"));
        search_c_veg.sendKeys("c");
        search_c_veg.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//button[@class='search-button']")).click();

        List<WebElement> search_items = driver.findElements(By.xpath("//div[@class='product']"));
        System.out.println("size: " + search_items.size());


        for (int i = 1; i < search_items.size(); i++) {

            String search_item_text = search_items.get(i).getText();
            //System.out.println("====search items text: "+search_item_text);

            if (search_item_text.contains("Capsicum")) {
                System.out.println("===: " + search_items.get(i).getText() + "=======");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ADD TO CART' and @type='button']")));

                driver.findElements(By.xpath("//div[@class='product-action']//button[@type='button']")).get(i).click();

                //Thread.sleep(2000);
                break;
            }
        }

        System.out.println("====CART INFO===: " + driver.findElement(By.xpath("//div[@class='cart-info']")).getText());


    }

    /*
    public void demoFluentWait(WebDriver driver){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
    }
    */

    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        System.out.println("===rahul shetty academy site dropdown - Addiing Items to the Cart in Ecommerce App===");

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        System.out.println("===============================");
        String veggies[] = {"Mushroom", "Walnuts", "Nuts Mixture", "Strawberry"};

        AddItemsCartEcommerce ae = new AddItemsCartEcommerce();

        //ae.searchAndAddItems(driver);
        ae.addItemsCart(driver, veggies);
        //ae.demoFluentWait(driver);

    }

}

