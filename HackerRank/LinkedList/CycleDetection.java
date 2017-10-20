/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if(head == null) return false;
    Node behind = head;
    Node front = head.next;
    
    while(front.next != null){
        if(front == behind){
            return true;
        }
        front = front.next.next;
        behind = behind.next;
        
    }
    return false;

}
