package DataStructure;
import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    int val;
    LinkedList next;
    LinkedList(int val) {
        this.val = val;
    }
    LinkedList(int val, LinkedList next) {
        this.val = val; this.next = next;
    }
    LinkedList(int []val){

    }

    //Traverse
    public static void printLinkedList(LinkedList head) {
        LinkedList current = head;
        while(current!= null) {
            System.out.println(current.val + "");
            current=current.next;
        }
        System.out.println();
    }







    public static void main(String[] args) {

    }
}
