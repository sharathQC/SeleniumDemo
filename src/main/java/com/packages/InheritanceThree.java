package com.packages;

public class InheritanceThree extends InheritanceFour{
    int a;

    public InheritanceThree(int a) {
        super(a);
        this.a = a;
    }

    public int increment(){
        a = a+1;
        return a;
    }

    public int decrement(){
        a = a-1;
        return a;
    }
}
