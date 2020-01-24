package ru.otus;

import org.junit.Assert;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        DIYArrayList<Integer> testlist = new DIYArrayList();
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

        System.out.println("size " + testlist.size());
        for (Object one: testlist) {
            System.out.println(one);
        }

        System.out.println("----------------------");


        Collections.sort(testlist);

        System.out.println("size " + testlist.size());
        for (Object one: testlist) {
            System.out.println(one);
        }
        System.out.println("----------------------");

        DIYArrayList<Integer> testlist2 = new DIYArrayList();
        for (int i = 1; i<=testlist.size(); i++) {
            testlist2.add(0);
        }
        System.out.println("size2 " + testlist2.size());

        Collections.copy(testlist2, testlist);

        for (Object two: testlist2) {
            System.out.println(two);
        }

    }
}
