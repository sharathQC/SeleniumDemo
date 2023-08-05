package core.practice;

public class Constructor {
    int num;
    String name;
    static String city ="Hyderabad";
    int id = 10;
    //paramterized constructor


    Constructor(int i, String s){
        System.out.println(i+" "+s);
    }
    Constructor(int i, String s, String s1){
        System.out.println(i+" "+s+" "+s1);
    }

    //static block

    static {
        System.out.println("This is static block "+"Static var: "+city);
    }

    //static method
    public static void view(){

        System.out.println("Static method: "+city);
    }

    //static method with return
    public static String view1(String s1, String s2){
        return (s1+s2);
    }



    public void display(){
     System.out.println("Display method");
    }
    public static void main(String args[]){
        Constructor c = new Constructor(1,"Sharath");
        Constructor c1 = new Constructor(2, "Aanand","NTR");
        view();
        String str = view1("HYD","SEC");
        System.out.println("Static return method: "+str);
    }
}
