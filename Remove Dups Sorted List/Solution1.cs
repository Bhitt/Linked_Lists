  /* 
    Solution 1 
    
    Use three pointers: slow, fast, and lastValid. Iterate through the list with fast and if you 
    find that there was only one node of a value, copy that value to slow and iterate slow forward
    one. The pointer lastValid is used for cases where there are only duplicates, or the last node
    in the list was a duplicate.
*/

/* 
    Time Complexity: O(n) 
    Space Complexity: O(1)
*

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
    public ListNode DeleteDuplicates(ListNode head) {
        // 0 or single node list
        if(head == null || head.next == null) return head;
        
        // current count and current value
        int currentVal = head.val;
        int count = 1;
        
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode lastValid = null;
        
        while(fast != null){
            if(fast.val == currentVal) count++; // Same value
            else { // New Value
                if(count > 1){
                    // Duplicates found on previous value
                    count = 1;
                } else {
                    // Single element for previous, write to front
                    slow.val = currentVal;
                    lastValid = slow;
                    slow = slow.next;
                }
                currentVal = fast.val;
            }
            fast = fast.next;
        }
        // Check final node
        if(count  == 1){
            slow.val = currentVal;
            slow.next = null;
            lastValid = slow;
        } else {
            if(lastValid != null){
                lastValid.next = null;
            }
        }
        
        if(lastValid == null){
            return null;
        }
        return head;
    }
}

/*
    LEET CODE RESULTS

    Runtime: 88 ms, faster than 95.45% of C# online submissions for Remove Duplicates from Sorted 
        List II.
    Memory Usage: 26.3 MB, less than 69.83% of C# online submissions for Remove Duplicates from 
        Sorted List II.
*/