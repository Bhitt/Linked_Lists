/* 
	Solution 2 
	
	Similar to the first solution but a recursive approach.
*/


/* 
	Time Complexity: O(N) time, where N is the number of elements in the linked list.
	Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    ListNode newHead;
    
    public ListNode ReverseList(ListNode head) {
        // Empty List
        if(head == null || head.next == null) return head;
        
        return reverseUtil(head, null);
    }
    
    ListNode reverseUtil(ListNode curr, ListNode prev){
        /* If last node, mark it as the head */
        if(curr.next == null){
            newHead = curr;
            
            // Update next to prev node
            curr.next = prev;
            
            return newHead;
        }
        
        // Save curr.next for recursive call
        ListNode next1 = curr.next;
        
        curr.next = prev;
        
        reverseUtil(next1, curr);
        return newHead;
    }
}

/*
	LEETCODE RESULTS

	Runtime: 88 ms, faster than 89.30% of C# online submissions for Reverse Linked List.
    Memory Usage: 25.5 MB
*/