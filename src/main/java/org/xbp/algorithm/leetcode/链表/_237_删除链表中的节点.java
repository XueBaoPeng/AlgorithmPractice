package org.xbp.algorithm.leetcode.链表;

/**
 * Created on 2021/8/26.
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author xuebaopeng
 * Description
 */
public class _237_删除链表中的节点 {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public void deleteNode(ListNode node) {
      node.val=node.next.val;
      node.next=node.next.next;
    }

}
