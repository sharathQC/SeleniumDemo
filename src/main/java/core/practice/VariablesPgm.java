package core.practice;

public class VariablesPgm extends InterfaceExample{

    //instance, static, local variables, static and instance blocks, parameterized constructor

    static int a=30;
    int b;


    public void sum1(int p, int q){
        this.b = 40;
        System.out.println("sum of p+q: "+(p+q+a+this.b));
        System.out.println("global: "+b+" "+"static: "+a);
        System.out.println();
    }

    public void sum(){
        this.b=50;
        int x = 1;
        int y=2;
        int z = x+y;
        System.out.println("z: "+(x+y+a+this.b));
        System.out.println("global: "+b+" "+"static: "+a);

    }

    {
        System.out.println("this block pgm, checking which one executes first");
        String state = "Telangana";
        System.out.println("static var: "+a);
        System.out.println("global var: "+this.b);
    }

    static {
        System.out.println("this static block pgm, checking which one executes first");
        String country = "India";
        System.out.println("static var: "+a);

    }

    VariablesPgm(String a1, String b1) {
        System.out.println("this constructor, checking which one executes first:"+a1+" "+b1);
        String city = "Hyd";
        System.out.println("static var: "+a);
        System.out.println("global var: "+this.b);

    }

    public static void main(String args[]){

        VariablesPgm vp = new VariablesPgm("aa","bb");
        vp.sum();

        VariablesPgm vp1 = new VariablesPgm("cc","dd");
        vp1.sum1(10,20);

        System.out.println("=====abstract methods of one class defining and calling here=====");
        vp.display();
        vp.displayOne();

    }

    public void display(){
        System.out.println("display method is from abstract class and defining here in other class using extends keyword");
    }
    public void displayOne(){
        System.out.println("display method is from abstract class and defining here in other class using extends keyword");
    }

}
