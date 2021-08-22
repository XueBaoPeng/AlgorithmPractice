package org.xbp.algorithm.algorithms4;

import java.util.Iterator;

public class Statck <Item> implements Iterable<Item>{
    private Node first;//栈顶
    private int N;//元素数量
    public boolean  isEmpty(){
        return first==null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldNext=first;
        first=new Node();
        first.item=item;
        first.next=oldNext;
        N++;
    }

    public Item pop(){
        Item item= first.item;
        first=first.next;
        N--;
        return item;
    }

    class Node{
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
