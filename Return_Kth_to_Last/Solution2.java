/* 
	Solution 2
	
	Iterative solution
	Use two pointers, p1 and p2. We place them k nodes apart in the linked list by putting p2 at the
	beginning and moving p1 k nodes into the list. Then, when we move them at the same pace, p1 will
	hit the end of the linked list after LENGTH - k steps. At that point, p2 will be LENGTH - k nodes
	into the list, or k nodes from the end.
*/


/* 
	Time Complexity: O(n)
	Space Complexity: O(1)
*/

LinkedListNode nthToLast(LinkedListNode head, int k){
	LinkedListNode p1 = head;
	LinkedListNode p2 = head;

	/* move p1 k nodes into the list */
	for( int i=0; i<k; i++){
		if(p1 == null) return null; // out of bounds
		p1 = p1.next;
	}

	/* move them at the same pace. When p1 hits the end, p2 will be at the right element */
	while(p1 != null){
		p1 = p1.next;
		p2 = p2.next;
	}
	return p2;
}