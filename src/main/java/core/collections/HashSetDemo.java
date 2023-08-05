package core.collections;

/*HashSet === do not allow duplicates, allow null values, not gurantee on saving order of ele, cause they are saving based on hashcode

 */
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String args[]){

        HashSet<String> hs = new HashSet<String>();
        hs.add("Aanand");
        hs.add("Banu");
        hs.add("");
        hs.add("Chandu");
        hs.add("Dhanush");
        hs.add("");
        hs.add("Elephant");
        hs.add("Aanand");

        System.out.println("===Iterarting-using iterator-HashSet====");
        Iterator itr = hs.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("===iteration on hashset======");
        for (String ele:hs){
            System.out.println(ele.toUpperCase());
        }
        System.out.println("Size of HashSet: "+hs.size());
        hs.remove("Elephant");
        hs.add("mango");
        hs.add("apple");
        System.out.println("===iteration after adding and removing ele from hs===");
        for (String ele:hs){
            System.out.println(ele);
        }
        System.out.println("Size of HashSet: "+hs.size());
        System.out.println("is empty: "+hs.isEmpty()+" contains: "+hs.contains("Dhanush")+" checking equals: "+hs.equals("apple"));

        HashSet<String> hs1 = new HashSet<String>();
        hs1.add("Laptop");
        hs1.add("Desktop");

        hs.addAll(hs1);


        System.out.println("==iterating after merging other hashset: hs1 into hs====");
        for (String ele:hs){
            System.out.println(ele);
        }
        System.out.println("Size of HashSet: "+hs.size());

        System.out.println("==converting hashset to object array===");
        Object arr1[] = hs.toArray();
        for (Object ele:arr1){
            System.out.println(ele);
        }

        System.out.println("===converting hashset to string ===");
       String str =  hs.toString();
       System.out.println(str+" "+str.length());
      String s[] =  str.split(" ");
      System.out.println("String array:");
      for(String ele:s){
          System.out.println(ele.toUpperCase());
      }
      System.out.println(s.length);



    }
}
