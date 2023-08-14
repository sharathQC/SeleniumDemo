package core.practice;
//method overriding - parent class reference variables & child class object, will call the child class method only.
// but have access to both parent & child class methods

class Parent{
    public void display(){
        System.out.println("Parent class: display method");
    }
    public void view(){
        System.out.println("Parent class: view method");
    }
}

class Child1 extends Parent{
    public void display(){
        System.out.println("Child1 class: display method");
    }
}

class Child2 extends Child1{
    public void display(){
        System.out.println("Child2 class: display method");
    }
}

class Child3 extends Child2{
    public void display(){
        System.out.println("Child3 class: display method");
    }

}



public class PolymorphismDemo {
    public void view(int a, int b){
        System.out.println("sum of two parameters: "+(a+b));
    }
    public void view(int a, int b,int c){
        System.out.println("sum of three parameters: "+(a+b+c));
    }

    public void view(int a, int b,int c, int d){
        System.out.println("sum of four parameters: "+(a+b+c+d));
    }
    public void view(int a, int b, int c, int d, int e){
        System.out.println("sum of two parameters: "+(a+b+c+d+e));
        System.out.println("sum of two parameters: "+(a+b+c+d+e));
    }



    public static void main(String args[]){
        PolymorphismDemo pd = new PolymorphismDemo();

        System.out.println("===Method Overloading===");
        pd.view(2,3);
        pd.view(2,3, 4);
        pd.view(2,3, 4, 5);
        pd.view(2,3, 4, 5, 6);


        Parent p = new Child1();
        Parent p1 = new Child2();

        System.out.println("====Method overriding====");
        p.display();
        p1.display();

        p.view();
        p1.view();

        Parent p2 = new Parent();
        p2.display();

        Child1 c = new Child3();
        c.display();


    }
}
