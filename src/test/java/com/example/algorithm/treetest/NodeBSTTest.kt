package com.example.algorithm.treetest

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class NodeBSTTest {


    @ParameterizedTest
    @MethodSource("testValue1")
    fun treeTest(list: List<Int>) {
        val bstTree = NodeBST()
        bstTree.insert(1)
        bstTree.insert(2)
        bstTree.insert(3)
        bstTree.insert(4)
        bstTree.insert(5)
        println("bstTree.search = [${bstTree.searchNode(3)?.right?.value}]")
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