public class Program {

    // https://leetcode.com/problems/merge-two-sorted-lists/

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

        buildListNodeOne(list1);
        buildListNodeTwo(list2);

        ListNode mergedList = mergeTwoLists(list1, list2);

        while (mergedList != null) {
            System.out.print(mergedList.val);
            mergedList = mergedList.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergedList = new ListNode(0);
        ListNode curr = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // when list1 or list2 have more elements than the other one,
        // below condition handles that.

        curr.next = list1 == null ? list2 : list1;
        return mergedList.next;
    }
    
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static void buildListNodeOne(ListNode list1) {
        list1.val = 1;
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
    }

    private static void buildListNodeTwo(ListNode list2) {
        list2.val = 1;
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
    }
}
