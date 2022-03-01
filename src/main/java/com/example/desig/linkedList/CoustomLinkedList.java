package com.example.desig.linkedList;

import org.w3c.dom.Node;

public class CoustomLinkedList<E> {
    private int size;
    private Node dyncHead;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = dyncHead.next;
        while (temp != null){
            stringBuilder.append(temp+"->");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    private class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CoustomLinkedList() {
        this.size = 0;
        this.dyncHead = new Node(null,null);
    }

    public void addNode(int index, E node){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node head = dyncHead;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        head.next = new Node(node,head.next);
        size++;
    }

    public void addNode(E node){
        addNode(size,node);
    }

    public void addFirstNode(E node){
        addNode(0,node);
    }
    /**
     *
     * @author zhouyulong@uyaogui.com
     * @date 2022/2/22
     * description
     */
    public void reverseList(){
        Node head = dyncHead.next;  //当前节点
        Node next = null;   //下一节点
        Node reverseHead = new Node(null,null); //反转节点
        while (head != null){
            next = head.next; //移动下一节点
            head.next = reverseHead.next; //上一次
            reverseHead.next = head;
            head = next;
        }
        dyncHead.next = reverseHead.next;
    }


    public boolean isEmpty(){
        return size ==0;
    }

    public Node remove(int index){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node tempHead = dyncHead;
        for (int i = 0; i < index; i++) {
            tempHead = tempHead.next;
        }
        Node removeNode = tempHead.next;
        tempHead.next = removeNode.next;
        return removeNode;
    }


}
