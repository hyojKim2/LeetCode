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
    public ListNode oddEvenList(ListNode head) {

        /**
        한번 스캔으로 끝내야하며, odd와 even 두 개 둬도 될듯. 
         */

        if(head==null){
            return null;
        }
        if(head.next==null || head.next.next==null){
            return head;
        }

        ListNode curr = head;
        ListNode odd = curr;
        ListNode even =  curr.next;
        ListNode oddFirst=head;
        ListNode evenFirst = head.next;
        curr=curr.next.next;
        int cnt=3;

        while(curr!=null){
            ListNode temp = curr.next;
            if(cnt%2 != 0){ //odd
                odd.next=curr;
                odd=curr;

            }else{  
                even.next=curr;
                even=curr;
            }
            curr=temp;
            cnt++;
        }

        odd.next=evenFirst;
        even.next=null;
        return oddFirst;
        
    }
}