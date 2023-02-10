package com.example.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


class AlgorithmApplicationTests {

    @Test
    void 내림차순() {
        long value = 118372L;
        final int[] ints = Long.toString(value).chars().map(x -> x - '0').toArray();
        String result = Arrays.stream(Arrays.stream(ints).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println(result);
    }

    @Test
    void contextLoads() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);
        singleLinkedList.printAll();
    }


    @Test
    void 하샤드수(int x) {
        final int[] ints = Integer.toString(x).chars().map(item -> item - '0').toArray();
        int sum = 0;
        for(int i : ints) {
            sum += i;
        }
        boolean answer = x % sum == 0;
    }

    @Test
    long 두정수사이의합(int a, int b) {
        if(a == b) return a;
        long sum = 0;
        for(int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }

    @Test
    int 콜라츠추측(int num) {
        if(num == 1) return 0;
        long intToLong = num;
        int count = 0;
        while (intToLong != 1) {
            if(intToLong % 2 == 0) {
                intToLong /= 2;
            } else {
                intToLong *= 3;
                intToLong +=1;
            }
            count ++;
        }

        if(count >= 500.0) {
            return -1;
        } else {
            return count;
        }
    }

}
