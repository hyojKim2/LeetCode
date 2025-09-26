/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        /**
        2개의 인덱스 slow, fast를 두고 각각 1칸, 2칸씩 이동하기 */

        // 
        if(head==null || head.next==null){
            return null;

        }

        //size가 2
        if(head.next.next==null){
            head.next=null;
            return head;
        }
        

        //slow, fast
        ListNode slow=head, fast= head;

        while(fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;

        }

        slow.val=slow.next.val;
        slow.next=slow.next.next;

        return head;


        // /**
        // 먼저 연결리스트 전체 크기를 구한다. 
        //  */

        // int midIdx=0;
        // int size=0;
        // ListNode curr=head;

        // while(curr!=null){
        //     curr=curr.next;
        //     size++;
        // }
        
        // midIdx=size/2;

        // curr=head;
        // int cnt =0;

        // if(midIdx==0){
        //     return null;
        // }
        // while(curr!=null){
        //     if(cnt==midIdx-1){
        //         curr.next=curr.next.next;
        //     }

        //     curr=curr.next;

        //     cnt++;
            
        // }


        // return head;
        
    }
}