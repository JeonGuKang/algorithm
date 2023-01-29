package com.example.algorithm;

import com.example.algorithm.linked_list.SingleLinkedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class AlgorithmApplicationTests {

    @Test
    void contextLoads() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);
        singleLinkedList.printAll();
    }

}
