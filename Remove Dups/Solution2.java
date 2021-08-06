/* 
	Solution 2 
	
	Follow Up: No Buffer Allowed

	If we don't have a buffer, we can iterate with two pointers: current which iterates through the
	linked list, and runner which checks all subsequent nodes for duplicates.
*/


/* 
	Time Complexity: O(N^2)
	Space Complexity: O(1)
*/

void deleteDups(LinkedListNode head){
	LinkedListNode current = head;
	while(current != null){
		/* Remove all future nodes that have the same value */
		LinkedListNode runner = current;
		while(runner.next != null){
			if(runner.next.data == current.data){
				runner.next = runner.next.next;
			} else {
				runner = runner.next;
			}
		}
		current = current.next;
	}
}