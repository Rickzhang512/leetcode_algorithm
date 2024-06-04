package DataStructure;

public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode t=head;
        while(t!=null){
            ListNode temp=t.next;
            t.next=prev;
            prev=t;
            t=temp;
        }

        return prev;
    }
}
