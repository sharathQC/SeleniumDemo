package com.packages;
//sorting the array list using streams, converting array list to stream then to list, streams operations on array list
//get the price of the veg using its name traverse through pages
//search and find

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
    public static void main(String args[]) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("===WebTable sorting and verifying with assert===");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

//        Select s1 = new Select(driver.findElement(By.id("page-menu")));
//        s1.selectByVisibleText("20");


        driver.findElement(By.xpath("//th//span[contains(text(),'Veg/fruit name')]")).click();
        List<WebElement> fruits = driver.findElements(By.xpath("//tbody//tr//td[1]"));

        List<String> fruits_stream = fruits.stream().map(i->i.getText()).collect(Collectors.toList());

        List<String> fruits_stream_sorted = fruits_stream.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(fruits_stream.equals(fruits_stream_sorted));



        String pages =driver.findElement(By.xpath("//select[@id='page-menu']//option[1]")).getText();
        int pages_count = (Integer.parseInt(pages))-1;
        System.out.println("pages count: "+pages_count);

//get the price of the veg using its name traverse through pages
        for(int a=0;a<pages_count;a++){


            List<WebElement> ele = driver.findElements(By.xpath("//tbody//tr"));
            System.out.println("size: "+ele.size());


            for(int i=0;i<ele.size();i++){
                System.out.println("first page: "+ele.get(i).getText());


                if(ele.get(i).getText().contains("Strawberry")){
                    System.out.println(ele.get(i).getText()+" Price: "+driver.findElement(By.xpath("//tbody//tr["+(i+1)+"]"+"//following-sibling::td[1]")).getText());
                    break;

                }
                if(i == ele.size()-1) {
                    driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
                }
            }


        }


        System.out.println("====search ele====");
        driver.findElement(By.id("search-field")).sendKeys("Potato");
        List<WebElement> search_ele = driver.findElements(By.xpath("//tbody//tr//td[1]"));

        List<WebElement> filter_list = search_ele.stream().filter(i->i.getText().contains("Strawberry")).collect(Collectors.toList());
        System.out.println(filter_list.size()+"  "+search_ele.size());




        Assert.assertTrue(search_ele.equals(filter_list));

//        for(WebElement ele: search_ele){
//            System.out.println(ele.getText());
//        }





        }
    }


