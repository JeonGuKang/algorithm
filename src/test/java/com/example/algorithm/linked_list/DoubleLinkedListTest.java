package com.example.algorithm.linked_list;

import com.example.algorithm.DoubleLinkedList;
import com.example.algorithm.SingleLinkedList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class DoubleLinkedListTest {

    @ParameterizedTest
    @MethodSource("testValue")
    void linklistSingle(List<Integer> list) {
        DoubleLinkedList<Integer> ll = new DoubleLinkedList<>();
        for (Integer item : list) {
            ll.addNode(item);
        }
        ll.printAll();
        System.out.println("searchFromHead = " + ll.searchFromHead(3));
        System.out.println("searchFromTail = " + ll.searchFromTail(2));
        ll.insertToFront(3, 10);
        ll.printAll();
    }

    private static Stream<Arguments> testValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4)));
    }
}
