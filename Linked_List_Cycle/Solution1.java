/* 
	Solution 1 
	
	Using the "runner technique", we have two pointers moving at 1 step and 2 steps respectively. If
	there is a cycle, they will meet up and point at the same node. Otherwise, the faster pointer
	will reach the end of the linked list.
*/


/* 
	Time Complexity: O(n), only one traversal of the loop
	Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        //Check null case
        if(head == null) return false;
        
        // Runner Technique
        ListNode slow = head;
        ListNode fast = head;
    
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true; // Found cycle
        }
        
        // No cycle found
        return false;
    }
}

/*
	LEETCODE RESULTS

	Runtime: 1 ms, faster than 26.85% of Java online submissions for Linked List Cycle.
	Memory Usage: 42.9 MB, less than 11.08% of Java online submissions for Linked List Cycle.
*/