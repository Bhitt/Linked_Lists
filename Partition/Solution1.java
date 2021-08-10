/* 
	Solution 1 
	
	Create two different lists: one for elements less than x, and one for elements greater than or
	equal to x. Iterate through the original list and add the elements to the respective new list.
	Then, combine the two lists.

	This approach is stable (as most elements stay in their original order), however there is also a
	solution that instead creates a list where it grows from the head and tail instead.
*/


/* 
	Time Complexity: O(n)
	Space Complexity: O(n)
*/

/* Pass in the head of the linked list and the value to partition around */
LinkedListNode partition(LinkedListNode node, int x){
	LinkedListNode beforeStart = null;
	LinkedListNode beforeEnd = null;
	LinkedListNode afterStart = null;
	LinkedListNode afterEnd = null;

	/* Partition list */
	while (node != null){
		LinkedListNode next = node.next;
		node.next = null;
		if(node.data < x){
			/* insert node into end of before list */
			if(beforeStart == null){
				beforeStart = node;
				beforeEnd = beforeStart;
			} else {
				beforeEnd.next = node;
				beforeEnd = node;
			}
		} else {
			/* insert node into end of after list */
			if(afterStart == null){
				afterStart = node;
				afterEnd = afterStart;
			} else {
				afterEnd.next = node;
				afterEnd = node;
			}
		}
		node = next;
	}

	if(beforeStart == null){
		return afterStart;
	}

	/* merge before list and after list */
	beforeEnd.next = afterStart;
	return beforeStart;
}