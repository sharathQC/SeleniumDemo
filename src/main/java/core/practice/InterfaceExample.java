package core.practice;

  abstract class DemoAbstract{
      abstract void display();
      public void displayOne(){
          System.out.println("Abstract class - non abstract method");
      }
  }


public class InterfaceExample extends DemoAbstract{

      public void display(){
          System.out.println("Abstract class>display-method code written in Interface class>display method");
      }
    public static void main(String args[]){

        DemoAbstract d = new InterfaceExample();
        d.display();
        d.displayOne();


    }
}
