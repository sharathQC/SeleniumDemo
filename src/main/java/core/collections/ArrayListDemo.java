package core.collections;
/* array list === allow duplicate values and null values
  gurantee on order of adding ele to the list
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String args[]){


        ArrayList<String> al = new ArrayList<String>();
        al.add("Hayath nagar");
        al.add("LB Nagar");
        al.add("NTR nagar");
        al.add("BN Reddy Nagar");
        al.add("DSNR");
        al.add("Kothapet");


        System.out.println("==Array List===Elemets=====");
        System.out.println("ArrayList size: "+al.size());
        for(String ele:al){
            System.out.println(ele);
        }
        al.set(0,"BhagyaLatha");
        al.add("Koti");
        al.remove("NTR nagar");
        al.remove(1);
        System.out.println("get of 1st index : "+al.get(1)+" get size: "+al.size());
        System.out.println("========================");
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i));
        }
        System.out.println("========================");
        al.add(1,"ECIL");
        al.add(2,"Kapra");
        al.add("Telangana");
        al.add("Odisha");
        for(String ele:al){
            System.out.println(ele);
        }
        System.out.println("get of 1st index : "+al.get(1)+" get size: "+al.size());
        System.out.println("=========NEW COLLECTION===============");
        ArrayList<String> al1 = new ArrayList<String>();
        al1.add("Telangana");
        al1.add("AP");
        al1.add("Tamilandu");
        al1.add("Odisha");
        System.out.println("===adding one collection to the other: al1 to al===");

        al.addAll(1,al1);

        System.out.println("===iterating collection after merging al1 into al===");
        for(String ele:al){
            System.out.println(ele);
        }
        System.out.println("get of 1st index : "+al.get(2)+" get size: "+al.size());
        System.out.println("=======small methods in array list=========");
        System.out.println(al.contains("Telangana")+" "+al.indexOf("Odisha")+" "+al.isEmpty()+" "+al.lastIndexOf("Odisha"));



        List<String> li = new ArrayList<String>();
        li = al.subList(2,5);
        System.out.println("===iterating LIST collection after creating sublist with specified index===");
        for(String ele:li){
            System.out.println(ele);
        }
        System.out.println("========converting array-list to object array=======");
        Object arr1[] = al.toArray();

        for(Object ele:arr1){
            System.out.println(ele);
        }
        System.out.println("===sorting arraylist====");
        al.add("");
        al.add("");
        Collections.sort(al);
        for(String ele:al){
            System.out.println(ele.toUpperCase());
        }

        System.out.println("====iterating through iterator====");
        Iterator itr = al.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        Iterator itr1 = al.iterator();
        while (itr1.hasNext()){
            System.out.println(itr.next());
        }

    }
}
