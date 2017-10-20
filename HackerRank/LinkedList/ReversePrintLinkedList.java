/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
  adjustment
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
public int stack[] = new int[10];
public int sz = 0;

void ReversePrint(Node head) {
  // This is a "method-only" submission. 
  // You only need to complete this method.
    Node pointer = head;
    if(head == null){
        return;
        
    }
    while(pointer.next != null){
        push(pointer.data);
        pointer = pointer.next;
    }
    push(pointer.data);
    
    for(int i = sz -1; i >= 0; i--){
        System.out.println(stack[i]);
    }
    
}
void push(int num){
    stack[sz] = num;
    sz++;
    if(sz == stack.length-1){
        increaseStack();
    }
}
void increaseStack(){
    stack = Arrays.copyOf(stack, 2*stack.length);
}
