package com.example.algorithm.tree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class NodeMgmtTest {


    @ParameterizedTest
    @MethodSource("testValue1")
    fun nodeMgmtTest(list: List<Int>) {
       val nodeMgmt =  NodeMgmt()
        for(item in list) {
            nodeMgmt.insertNode(item)
        }
        print(" before= ${nodeMgmt.search(3).value}")
        print(" = ${nodeMgmt.removeNode(3)}")
        print(" after = ${nodeMgmt.search(3).value}")
    }

    companion object {
        @JvmStatic
        fun testValue1(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(3,1,2,4,5))
            )
        }
    }
}