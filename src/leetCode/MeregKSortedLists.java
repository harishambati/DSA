package leetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import ds_models.ListNode;

public class MeregKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
	}
	
	

public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null){
        return null;
    }
	ListNode head = new ListNode();
	Queue<ListNode> ps = new PriorityQueue<>((p1, p2)-> Integer.compare(p1.val, p2.val));
	Set<ListNode> set = new HashSet<>();
	
	for(ListNode n : lists) 
    {
        if(n != null){
            ps.add(n);
        }
		
	}
	
	ListNode node = head;
	
	while(ps.size() > 0) 
	{
		
		ListNode temp = ps.remove();
		
		if(!set.contains(temp.next) && temp.next != null) 
        {
			ps.add(temp.next);
		}
		node.next = temp;
		node = node.next;
	}
	
	node.next = null;
	
	return head.next;
	
}

}