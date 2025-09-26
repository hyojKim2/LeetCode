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
        먼저 연결리스트 전체 크기를 구한다. 
         */

        int midIdx=0;
        int size=0;
        ListNode curr=head;

        while(curr!=null){
            curr=curr.next;
            size++;
        }
        
        midIdx=size/2;

        curr=head;
        int cnt =0;

        if(midIdx==0){
            return null;
        }
        while(curr!=null){
            if(cnt==midIdx-1){
                curr.next=curr.next.next;
            }

            curr=curr.next;

            cnt++;
            
        }


        return head;
        
    }
}