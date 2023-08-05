package core.practice;

interface Printer{
    void printerShow();
    }

    abstract class GeneralStore implements Printer{
    abstract void generalStorePurchase();

    }
public class DemoPractice extends GeneralStore{

    public void demoPracticeShow1(){
        System.out.println("own class DemoPractice class>show1 method");
    }

    public void generalStorePurchase(){
        System.out.println("abstract class method");
    }

    public static void main(String args[]){

        DemoPractice dp = new DemoPractice();
        dp.printerShow();
        dp.demoPracticeShow1();
        dp.generalStorePurchase();
    }


    public void printerShow() {
        System.out.println("Printer Interface>show method---defined in another class");
    }
}
