package com.example.desig.linkedList;



public class StructureDemo {
    public static void main(String[] args) {
        CoustomLinkedList<Integer> coustomLinkedList = new CoustomLinkedList<>();
        coustomLinkedList.addNode(1);
        coustomLinkedList.addNode(2);
        coustomLinkedList.addNode(3);
        coustomLinkedList.addNode(4);
        System.out.println(coustomLinkedList.toString());
        coustomLinkedList.addNode(2,5);
        System.out.println(coustomLinkedList.toString());
        System.out.println(coustomLinkedList.isEmpty());
        coustomLinkedList.remove(2);
        System.out.println(coustomLinkedList.toString());
        coustomLinkedList.addFirstNode(0);
        coustomLinkedList.addFirstNode(6);
        System.out.println(coustomLinkedList.toString());
        coustomLinkedList.reverseList();
        System.out.println(coustomLinkedList.toString());
    }



}
