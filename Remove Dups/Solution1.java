/* 
	Solution 1 
	
	In order to remove duplicates, you must track duplicates. A simple hash table will work here.
*/


/* 
	Time Complexity: O(N) time, where N is the number of elements in the linked list.
	Space Complexity: O(N)
*/

void deleteDups(LinkedListNode n){
	HashSet<Integer> set = new HashSet<Integer>();
	LinkedListNode previous = null;
	while(n != null){
		if(set.contains(n.data)){
			previous.next = n.next;
		} else {
			set.add(n.data);
			previous = n;
		}
		n=n.next;
	}
}
