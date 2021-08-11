/* 
	Solution 2
	
	Iterative Approach. Add the values to a stack until you reach the middle, then compare the stack
	values to the second half of the list.

	Note: A third recursive approach can be found in the book.
*/


/* 
	Time Complexity: O(n)
	Space Complexity: O(n)
*/

boolean isPalindrome(LinkedListNode head){
	LinkedListNode fast = head;
	LinkedListNode slow = head;

	Stack<Integer> stack = new Stack<Integer>();

	/* Push elements from the first half of the linked list onto the stack. When the fast runner
	 * (2x speed) reaches the end, we are at the middle */
	while(fast != null && fast.next != null){
		stack.push(slow.data);
		slow = slow.next;
		fast = fast.next.next;
	}

	/* has odd numbers of elements, so skip the middle element */
	if(fast != null){
		slow = slow.next;
	}

	while(slow != null){
		int top = stack.pop().intValue();

		/* if values are different, then it's not a palindrome */
		if(top != slow.data){
			return false;
		}
		slow = slow.next;
	}
	return true;
}