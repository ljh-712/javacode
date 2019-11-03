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
        this.head = null;
    }

    /*
    头插法
     */
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        //判断头节点是否为空，也就head==null;
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    /*
    尾插法
     */
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    /*
    求链表的长度
     */
    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /*
    任意位置插入,第一个数据节点为0号下标
     */
    ////先要找到index-1的位置
    private ListNode searchIndex(int index) {
        ListNode pre = this.head;
        int count = 0;
        while (count < index - 1) {
            count++;
            pre = pre.next;
        }
        return pre;
    }

    public boolean addIndex(int index, int val) {
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
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /*
    删除第一次出现关键字为key的节点    
     */
    private ListNode searchprev(int val) {
        ListNode prev = this.head;
        while (prev != null) {
            if (prev.next.val == val) {
                return prev;
            }
            prev = prev.next;
        }
        return null;//没找到返回空
    }

    public void remove(int val) {
        //判断单链表是否为空
        if (this.head == null) {
            System.out.println("单链表为空");
            return;
        }//判断删除的是不是头节点
        if (this.head.val == val) {
            this.head = this.head.next;
        }
        //找到val的前驱
        ListNode prev = searchprev(val);
        ListNode del = prev.next;
        prev.next = del.next;
    }

    /*
    删除所有值为key的节点
     */
    public void removeAllKey(int val) {

        ListNode pre = this.head;
        ListNode cur = pre.next;

        while (cur != null) {
            if (pre.next.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
            //判断删除的是不是头节点
            if (this.head.val == val) {
                this.head = this.head.next;
            }
        }
    }

    /*
    打印链表
     */
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /*
    打印反转后的链表
     */
    public void display2(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /*
    反转链表
     */
    public ListNode reverseList() {
        ListNode cur = this.head;
        ListNode newHead = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return newHead;
    }

    /*
    返回链表的中间结点
     */
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /*
     输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode findKthToTail(int k) {
        //定义快慢引用，先让fast走k-1步，然后让它俩一起走，直到fast.next==null时，slow就是倒数第K个节点
        ListNode fast = this.head;
        ListNode slow = this.head;

        //先判断K是否合法
        if (k <= 0) {
            System.out.println("k不合法");
            return null;
        }
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /*
    将两个有序链表合并为一个新的有序链表并返回
     */
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        //定义一个虚拟节点
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                temp.next = headA;
                headA = headA.next;
                temp = temp.next;
            } else {
                temp.next = headB;
                headB = headB.next;
                temp = temp.next;
            }
        }
            if (headB != null) {
                temp.next = headB;
            }
            if (headA != null) {
                temp.next = headB;
            }
        return node.next;
    }
    /*
    以给定值x为基准将链表分割成两部分
     */
    public ListNode partition(int x) {
       ListNode cur=this.head;
       ListNode beforeStart=null;
       ListNode beforeEnd=null;
       ListNode afterStart=null;
       ListNode afterEnd=null;
       while(cur!=null) {
           if(cur.val<x) {
               //判断是不是第一次插入
               if(beforeStart==null) {
                   beforeStart=cur;
                   beforeEnd=beforeStart;
               }else {
                   beforeEnd.next=cur;
                   beforeEnd=beforeEnd.next;
               }
           }else {
               //判断是不是第一次插入
               if (afterStart == null) {
                   afterStart = cur;
                   afterEnd = afterStart;
               } else {
                   afterEnd.next = cur;
                   afterEnd = afterEnd.next;
               }
           }
           cur=cur.next;
       }
       if(beforeStart==null) {
           return afterStart;
       }
       beforeEnd.next=afterStart;
       if(afterStart!=null) {
           afterEnd.next = null;
       }
       return beforeStart;
    }
    /*
    删除该链表中重复的结点
     */
    public ListNode deleteDuplication() {
        ListNode cur=this.head;
        //定义一个虚拟节点
        ListNode node=new ListNode(-1);
        ListNode temp=node;
        while(cur!=null) {
            if(cur.next!=null&&cur.val==cur.next.val) {
                while(cur.next!=null&&cur.val==cur.next.val) {
                    cur=cur.next;
                }
                cur=cur.next;
            }
            else{
                temp.next=cur;
                cur=cur.next;
                temp=temp.next;
            }
        }
        temp.next=null;
        return node.next;

    }
    /*
    判断回文
     */
    public boolean chkPalindrome() {
        ListNode fast = this.head;
        ListNode slow = this.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next = slow;

            slow = p;
            p = pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while (slow != head) {
            if (slow.val != head.val) {
                return false;
            }
            if (slow == head.next) {
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    /*
    找到两个单链表相交的起始节点
     */
    public static ListNode  getIntersectionNode(ListNode headA,ListNode headB){
        if (headA == null||headB==null) {

            return null;
        }
        ListNode pL=headA;
        ListNode pS=headB;
        int lenA=0;
        //两个链表的长度
        int lenB=0;
        ListNode cur1=headA;
        //定义一个临时变量代替head,防止它求长度时跑到链表尾部
        ListNode cur2=headB;
        while(cur1!=null) {
            lenA++;
            cur1=cur1.next;
        }
        while(cur2!=null) {
            lenB++;
            cur2=cur2.next;
        }
        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }
        while(len>0) {
            pL= pL.next;
            len--;

        }
        while(pL!=pS&&pL!=null) {
            pL= pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null) {
            return  pL;
        }
        return null;

    }
    /*
    判断一个链表是否有环
     */
    public boolean hasCycle() {
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(slow!=fast) {
            if(fast==null||fast.next==null) {
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
    /*
    返回链表开始入环的第一个节点
     */
    public ListNode detectCycle() {
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(true) {
            if(fast==null||fast.next==null) {
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                break;
            }
        }
        fast=head;
        while(fast!=slow) {
            fast=fast.next;
            slow=slow.next;
        }
        return  fast;

}
public class Test {
    public  static void main(String[] args) {
        SignalList list1=new SignalList();
        SignalList list=new SignalList();
        list1.addLast(421);
        list1.addLast(305);
        list1.addLast(13);
        list1.addLast(425);
        list1.addLast(222);
        list1.addLast(609);
        list1.addLast(100);
        list1.addLast(131);
        list1.addLast(579);
        list1.addLast(579);
        list1.addLast(131);
        list1.addLast(100);
        list1.addLast(609);
        list1.addLast(222);
        list1.addLast(425);
        list1.addLast(13);
        list1.addLast(305);
        list1.addLast(421);




        list1.display();
        System.out.println(list1.chkPalindrome());

//        list.addFirst(2);
//        list.addFirst(4);
//        list.addFirst(35);
//        list.addFirst(21);
//        list.display();



//         ListNode head=list1.reverseList();
//         list1.display2(head);
//        ListNode cur=list1.middleNode();
//        ListNode r=list1.findKthToTail(1);
//        System.out.println(r.val);
//
//        System.out.println(cur.val);
//        list1.removeAllKey(2);
//        list1.display();
//
//        list1.display();

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
