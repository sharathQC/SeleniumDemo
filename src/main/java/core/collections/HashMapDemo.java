package core.collections;

import java.util.HashMap;
import java.util.Map;

/* Hashmap will not allow duplicate data for keys.

 */
public class HashMapDemo {
    public static void main(String args[]){

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(10, "Bhagyalatha");
        map.put(11, "Kuntloor");
        map.put(12, "Pasumamula");
        map.put(13, "Munaganoor");
        map.put(13, "BN Reddy");
        map.put(0,"");
        map.put(null,"null");
        map.put(0,"");
        map.put(null,"null");


        System.out.println("====HashMap==Iteration====");
        for(Map.Entry<Integer, String > ele:map.entrySet()){
            System.out.println(ele.getKey()+" "+ele.getValue());
        }

        System.out.println("hashmap size: "+map.size()+" containskey:  "+map.containsKey(11)+" containsvalue: "+map.containsValue("Kuntloor"));
        System.out.println("getvalue using key: "+map.get(12));

        Map<Integer, String> map1 = new HashMap<Integer, String >();
        map1.put(20,"Mango");
        map1.put(21,"Apple");
        map1.put(22,"Pomogranite");

        System.out.println("===another hashmap===== "+"hashmap size: "+map1.size());
        for(Map.Entry<Integer, String> a:map1.entrySet()){
            System.out.println(a.getKey()+" "+a.getValue());
        }

        map.putAll(map1);
        System.out.println("==merging map1 into map===="+"Hashmap size: "+map.size());
        for(Map.Entry<Integer, String> b:map.entrySet()){
            System.out.println(b.getKey()+" "+b.getValue());
        }

        map.remove(22);
        map.remove(10,"Bhagyalatha");
        map.put(14,"Koti");

        System.out.println("===remove and put methods==="+" map size: "+map.size());

        for(Map.Entry<Integer, String> m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


        System.out.println("=========================");
        map.values();
        System.out.println(map.values());

        System.out.println("=================");
        for(Map.Entry<Integer, String> mm : map.entrySet()){
            System.out.println(mm.equals(map1));
        }

        System.out.println("=========================");
    }
}
