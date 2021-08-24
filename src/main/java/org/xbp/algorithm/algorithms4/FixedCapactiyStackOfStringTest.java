//package org.xbp.algorithm.algorithms4;
//
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//
//public class FixedCapactiyStackOfStringTest {
//
//
//    public static void main(String[] args) {
//
//        FixedCapactiyStackOfString s=new FixedCapactiyStackOfString(100);
//        while (!StdIn.isEmpty()){
//            String item=StdIn.readString();
//            if (!item.equals("-")){
//                s.push(item);
//            }else if (!s.isEmpty()) StdOut.print(s.pop()+ " ");
//        }
//        StdOut.println("(" +s.size() +"left on stack)");
//
//    }
//
//    static class FixedCapactiyStackOfString{
//        private String [] a;//stack entries
//        private int N;
//
//        public FixedCapactiyStackOfString(int cap) {
//            a=new String[cap];
//        }
//        public boolean isEmpty(){
//            return N==0;
//        }
//        public int size(){
//            return N;
//        }
//        public void push(String item){
//            a[N++]=item;
//        }
//        public String pop(){
//            return a[N--];
//        }
//    }
//}
