package com.packages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InheritanceOne {

    public void view(){
        System.out.println("Inheritance One Parent class : View Parent method");
    }

    @BeforeMethod
    public void beforeExecute(){
        System.out.println("Inheritance One Parent class : before execute method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Inheritance One Parent class : after execute method");
    }
}
