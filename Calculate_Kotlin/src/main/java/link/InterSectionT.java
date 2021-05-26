package link;


public class InterSectionT {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode tA = headA;
            ListNode tB = headB;
            while (tA != tB) {
                if (tA != null)
                    tA = tA.next;
                else
                    tA = headB;

                if (tB != null)
                    tB = tB.next;
                else
                    tB = headA;
            }

            return tA;
        }
    }
}
