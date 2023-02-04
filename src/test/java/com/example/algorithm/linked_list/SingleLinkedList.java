package com.example.algorithm.linked_list;

public class SingleLinkedList<T> {

    CustomNode<T> head = null;

    class CustomNode<T> {
        T data;
        CustomNode<T> next = null;
        public CustomNode(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if(head == null) {
            head = new CustomNode<T>(data);
        } else {
            CustomNode<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new CustomNode<T>(data);
        }
    }

    public void printAll() {
        if(head != null) {
            CustomNode<T> node = head;
            while (node.next != null) {
                System.out.println(node.data);
                node = node.next;
            }
            System.out.println(node.data);
        }
    }

    public CustomNode<T> search(T data) {
        if (this.head != null) {
            CustomNode<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T data, T isData) {
        CustomNode<T> searchNode = this.search(isData);

        if(searchNode == null) {
            this.addNode(data);
        } else {
            CustomNode<T> nextNode = searchNode.next;
            searchNode.next = new CustomNode<T>(data);
            searchNode.next.next = nextNode;
        }
    }
}
