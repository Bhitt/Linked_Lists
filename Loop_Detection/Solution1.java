/* 
	Solution 1 
	
	1. Create two pointers, Fast and Slow
	2. Move Fast at twice the speed
	3. When they collide, move Slow to the head
	4. Move Fast and Slow at a rate of one step. Return the collision point.
*/


/* 
	Time Complexity: 
	Space Complexity: O(1) 
*/

LinkedListNode FindBeginning(LinkedListNode head){
	LinkedListNode slow = head;
	LinkedListNode fast = head;

	/* find the meeting point. This will be LOOP_SIZE - k steps in the list */
	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
		if(slow == fast) { //collision
			break;
		}
	}

	/* error check for no loop */
	if(fast == null || fast.next == null){
		return null;
	}

	/* Move slow to head. Each are k steps from the loop start */
	slow = head;
	while(slow != fast){
		slow = slow.next;
		fast = fast.next;
	}

	/* both now point to the start of the loop */
	return fast;
}