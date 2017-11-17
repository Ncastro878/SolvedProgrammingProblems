import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
        static int heap[];
        static int sz = 0;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int num_queries = input.nextInt();
        heap = new int[num_queries];
        
        int lister[] = new int[num_queries];
        for(int i = 0; i < num_queries; i++){
            int k = input.nextInt();
            if(k == 1){
                int num = input.nextInt();
                addNode(num);
                //printMe();
            }
            if(k == 2){
                int num = input.nextInt();
                deleteNode(num);
            }
            if(k == 3){
                peekMin();
            }
        }
    }
    public static void addNode(int num){
        heap[sz] = num;
        sz++;
        heapifyUp(sz - 1);
    }
    public static void deleteNode(int num){
        int index = findIndex(num);
        swap(index, sz-1);
        sz--;
        int parent = getParentIndex(index);
        if(heap[index] < heap[parent]) 
            heapifyUp(index);
        else{
            heapifyDown(index);
        }
    }
    public static void peekMin(){
        System.out.println(heap[0]);
    }
    public static void heapifyUp(int n){
        int index = n;
        int parent = getParentIndex(index);
        while(heap[parent] > heap[index]){
            swap(index, parent);
            index = parent;
            parent = getParentIndex(index);
        }
    }
    public static void heapifyDown(int n){
        int index = n;
        int smallest = index;
        int leftChild = index*2+1;
        int rightChild = index*2+2;
        /* This is the hard part */
        while(leftChild < sz ){
            if(rightChild < sz && heap[rightChild] < heap[leftChild])
                smallest = rightChild;
            else if(rightChild < sz && heap[leftChild] < heap[rightChild])
                smallest = leftChild;
            else
                smallest = leftChild;
            if(heap[index] > heap[smallest]){
                swap(index, smallest);
                index = smallest;
                leftChild = index*2+1;
                rightChild = index*2+2;  
            }else{
                break;
            }
        }
    }
    public static int getParentIndex(int n){
        return (n-1)/2;
    }
    public static void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    public static void printMe(){
        System.out.println(Arrays.toString(heap));
    }
    public static int findIndex(int num){
        int value = 0;
        for(int i = 0; i < sz; i++){
            if(heap[i] == num)
                value = i;
        }
        return value;
    }
        

}
