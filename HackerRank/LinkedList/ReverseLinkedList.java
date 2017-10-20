/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  } 
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
Node Reverse(Node head) {

    Node current = head;
    Node h1 = head;
    Node prev = null;
    Node next = current.next;
    if(current == null) return null;
    if(next == null) return head;
    
    while(next != null){
        prev = current;
        current = next;
        next = next.next;
        current.next = prev;
    }
    h1.next = null;
    return current;  
}
