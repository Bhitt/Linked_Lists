/* 
    Solution 1 
    
    Iterate through the list, keeping track of current, prev, and next.
        1) set next equal to current.next
        2) point current.next at the previous node
        3) set previous equal to current
        4) set current equal to next

    Once you reach the end of the list, set the head equal to previous and return head
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
    public ListNode ReverseList(ListNode head) {
        // Empty List
        if(head == null || head.next == null) return head;
        
        // Iterative Solution
        ListNode prev = null, current = head, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // Set new head
        head = prev;
        // Return final result
        return head;
    }
}

/*
    LEET CODE RESULTS

    Runtime: 92 ms, faster than 72.50% of C# online submissions for Reverse Linked List.
    Memory Usage: 25 MB, less than 81.21% of C# online submissions for Reverse Linked List.
*/