package com.example.algorithm.linked_list

import com.example.algorithm.DoubleLinkedList
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.sql.DriverManager
import java.util.stream.Stream


class MyHashTest {


    @ParameterizedTest
    @MethodSource("testValue1")
    fun linklistSingle(list: List<Int>) {
        val ll = DoubleLinkedList<Int>()
        for (item in list) {
            ll.addNode(item)
        }
        ll.printAll()
        DriverManager.println("searchFromHead = " + ll.searchFromHead(3))
        DriverManager.println("searchFromTail = " + ll.searchFromTail(2))
        ll.insertToFront(3, 10)
        ll.printAll()
    }

    companion object {
        @JvmStatic
        fun testValue1(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(java.util.List.of(1, 2, 3, 4))
            )
        }
    }
}