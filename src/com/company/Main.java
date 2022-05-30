package com.company;
class LinkedList<E>{
    int size;
    Node<E> head;
    Node<E> tail;
    public LinkedList(){
        this.size=0;
        this.tail=new Node<E>(null,null,head);
        this.head = new Node<E>(null,tail,null);
        this.tail=new Node<E>(null,null,head);
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> pre;
        Node(E element,Node<E> next,Node<E> pre) {
            this.item = element;
            this.next = next;
            this.pre = pre;
        }

    }


    public boolean add(E e){
        Node newNode = new Node(e,this.tail,this.tail.pre);
        tail.pre.next=newNode;
        tail.pre=newNode;
        this.size++;
        return true;
    }


    public E remove(int index){
        if(index>=size){
            return null;
        }else{
            Node<E> cor= head.next;
            for(int i=0;i<index;i++){
                cor=cor.next;
            }
            cor.next.pre=cor.pre;
            cor.pre.next=cor.next;
            this.size--;
            return cor.item;
        }
    }


    public int size(){
        return this.size;
    }


    public E get(int index){
        if(index>=size){
            return null;
        }else{
            Node<E> cor= head.next;
            for(int i=0;i<index;i++){
                cor=cor.next;
            }
            return cor.item;
        }
    }


    public void print(){
        Node<E> cor= head.next;
        while(cor!=tail){
            System.out.println(cor.item.toString());
            cor=cor.next;
        }
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<String> test = new LinkedList<String>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        test.add("6");
        test.remove(4);
        test.print();
        System.out.println(test.size());
    }
}
