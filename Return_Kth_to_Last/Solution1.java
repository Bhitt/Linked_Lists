/* 
	Solution 1 
	
	Recursive solution
	This method recurses through the list. When it reaches the end, the method passes back a counter
	set to 0. Each parent call adds 1 to this counter. When the counter equals k, we know we have
	reached the kth to last element. Compared to an iterative solution, this runs in almost half the
	time, but uses more space.

	Note: This implementation doesn't return the value, and only prints the kth to last element.
	If you were using C++, you could pass values by reference. This allows us to return the node
	value, but also update the counter by passing a pointer to it. A third approach would be to create
	a wrapper class to pass both pieces of data (counter and index).
*/


/* 
	Time Complexity: O(n)
	Space Complexity: O(n)
*/

int printKthToLast(LinkedListNode head, int k){
	if(head == null){
		return 0;
	}
	int index = printKthToLast(head.next, k) + 1;
	if(index == k){
		System.out.println(k + "th to last node is " + head.data);
	}
	return index;
}