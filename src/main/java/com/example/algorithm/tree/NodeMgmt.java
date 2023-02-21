package com.example.algorithm.tree;

class TNode {
    TNode left;
    TNode right;
    int value;
    public TNode(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class NodeMgmt {
    TNode head = null;

    public boolean insertNode(int data) {
        //Case 1: Node 가 하나도 없을때
        if(this.head == null) {
            this.head = new TNode(data);
        } else {
            //case 2 Node 가 하나 이상 들어가 있을때
            TNode findNode = this.head;
            while (true) {
                //case 2-1 : 현재 Node 의 왼쪽에 Node가 들어가야 할때
                if(data < findNode.value) {
                    if(findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new TNode(data);
                        break;
                    }
                } else {
                    //case 2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할때
                    if(findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new TNode(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public TNode search(int data) {
        // Case 1: Node 가 하나도 없을때
        if(this.head == null) {
            return null;
        } else {
            // Case 2: Node 가 하나 이상 있을때
            TNode findNode = this.head;
            while (findNode != null) {
                if(findNode.value == data) {
                    return findNode;
                } else if(data < findNode.value){
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean removeNode(int data) {
        return false;
    }
}
