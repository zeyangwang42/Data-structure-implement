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


class BST<E>{
    TreeNode<E> root;
    public BST(){
        this.root=null;
    }

    private static class TreeNode<E>{
        E item;
        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode(E element) {
            this.item = element;
        }

        public boolean compare(E e){                          // this method should be override
            if(e.hashCode()<this.item.hashCode()){             // since I donot know the data type here, I just compare the
                return false;                                   // hashcode here.
            }
            return true;
        }

    }


    public void insert(E e){
        insertRecursive(this.root,e);
    }
    public TreeNode insertRecursive(TreeNode node,E e){
        if(node==null){
            node = new TreeNode(e);
            return node;
        }
        if(node.compare(e)){
            node.left=insertRecursive(node.left,e);
        }else{
            node.right=insertRecursive(node.right,e);
        }
        return node;
    }
    public boolean search(E e){
        return searchRecursive(this.root,e);
    }
    public boolean searchRecursive(TreeNode node,E e){
        if(node==null){
            return false;
        }
        if(node.item.equals(e)){
            return true;
        }else{
            return searchRecursive(node.right,e)||searchRecursive(node.left,e);
        }
    }
    public void remove(E e){

    }

    public TreeNode removeRecursive(TreeNode node,E e){
        if(node==null){
            return node;
        }
        if(node.item.hashCode()>e.hashCode()){
            node.left= removeRecursive(node.left,e);
        }else if(node.item.hashCode()<e.hashCode()){
            node.right= removeRecursive(node.right,e);
        }else{
            if(node.left==null){
                return node.right;
            }else if(node.right==null) {
                return node.left;
            }else{
                node.item=minValue(node);
                node.left=removeRecursive(node.left, (E) node.item);
            }
        }
        return node;
    }
    TreeNode minValue(TreeNode node){
        TreeNode cor =node;
        while(cor.left!=null){
            cor=cor.left;
        }


        return cor;
    }

    public void print(){

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
