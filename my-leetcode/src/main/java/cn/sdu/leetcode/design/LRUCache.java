package cn.sdu.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 *
 * @author icatzfd
 * Created on 2020/7/20 16:51.
 */
public class LRUCache {

    Map<Integer, LinkedNode> map;
    int size;
    LinkedNode dummyHead;
    LinkedNode dummyTail;

    public LRUCache(int capacity) {
        dummyHead = new LinkedNode(-1,-1);
        dummyTail = new LinkedNode(0,0);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        map = new HashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        LinkedNode node=map.get(key);
        if(node==null){
            return -1;
        }
        deleteNode(node);
        addNode(node);
        return node.val;


    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LinkedNode node=getNode(key);
            deleteNode(node);
            addNode(node);
            map.put(key,node);
        }else {
            if(map.size()==size){
                LinkedNode delNode=dummyTail.pre;
                deleteNode(delNode);
                map.remove(delNode.val);
            }
            LinkedNode node=new LinkedNode(value,key);
            addNode(node);
            map.put(key,node);

        }

    }

    void addNode(LinkedNode node){
        LinkedNode next=dummyHead.next;
        dummyHead.next=node;
        node.pre=dummyHead;
        node.next=next;
        next.pre=node;
    }

    void deleteNode(LinkedNode node){
        LinkedNode temp=node.pre;
        temp.next=node.next;
        node.next.pre=temp;
        node.pre=null;
        node.next=null;

    }

    LinkedNode getNode(int key){
        LinkedNode cur=dummyHead.next;
        while (cur!=null){
            if(cur.val==key){
                break;
            }
            cur=cur.next;
        }
        return cur;
    }

    class LinkedNode {
        int key;
        int val;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode(int val,int key) {
            this.key=key;
            this.val = val;
        }
    }
}
