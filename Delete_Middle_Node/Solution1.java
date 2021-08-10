/* 
	Solution 1 
	
	Copy the data from the next node over to the current node. Then delete the next node.
	Note: This solution would not work if you wanted to delete the last node in the list.
*/


/* 
	Time Complexity: O(1)
	Space Complexity: O(1)
*/


boolean deleteNode(LinkedListNode n){
	if(n == null || n.next == null){
		return false; // Failure
	}
	LinkedListNode next  = n.next;
	n.data = next.data;
	n.next = next.next;
	return true;
}