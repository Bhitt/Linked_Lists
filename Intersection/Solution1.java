/* 
	Solution 1 
	
	1. Run through each linked list to get the lengths and tails.
	2. Compare the tails. If they are different (by reference), no intersection.
	3. Set two pointers at the start of the lists.
	4. On the longer list, advance forward the difference in lengths.
	5. Now, traverse on each linked list until the pointers are the same.
*/


/* 
	Time Complexity: O(A+B), where A and B are the lengths of the two lists
	Space Complexity: O(1)
*/

LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2){
	if(l1 == null || l2 == null) return null;

	/* Get tails and sizes */
	Result result1 = getTailAndSize(l1);
	Result result2 = getTailAndSize(l2);

	/* if different tail nodes, no intersection */
	if(result1.tail != result2.tail){
		return null;
	}

	/* Set pointers to the start of both lists */
	LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
	LinkedListNode longer = result1.size < result2.size ? l2 : l1;

	/* advance the pointer for the longer list by the difference in lengths */
	longer = getKthNode(longer, Math.abs(result1.size - result2.size));

	/* move both pointers until you have a collision */
	while(shorter != longer){
		shorter = shorter.next;
		longer = longer.next;
	}

	/* return either one */
	return longer;
}

class Result{
	public LinkedListNode tail;
	public int size;
	Public Result(LinkedListNode tail, int size){
		this.tail = tail;
		this.size = size;
	}
}

Result getTailAndSize(LinkedListNode list){
	if(list == null) return null;

	int size = 1;
	LinkedListNode current = list;
	while(current.next != null){
		size++;
		current = current.next;
	}
	return new Result(current, size);
}

LinkedListNode getKthNode(LinkedListNode head, int k){
	LinkedListNode current = head;
	while(k > 0 && current != null){
		current = current.next;
		k--;
	}
	return current;
}