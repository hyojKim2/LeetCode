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
    public int pairSum(ListNode head) {

        if(head.next.next==null){
            return head.val + head.next.val;
        }


        // 먼저 리스트 전체 크기를 구해 뒤쪽 반절을 분리한다. 
        ListNode part =null;
        ListNode curr= head;
        ListNode first=null;
        int cnt=1;
        while(curr!=null){
            ListNode temp  =curr.next;
            curr=temp;
            cnt++;
            if(temp!=null)
             first=temp;
        }
        int mid = cnt/2;
        cnt=1;
        
        ListNode partFirst= head;
        while(cnt<mid){
            ListNode temp  =partFirst.next;
            partFirst=temp;
            cnt++;
        }
    
        part = partFirst.next;
        partFirst.next=null;

        //뒤쪽 반절을 reverse
        ListNode prev = null;
        curr =part;
        while(curr!=null){
            ListNode temp  =curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        int max= 0;
        cnt=0;
        curr=head;
        part=first;
        while(cnt<mid && (curr!=null) ){
            int sum = curr.val + part.val;
            if(max  <  sum){
                max=sum;
            }
            ListNode currT = curr.next;
            ListNode partT = part.next;
            curr=currT;
            part =partT;
            cnt++;
        }
        return max;


        
    }
}