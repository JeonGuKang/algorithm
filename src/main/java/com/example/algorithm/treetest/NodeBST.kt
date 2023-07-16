package com.example.algorithm.treetest

data class KNode(
    var left : KNode? = null,
    var right : KNode? = null,
    var value : Int = 0
)

class NodeBST {
    var head: KNode? = null

    fun insert(value : Int) : Boolean {
        if(head == null) {
            head = KNode(value = value)
            return true
        } else {
            var findNode = head
            while (true) {
                if(value < (findNode?.value ?: 0)) {
                    if(findNode?.left == null) {
                      findNode?.left = KNode(value = value)
                      break
                    } else {
                      findNode = findNode.left
                    }
                } else {
                    if(findNode?.right == null) {
                        findNode?.right = KNode(value = value)
                        break
                    } else {
                        findNode = findNode.right
                    }
                }
            }
            return true
        }
    }

    fun searchNode(value : Int): KNode? {
        if(head == null) {
            return null
        } else {
            var findNode = head
            while (true) {
                findNode = if(findNode?.value == value) {
                    return findNode
                } else {
                    if(value < (findNode?.value ?: 0)) {
                        findNode?.left
                    } else {
                        findNode?.right
                    }
                }
            }
            return null
        }
    }
}