package org.xbp.algorithm.category.链表;

import org.xbp.algorithm.category.链表.circle.CircleLinkedList;
import org.xbp.algorithm.category.链表.circle.SingleCircleLinkedList;
import org.xbp.algorithm.category.链表.single.SingleLinkedList;
import org.xbp.algorithm.category.链表.single.SingleLinkedList2;

/**
 * Created on 2021/8/23.
 *
 * @author xuebaopeng
 * Description
 */
public class Main {

    public static void main(String[] args) {
//		testList(new ArrayList<>());  // 动态数组
//		testList(new LinkedList<Integer>()); // 双向链表
//		testList(new SingleCircleLinkedList<Integer>()); // 单向循环链表
        testList(new CircleLinkedList<Integer>());
//       testList(new SingleLinkedList<Integer>());//单链表
//       testList(new SingleLinkedList2<Integer>());//有虚拟头结点的单链表

    }

    static void testList(List<Integer> list){
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }
}
