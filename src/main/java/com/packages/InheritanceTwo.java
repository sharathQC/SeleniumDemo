package com.packages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InheritanceTwo extends  InheritanceOne{
int a = 20;
    InheritanceThree it = new InheritanceThree(a);


    //InheritanceFour itf = new InheritanceFour(a);


    @Test
    public void execute(){
        view();
    }

    @Test
    public void executeOne(){

        System.out.println("increment method: "+it.increment());
        System.out.println("decrement method: "+it.decrement());
    }

    @Test
    public void multiply(){
        System.out.println("Multiply by 2: "+it.multiplyTwo());
        System.out.println("Multiply by 3: "+it.multiplyThree());
    }

}
