package org.xbp.algorithm.category.链表.single;

import org.xbp.algorithm.category.链表.AbstractList;

/**
 * 单链表
 * @param <E>
 */
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
        if(index==0){// 给空链表添加第一个元素的情况
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
        if(index==0){// 删除第一个元素是特殊情况
            first=first.next;
        }else {
            SingleLinkedList.Node<E> prev = this.node(index - 1);// 找到前一个元素
            node=prev.next;// 要删除的元素
            prev.next=node.next;// 删除元素
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
    // 链表中的节点
    private static class Node<E> {
        E element;
        SingleLinkedList.Node<E> next;

        public Node(E element, SingleLinkedList.Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

}
