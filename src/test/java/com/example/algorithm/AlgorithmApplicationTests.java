package com.example.algorithm;

import com.example.algorithm.linked_list.SingleLinkedList;
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

}
