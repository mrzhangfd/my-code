package cn.sdu.jzoffer;

import cn.sdu.ListNode;

/**
 * @author icatzfd
 * Created on 2020/9/6 14:47.
 */
public class test {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ListNode head=node1;
        ListNode cur=head;
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        System.out.println(cur.val);
    }
    public static int val(){
        int num=5;
        try {
            num=num/0;
            return num;
        }catch (Exception e){
            num=10;
            return num;
        }finally {
            num=15;
            return num;
        }
    }
}
