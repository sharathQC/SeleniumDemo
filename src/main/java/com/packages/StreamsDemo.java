package com.packages;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    @Test
    public void streamDemo(){

        ArrayList<String> al = new ArrayList<String>();
        al.add("Hayath");
        al.add("Bhagyalatha");
        al.add("HKuntloor");
        al.add("Pasumamula");
        al.add("HLB");
        al.add("NTR");

//        for(String ele:al){
//            if (ele.startsWith("H")){
//                System.out.println(ele);
//            }
//        }

//        long count = al.stream().filter(i->i.startsWith("H")).count();
//        System.out.println(count);




        long num= Stream.of("Ashok","Bhanu","Chandu","Aanand","Aadi").filter(i->
        {
           return i.startsWith("A");
        }).count();

        System.out.println("fetch count of values starts with A: "+num);


        al.stream().filter(i->i.length()>4).forEach(i->System.out.println("fetch values len greater than 4: "+i));

        System.out.println("==================================");
        al.stream().filter(i->i.length()>4).limit(1).forEach(i->System.out.println("fetch values len greater than 4 and limited to 1: "+i));
    }


    @Test
    public void streamMap(){
        //fetch values whose length greater than 4, converting it to uppercase
        Stream.of("Ashok","Bhanu","Chandu","Aanand","Aadi").filter(i->i.length()>4).forEach(i->System.out.println(i.toUpperCase()));
        System.out.println("==================================");
        Stream.of("Ashok","Bhanu","Chandu","Aanand","Aadi").filter(i->i.length()>4).filter(i->i.endsWith("u")).map(i->i.toUpperCase()).forEach(i->System.out.println(i));
        System.out.println("===converting array to list, then stream, then sort the values===");
        List<String> names = Arrays.asList("Ashok","Bhanu","Chandu","Aanand","Aadin","Ankith");
        names.stream().filter(i->i.length()>4).filter(i->i.startsWith("A")).sorted().map(i->i.toUpperCase()).forEach(i->System.out.println(i));

        System.out.println("===Merging two Streams===");
        ArrayList<String> al = new ArrayList<String>();
        al.add("Hayath");
        al.add("Bhagyalatha");
        al.add("HKuntloor");
        al.add("Pasumamula");
        al.add("HLB");
        al.add("NTR");

        Stream<String> conStream = Stream.concat(names.stream(),al.stream());
        //conStream.sorted().forEach(i->System.out.println(i.toUpperCase()));

        System.out.println("===Verify string present, do assert===");
        boolean flag = conStream.anyMatch(i->i.equalsIgnoreCase("Aanand"));
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(flag,"not maching");
        sa.assertAll();
    }

    @Test
    public void streamCollect(){
        List<String> name= Stream.of("Ashok","Bhanu","Chandu","Aanand","Aadi").sorted().map(i->i.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(name.get(0));
    }

    @Test
    public void streamAssignment(){

        List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
        System.out.println("====Converting array to list, then stream, then Sorting Numbers===");
        numbers.stream().sorted().forEach(i->System.out.println(i));
        System.out.println("===Unique numbers===");
        numbers.stream().distinct().forEach(i->System.out.println(i));
        System.out.println("after sorting, print 2nd element");
        Integer q = numbers.stream().sorted().collect(Collectors.toList()).get(2);

        System.out.println("q: "+q);
        System.out.println("after unqie elements then sorting, print 2nd element");
        System.out.println(numbers.stream().distinct().sorted().collect(Collectors.toList()).get(2));
    }


    @Test
    public void streamAssignmentTwo(){

        ArrayList<String> states = new ArrayList<String>();
        states.add("Tamilnadu");
        states.add("Andhra Pradesh");
        states.add("Telangana");
        states.add("karnataka");
        states.add("Tiruvananthapuram");

        List<String> places = Arrays.asList("Kuntloor","NTR Nagar","Kothapet","LB Nagar");
        List<Integer> numbers = Arrays.asList(7,3,6,4,5,4,4,3,2,6,7);

        System.out.println("====Array List converted to stream, fetch the values grater then 4 chars, sort it, convert to uppercase====");
        states.stream().filter(i->i.length()>4).sorted().map(i->i.toUpperCase())
                .forEach(i->System.out.println(i));

        System.out.println("====Array List-> stream, fetch values starts with A letter then print====");
        states.stream().filter(i->i.startsWith("T")).forEach(i->System.out.println(i));

        System.out.println("====Array List->Stream, fetch unique numbers then sort it====");
        numbers.stream().distinct().sorted().forEach(i->System.out.println(i));

        System.out.println("###Collectors to List method and get###: "+places.stream().filter(i->i.endsWith("r")).sorted().collect(Collectors.toList()).get(0));

        System.out.println("===Collectors to List method and get===: "+places.stream().sorted().filter(i->i.endsWith("r")).collect(Collectors.toList()).get(2));

        System.out.println("===Limit method====");
        states.stream().sorted().filter(i->i.startsWith("T")).limit(2).forEach(i->System.out.println(i));

    }

}
