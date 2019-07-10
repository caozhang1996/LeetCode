package timu;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode上的链表，二叉树相关题目
 * */
public class TestLeetCode7 {
	public static void main(String[] args) {
		List<Integer> ans = new ArrayList<>();
	}
	
	/**
	 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	 * 
	 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 示例：
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 输出：7 -> 0 -> 8
	 * 原因：342 + 465 = 807
	 * */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 //返回指针
		ListNode pre = new ListNode(0);   //头指针
        ListNode curr = pre;              //两个节点指向同一地址
        
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = ((l1 == null)? 0 : l1.val) + ((l2 == null)? 0 : l2.val) + carry;
            carry = sum / 10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            l1 = (l1 == null)? l1 : l1.next;
            l2 = (l2 == null)? l2 : l2.next;
        }
        if(carry == 1)
            curr.next = new ListNode(1);
        
        return pre.next;
	}
	/*请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求
	 *被删除的节点。现有一个链表 -- head = [4,5,1,9]。
	 *
	 *示例 1:
	 *输入: head = [4,5,1,9], node = 5
	 *输出: [4,1,9]
	 *解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
	 *
	 *示例 2:
	 *输入: head = [4,5,1,9], node = 1
	 *输出: [4,5,9]
	 *解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
	 *
	 *说明:
	 *	链表至少包含两个节点。
	 *	链表中所有节点的值都是唯一的。
	 *	给定的节点为非末尾节点并且一定是链表中的一个有效节点。
	 *	不要从你的函数中返回任何结果。
	 * */
	public void deleteNode(ListNode node) {  //即删除该Node节点
		node.val = node.next.val;
		node.next = node.next.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x; 
		}
	}
