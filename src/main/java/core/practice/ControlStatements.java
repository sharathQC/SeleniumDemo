package core.practice;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ControlStatements {

    public int sum(){
        int a=1,b=2;
        return(a+b);
    }

    public int mul(int f, int g){
        return(f*g);
    }
    public static void main(String args[]){

        System.out.println("==========RETURN==========");
        ControlStatements cs = new ControlStatements();
        int sum = cs.sum();
        System.out.println("return sum: "+sum);

        System.out.println("==========RETURN=Paramerization=========");
        ControlStatements cs1 = new ControlStatements();
        int multi = cs.mul(2,3);
        System.out.println("return multiplication: "+multi);


        System.out.println("======IF-ELSE-IF===========");
        //IF loop
        int a = 10;
        if(a==10){
            System.out.println("value of a="+a);
        }else{
            System.out.println("a is not equal to 10");
        }


        //IF,ElseIF loop

        String city = "hyd";

        if(city == "bng"){
            System.out.println("you are in karnataka");
        } else if (city == "chennai") {
            System.out.println("you are in tamilnadu");
        } else if (city == "nagpur") {
            System.out.println("you are in maharashtra");
        } else if (city == "vizag") {
            System.out.println("you are in AP");
        } else if (city == "hyd") {
            System.out.println("you are in Telanagana");
        }else {
            System.out.println("you are in India");
        }

        //If Nested loop
        String capital = "hyd";
        String city_name = "kothapet";

        if(capital == "vizag"){
            if(city_name == "vijayawada"){
                System.out.println("you are AP>vijayawada city");
            } else if (city_name == "annavaram") {
                System.out.println("you are AP>Annavaram city");
            }else {
                System.out.println("you are AP state");
            }
        } else if (capital == "hydd") {
            if (city_name == "LB Nagar"){
                System.out.println("you are Telangana>HYD>LB Nagar");
            } else if (city_name == "DSNR") {
                System.out.println("you are Telangana>HYD>DSNR");
            } else if (city_name == "kothapet") {
                System.out.println("you are Telangana>HYD>Kothapet");
            }else {
                System.out.println("you are Telangana>HYD");
            }
        }else {
            System.out.println("you are India I guess");
        }

        System.out.println("============SWITCH CASE============");

        //Switch
        String place = "ECIL";

        switch(place){

            case "LB Nagar" : System.out.println("Staying at LB Nagar");
                              break;
            case "DSNR":      System.out.println("Staying at DSNR");
                              break;
            case "ECILL":      System.out.println("Staying at ECIL");
                              break;
            case "Madhapur":  System.out.println("Staying at Madhapur");
                              break;
            default:          System.out.println("Staying at Hyderabad");

        }

        System.out.println("=================FOR LOOP==================");
        //For Loop
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                System.out.println(i+" "+j);
            }
        }

        System.out.println("=================Pyramid pattern==================");

        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

        System.out.println("=================revserse Pyramid pattern==================");
        for(int i=5;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("===========FOR-EACH==========");
        String arr1[] = {"one","two","three","four","five"};
        for(String s:arr1){
            System.out.println(s);
        }
        System.out.println("========WHILE=======");
        int d=1;
        while (d<=5){
            System.out.println("while loop: "+d+" ");
            d++;
        }
        System.out.println("========DO-WHILE=======");
        int e=1;
        do{
            System.out.println("Do-while: "+e);
            e++;
        }while (e<=5);

        System.out.println("======BREAK========");
        for(int i=1;i<=5;i++){
            if(i==3){
                break;
            }
            System.out.println(i);
        }
        System.out.println("========CONTINUE=========");
        for(int i=1;i<=10;i++){

            if(i==5 || i==7){
                continue;
            }
            System.out.println(i);
        }

    }
}
