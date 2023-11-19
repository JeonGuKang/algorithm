package com.example.algorithm.maze.bfs

import com.example.algorithm.treetest.NodeBST
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue
class BfsMazeTest {


    val maze = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1)
    )

    val rows = 5
    val cols = 5

    val visited = Array(rows) { BooleanArray(cols) }

    val startX = 0
    val startY = 0
    val endX = 4
    val endY = 4

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun isValid(x: Int, y: Int): Boolean {
        return x in 0 until rows && y in 0 until cols && maze[x][y] == 1 && !visited[x][y]
    }

    fun bfs(): Boolean {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(startX, startY))
        visited[startX][startY] = true

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            if (x == endX && y == endY) return true

            for (i in 0 until 4) {
                val newX = x + dx[i]
                val newY = y + dy[i]

                if (isValid(newX, newY)) {
                    queue.offer(Pair(newX, newY))
                    visited[newX][newY] = true
                }
            }
        }
        return false
    }


    @Test
    fun startTest() {
        if (bfs()) {
            println("경로가 존재합니다.")
        } else {
            println("경로가 존재하지 않습니다.")
        }
    }

}