package Linked_list_singly;

public class Search_in_LL   {
    private static Node convertToLl(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static int searchInLL(int val, Node head) {
        Node temp = head;

        while(temp != null) {
            if(temp.data == val) return 1;
            temp = temp.next;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = convertToLl(arr);
        int val = 1;
        System.out.println(searchInLL(val,head));
    }
}
