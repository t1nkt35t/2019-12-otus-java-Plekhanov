package ru.otus;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        DIYArrayList testlist = new DIYArrayList();
        testlist.add(2);
        testlist.add(4);
        testlist.add(8);
        testlist.add(16);
        testlist.add(12);
        testlist.add(14);
        testlist.add(10);
        testlist.add(18);
        testlist.add(20);
        testlist.add(22);
        testlist.add(24);
        Collections.addAll(testlist, 9, 11, 7, 5, 3, 1, 13, 17, 15, 19, 23, 21);

        System.out.println(testlist.size());
        for (Object one: testlist) {
            System.out.println(one);
        }

        System.out.println("----------------------");


        Collections.sort(testlist);
        System.out.println(testlist.size());
        for (Object one: testlist) {
            System.out.println(one);
        }
    }
}
