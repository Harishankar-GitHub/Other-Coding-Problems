public class Solution {

    // Problem statement: https://leetcode.com/problems/remove-linked-list-elements/description/

    public static void main(String[] args) {
        ListNode listNode = removeElements(buildListNode(), 6);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode currentNode = head;
        ListNode result = new ListNode(0);
        ListNode resultHead = result;

        while (currentNode != null) {
            if (currentNode.val != val) {
                result.next = new ListNode(currentNode.val);
                result = result.next;
            }

            currentNode = currentNode.next;
        }

        return resultHead.next;
    }

    private static ListNode buildListNode() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode six = new ListNode(6);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode anotherSix = new ListNode(6);

        one.next = two;
        two.next = six;
        six.next = three;
        three.next = four;
        four.next = five;
        five.next = anotherSix;

        return one;
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
