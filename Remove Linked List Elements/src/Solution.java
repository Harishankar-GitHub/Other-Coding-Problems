public class Solution {

    // Problem statement: https://leetcode.com/problems/remove-linked-list-elements/description/

    public static void main(String[] args) {
        ListNode listNode = removeElements(buildListNode(), 6);

        printListNodes(listNode);

        listNode = removeElements_another_solution(buildListNode(), 6);

        printListNodes(listNode);
    }

    public static ListNode removeElements(ListNode head, int val) {
        // Used another linkedList to add values except val.

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

    public static ListNode removeElements_another_solution(ListNode head, int val) {
        // Used same linkedList and de-referencing the node if it's value is equal to val.

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }

        return head;
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

    private static void printListNodes(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

        System.out.println();
    }
}
