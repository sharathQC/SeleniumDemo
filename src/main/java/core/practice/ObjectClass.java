package core.practice;

public class ObjectClass extends DemoInterface{
    int pincode;
    String place;
    static String state ="Telangana";

    public void display(String str, int num){
        pincode = num;
        place = str;
        displayOne();
    }
    public static void show(){
        System.out.println("static method"+" "+state+" ");
    }
    public void displayOne(){
        System.out.println("place: "+place+" pincode: "+pincode);
    }
    public static void main(String args[]){

        System.out.println("=====Object-1=========");
        ObjectClass oc = new ObjectClass();
        oc.display("LB Nagar",500074);

        System.out.println("=====Object-2=========");
        ObjectClass oc1 = new ObjectClass();
        oc1.display("NTR Nagar",500075);

        System.out.println("=====anonymous==Object=========");
        new ObjectClass().display("DSNR",500081);
        System.out.println("===STATIC==METHOD=====");
        show();
        System.out.println("=====extending=DemoInterface==class=which=implements=an=interface===");
        oc.construction();
        oc.cleaning();

    }
}
