//원형 리스트

import java.util.*;

class Solution {

    //연결리스트 노드 클래스 선언 
    public static class Node { 
        private int val;
        private Node next;

        public Node(int n){ //생성자
            this.val=n;
            this.next=null;
        }

    }

    public int findTheWinner(int n, int k) {
        
        Node newNode = new Node(1);
        Node last = newNode; //연결리스트 last포인터 

        for(int i=2;i<=n;i++){ //연결리스트 초기화 
            Node tempNode= new Node(i);
            last.next=tempNode;
            last=tempNode;
        }

        //현재 last포인터를 1로 옮겨줌 
        last.next=newNode;
        last=newNode;
        
        int cnt=1;
        Node prevNode=last; 

        if(k==1) //얼리리턴 
            return n;

        while(last.next!=last ){ //연결리스트의 노드가 하나만 존재할때까지 반복
            if(cnt==k){
                prevNode.next=last.next;
                last=last.next;
                cnt=1;
            }    
            else{
                prevNode=last;
                cnt++;
                last=last.next;
            }

        }

        return last.val;
    }

}