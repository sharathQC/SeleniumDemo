package core.practice;

/*inteface will have methods but do not have bodies, some class has to be implement it and define all methods present in the interface.
 with interface will achieve multiple inheritance, data abstraction
 methods and variables all are by default public static final in interface irrespective how they declared
 */

interface House{
    void construction();
    void cleaning();
    static String msg ="interface static variable";
    String msg1 ="non static variable";
}
public class DemoInterface implements House{


    public static void main(String args[]){
        DemoInterface di = new DemoInterface();
        di.construction();
        di.cleaning();

    }

    @Override
    public void construction() {
        System.out.println("Interface>Construction method is difined in demoInterface class "+msg+" "+msg1);
        System.out.println("Interface>Construction method is difined in demoInterface class "+msg+" "+msg1);
    }
    public void cleaning(){
        System.out.println("Interface>cleaning method is difining in demointerface class");
        System.out.println("Interface>cleaning method is difining in demointerface class");
    }
}
