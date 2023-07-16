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

    public boolean delete(int value) {
        boolean searched = false;

        TNode currParentNode = this.head;
        TNode currNode = this.head;

        ///코너 케이스 1: Node가 하나도 없을떄
        if(this.head == null) {
            return false;
        } else {
            ///코너 케이스2 : Node 가 단지 하나만 있고, 해당 Node가 삭제할 Node 일때
            if(this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if(currNode.value == value) {
                    searched = true;
                    break;
                } else if(value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if(searched == false) {
                return false;
            }

            //삭제할 Node가 Leaf Node 인경우
            if(currNode.left == null && currNode.right == null) {
                if(value < currParentNode.value) {
                    currParentNode.left = null;
                    currNode = null;
                } else {
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;
            } else if(currNode.left != null && currNode.right == null) { // Case 2-1삭제할 Node가 Child Node를 한개 가지고 있을경우 (왼쪽)
                if(value < currParentNode.value) {
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            } else if(currNode.left == null && currNode.right != null) {// Case 2-2삭제할 Node가 Child Node를 한개 가지고 있을경우 (오른쪽)
                if(value < currParentNode.value) {
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }
        }
        return true;
        ///여기까지 실행되면,
        //currNode에는 해당 데이터를 가지고 있는 Node;
        //currParentNodel 에는 해당 데이터를 가지고 있는 Node 의 부모 Node
    }


}
