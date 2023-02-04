package com.example.algorithm.linked_list;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LinkedListTest {

    @ParameterizedTest
    @MethodSource("testValue")
    void linklist(List<Integer> list) {
        SingleLinkedList<Integer> ll = new SingleLinkedList<>();

        for (Integer item : list) {
            ll.addNode(item);
        }

        // ll.addNode(1);
        // ll.addNode(2);
        // ll.addNode(3);
        // ll.addNode(6);
        // ll.addNode(10);
        ll.printAll();
    }

    @ParameterizedTest
    @MethodSource("testMultiValue")
    void linklistMulti(List<Integer> list, int n1, int n2, int n3) {
        SingleLinkedList<Integer> ll = new SingleLinkedList<>();

        for (Integer item : list) {
            ll.addNode(item);
        }
        ll.printAll();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
        // @ValueSource(ints = 1)
    void linklistSingle(int n) {
        SingleLinkedList<Integer> ll = new SingleLinkedList<>();

        ll.addNode(n);
        ll.printAll();
    }

    private static Stream<Arguments> testValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4)));
    }

    private static Stream<Arguments> testMultiValue() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), 1, 2, 3));
    }

    private static Stream<Arguments> addNodeMultiValue() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5), 3, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("addNodeMultiValue")
    void linkedListAddNode(List<Integer> list, int n1, int n2) {
        SingleLinkedList<Integer> ll = new SingleLinkedList<>();
        for (Integer item : list) {
            ll.addNode(item);
        }

        ll.addNodeInside(n2, n1);

        ll.printAll();
    }

}