/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.*;

/*IsInteger()는 리스트가 하나의 정수만 가지고 있는지 반환
getInteger는 리스트가 하나의 정수만 가지고 있을 때 그 정수를 반환, 리스트 hold 시 null반환
getList는 리스트가 nestedList 가지고 잇을 때 그 리스트를 반환 


*/
public class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {//
        addInteger(nestedList);
    }

    private Queue<Integer> q=new ArrayDeque<>(); //큐 선언

    private void addInteger(List<NestedInteger> nestedList){

        for(NestedInteger ne: nestedList){
            if(ne.isInteger()) //ne가 정수면 큐에 넣어줌
                q.offer(ne.getInteger());
            else //ne가 리스트면 ne에 대해 addInteger
                addInteger(ne.getList());    
            
        }

    }

    //만들어진 q에 대하여 아래 두 메서드로 res를 생성할 수 있게 코드 작성. 
    @Override
    public Integer next() { //q의 처음 원소 반환 및 삭제
        return q.poll();
    }

    @Override
    public boolean hasNext() { //q가 비지 않았는지 검사
        return !q.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */