package org.xbp.algorithm.category._06_二叉搜索树;

import java.util.Comparator;

/**
 * Created on 2021/8/30.
 *
 * @author xuebaopeng
 * Description
 */
public class Main {
    public static class PersonComparator implements Comparator<Person> { // 比较器
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }
    public static class PersonComparator2 implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    // Integer类型的数据
    public static void test1(){
        Integer date[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < date.length; i++) {
            bst.add(date[i]);
        }
        BinaryTrees.println(bst);
    }
    // Person类型的数据
    public static void test2(){
        // Java，匿名类
        BinarySearchTree<Person> bst = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person e1, Person e2) {
                return e1.getAge() - e2.getAge();
            }
        });
        Integer date[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        for (int i = 0; i < date.length; i++) {
            bst.add(new Person(date[i]));
        }
        BinaryTrees.println(bst);
    }
    // 保存打印结果
    public static void test3(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i = 0; i < 40; i++){
            bst.add((int)(Math.random()*100));
        }
        String string = BinaryTrees.printString(bst);
        string += "\n";
        Files.writeToFile("/Users/xuebaopeng/java_workspace/1.txt", string);
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
