package org.xbp.algorithm.category.链表.single;

import org.xbp.algorithm.category.链表.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {

    private SingleLinkedList.Node<E> first;


    @Override
    public void clear() {
       size=0;
       first=null;
    }

    @Override
    public E get(int index) {
        return this.node(index).element;
    }

    @Override
    public E set(int index, E element) {
        E old=node(index).element;
        this.node(index).element=element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index==0){
            this.first = new SingleLinkedList.Node(element, this.first);
        }else {
            Node<E> prev=this.node(index-1);
            prev.next=new Node<>(element,prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        this.rangeCheck(index);
        SingleLinkedList.Node<E> node=first;
        if(index==0){
            first=first.next;
        }else {
            SingleLinkedList.Node<E> prev = this.node(index - 1);
            node=prev.next;
            prev.next=node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        SingleLinkedList.Node node;
        int i;
        if(element==null){
            node = this.first;
            for(  i=0;i<size;i++){
                if(node.element==element)
                {
                    return i;
                }
                node=node.next;
            }
        }else {
            node=this.first;
            for(i=0;i<size;i++){
                if(node.element.equals(element)){
                    return i;
                }
                node=node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private  SingleLinkedList.Node<E> node(int index){
        rangeCheck(index);
        SingleLinkedList.Node<E> node = this.first;

        for(int i=0;i<index;i++){
            node=node.next;
        }
        return  node;
    }

    private static class Node<E> {
        E element;
        SingleLinkedList.Node<E> next;

        public Node(E element, SingleLinkedList.Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
