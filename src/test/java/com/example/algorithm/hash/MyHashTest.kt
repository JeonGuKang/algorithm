package com.example.algorithm.linked_list

import com.example.algorithm.DoubleLinkedList
import com.example.algorithm.hash.MyHash
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.sql.DriverManager
import java.util.stream.Stream


class MyHashTest {


    @ParameterizedTest
    @MethodSource("testValue1")
    fun hashTest(list: List<Int>) {
        val myHash = MyHash(20)
        myHash.saveData("JeonGu", "01011111111")
        myHash.saveData("Gugu", "0102222222")
        myHash.saveData("kaka", "01033333333")

        print("myHash.getData(\"JeonGu\") = ${myHash.getData("JeonGu")}")

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