import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Problem statement: https://leetcode.com/problems/intersection-of-two-linked-lists/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
 }

    public static void main(String[] args) {
        List<ListNode> listNodes = buildListNode();

        ListNode intersectionNode = getIntersectionNode(listNodes.get(0), listNodes.get(1));
        System.out.println("Intersected at node: " + intersectionNode.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visitedNodes = new HashSet<>();

        while (headA != null) {
            visitedNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visitedNodes.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    private static List<ListNode> buildListNode() {
        ListNode aFour = new ListNode(4);
        ListNode aOne = new ListNode(1);

        ListNode bFive = new ListNode(5);
        ListNode bSix = new ListNode(6);
        ListNode bOne = new ListNode(1);

        ListNode commonEight = new ListNode(8);
        ListNode commonFour = new ListNode(4);
        ListNode commonFive = new ListNode(5);

        aFour.next = aOne;
        aOne.next = commonEight;

        bFive.next = bSix;
        bSix.next = bOne;
        bOne.next = commonEight;

        commonEight.next = commonFour;
        commonFour.next = commonFive;

        return List.of(aFour, bFive);
    }
}
