/* 
	Solution 1 
	
	Reverse and Compare. Note that when we compare the linked list to the reversed list, we only
	actually need to compare the first half of the list. If the first half if the normal list matces
	the first half of the reversed list, then the second half of the normal list must match the second
	half of the reversed list.
*/


/* 
	Time Complexity: O(n), where n is the length of the linked list
	Space Complexity: O(n)
*/

boolean isPalindrome(LinkedListNode node){
	LinkedListNode reversed = reverseAndClone(head);
	return isEqual(head, reversed);
}

LinkedListNode reverseAndClone(LinkedListNode node){
	LinkedListNode head = null;
	while(node != null){
		LinkedListNode n = new LinkedListNode(node.data); // Clone
		n.next = head;
		head = n;
		node = node.next;
	}
	return head;
}

boolean isEqual(LinkedListNode one, LinkedListNode two){
	while(one != null && two != null){
		if(one.data != two.data){
			return false;
		}
		one = one.next;
		two = two.next;
	}
	return one == null && two == null;
}