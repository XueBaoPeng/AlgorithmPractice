package org.xbp.algorithm.category._06_二叉搜索树;

import java.util.Comparator;

/**
 * Created on 2021/8/30.
 *
 * @author xuebaopeng
 * Description
 */
public class BinarySearchTree<E> implements BinaryTreeInfo{

    private int size;
    private Node<E> root;//根节点
    private Comparator<E> comparator; // 比较器
    public BinarySearchTree (Comparator<E> comparator){ // 可以传一个比较器
        this.comparator = comparator;
    }
    public BinarySearchTree(){ // 默认不传比较器
        this(null);
    }
    /**
     * 元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 清空所有的元素
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element){
        elementNotNullCheck(element);
        //如果传入第一个节点
        if(root==null){
            root=new Node<>(element,null);
            size++;
            return;
        }
        Node<E> node=root;
        Node<E> parent=root;
        int cmp=0;//比较的值
        //寻找要插入节点的父节点
        while(node!=null){
            parent=node;
            cmp=compareTo(node.element,element);//方向
            if(cmp<0){
                node=node.right;
            }else if(cmp>0){
                node=node.left;
            }else {// 相等，最好是覆盖掉
                node.element=element;
                return;
            }
        }
        Node<E> newNode=new Node<>(element,parent);
        if(cmp<0){
            parent.right=newNode;
        }else {
            parent.left=newNode;
        }
        size++;
    }

    //节点元素比较
    private int compareTo(E e1,E e2){
        if (comparator!=null){// 传入比较器则通过比较器比较
           return comparator.compare(e1,e2);
        }
        // 没传比较器，元素内部必须自行实现了 Comparable 接口
        return ((Comparable<E>)e1).compareTo(e2);

    }
    // 检测传入的节点是否为空
    private void elementNotNullCheck(E element) {
        if (element == null) { // 不能传入空节点
            throw new IllegalArgumentException("element must not null");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentStr = "null";
        if(myNode.parent != null){
            parentStr = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentStr + ")";
    }

    public static class Node<E>{
        E element;//元素值
        Node<E> left;//左节点
        Node<E> right;//右节点
        Node<E> parent;//父节点
        public Node(E element,Node<E> parent){
            this.element=element;
            this.parent=parent;
        }
        public boolean isLeaf(){ //是否有叶子节点
            return left==null&& right==null;
        }
        public boolean hasTwoChildren(){//是否有俩个子节点
            return  left!=null&&right!=null;
        }
    }
}
