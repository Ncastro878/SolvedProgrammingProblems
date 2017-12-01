import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int stackA[] = new int[10];
    static int stackB[] = new int[10];
    static int szA = 0;
    static int szB = 0;
    static boolean b = false;  

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int queries = input.nextInt();
        for(int i = 0; i < queries; i++){
            int x = input.nextInt();
            if(x == 1){
                int y = input.nextInt();
                enqueue(y);
                //print();
            }else if(x == 2){
                dequeue();
                //print();
            }else{
                printFront();
            }
        }
    }
    public static void enqueue(int num){
            stackA[szA] = num;
            szA++;
            ensureCapacityA();
    }
    public static void dequeue(){
        if(szB ==0 && szA == 1){
            popA();
            
        }
        else if(b == false){
            while(szA != 0){
                stackB[szB] = popA();
                szB++;
                ensureCapacityB();
            }
            b = true;
            popB();
        }else{ // b = true
            popB();
            if(szB==0)b = false;
        }
    }
    public static void printFront(){
        if(b == true){
            System.out.println(stackB[szB - 1]);            
        }else{
            System.out.println(stackA[0]);    
        }
        
    }
    public static int popA(){
        szA--;
        return stackA[szA]; // +1 ?
    }
    public static int popB(){
        szB--;
        return stackB[szB]; // +1 ?
    }
    public static void ensureCapacityA(){
        if(szA  == stackA.length - 1){
            stackA = Arrays.copyOf(stackA, 2*stackA.length);
        }
    }
    public static void ensureCapacityB(){
        if(szB  == stackB.length - 1){
            stackB = Arrays.copyOf(stackB, 2*stackB.length);
        }
    }
    public static void print(){
        System.out.println(Arrays.toString(stackA) );
        System.out.println(Arrays.toString(stackB) + "\n" );
    }
}
