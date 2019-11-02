/**
 * @author :Administrator.
 * @date :2019/11/2 0002
 * @time:17:17
 */
/*
以节点为单位存储，不支持随机访问
所有：1.任意位置插入删除时间复杂度为O(1) 2.没有增容问题，插入一个开辟一个空间。
不带头结点的非循环单链表
 */
class ListNode {//节点类
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.next=null;
        this.val=val;

    }
}
class SignalList {//单链表类
    public ListNode head;

    public SignalList() {
        this.head=null;
    }
    /*
    头插法
     */
    public void addFirst(int val) {
        ListNode node=new ListNode(val);
        //判断头节点是否为空，也就head==null;
        if (this.head == null) {
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }
    /*
    尾插法
     */
    public void addLast(int val) {
        ListNode node=new ListNode(val);
        ListNode cur=this.head;
        if(this.head==null) {
            this.head=node;
        }else {
            while(cur.next!=null) {
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    /*
    求链表的长度
     */
    public int getLength() {
        ListNode cur=this.head;
        int count=0;
        while(cur!=null) {
            count++;
            cur=cur.next;
        }
        return count;
    }
    /*
    任意位置插入,第一个数据节点为0号下标
     */
    ////先要找到index-1的位置
    private ListNode searchIndex(int index) {
        ListNode pre=this.head;
        int count=0;
        while(count<index-1) {
            count++;
            pre=pre.next;
        }
        return pre;
    }
    public boolean addIndex(int index,int val) {
        ListNode cur = this.head;
        //先要找到index-1的位置
        //判断index是否合法index<0||index>getLength()
        if (index < 0 || index > getLength()) {
            System.out.println("index不合法");
            return false;
        }
        //如果index=0;头插法
        if (index == 0) {
            addFirst(val);
            return true;
        } else {
            ListNode pre = searchIndex(index);
            ListNode node = new ListNode(val);
            node.next = pre.next;
            pre.next = node;
        }
        return true;
    }
    /*
    查找是否包含关键字key是否在单链表当中
     */
    public boolean contains(int val) {
        ListNode cur=this.head;
        while(cur!=null) {
            if(cur.val==val) {
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    /*
    删除第一次出现关键字为key的节点    
     */
    private ListNode searchprev(int val) {
        ListNode prev=this.head;
        while(prev!=null) {
            if(prev.next.val==val) {
                return prev;
            }
            prev=prev.next;
        }
        return null;//没找到返回空
    }
    public void remove(int val) {
        //判断单链表是否为空
        if(this.head==null) {
            System.out.println("单链表为空");
            return;
        }//判断删除的是不是头节点
        if(this.head.val==val) {
            this.head=this.head.next;
        }
        //找到val的前驱
        ListNode prev=searchprev(val);
        ListNode del= prev.next;
        prev.next=del.next;
    }
    /*
    删除所有值为key的节点
     */
    public void removeAllKey(int val) {

        ListNode pre=this.head;
        ListNode cur=this.head.next;

        while(cur!=null) {
            if(pre.next.val==val) {
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=pre.next;
                cur=cur.next;
            }
            if(this.head.val==val) {
                this.head = this.head.next;
            }
        }
    }
    /*
    打印链表
     */
    public void display() {
        ListNode cur=this.head;
        while(cur!=null) {
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }


}
public class Test {
    public static void main(String[] args) {
        SignalList list1=new SignalList();
        SignalList list=new SignalList();
        list1.addFirst(1);
        list1.addFirst(2);
        list1.addFirst(2);
        list1.addFirst(2);

        list1.display();
        list1.removeAllKey(2);
        list1.display();

        list1.display();
        
//        System.out.println(list1.addIndex(2,3));
//        list1.display();
//        System.out.println(list1.contains(1));
//        list1.remove(1);
//        list1.display();
//        //System.out.println(list1.getLength());
//        list.addLast(1);
//        list.addLast(1);
//        list.display();
    }
}
