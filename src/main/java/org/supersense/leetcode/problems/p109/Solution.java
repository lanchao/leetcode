package org.supersense.leetcode.problems.p109;

import org.supersense.leetcode.problems.utils.ListNode;
import org.supersense.leetcode.problems.utils.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) prev.next = null;
        else head = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
    
    public TreeNode sortedListToBST_2(ListNode head) {
    	if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) prev.next = null;
        else head = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
