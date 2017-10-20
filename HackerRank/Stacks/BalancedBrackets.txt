import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
        
    public static String[] stackA;
    public static int szA = 0;
    public static boolean balanced = true;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            balanced = true;
            szA = 0;
            String s = in.next();
            int n = s.length();
            
            stackA = new String[n];
            for(int i = 0; i < n; i++){
                String s1 = s.substring(i, i+1);
                if(s1.equals("(") || s1.equals("[") || s1.equals("{") ){
                    push(s1);
                }else if(s1.equals(")") || s1.equals("]") || s1.equals("}")){
                    if(szA==0 || !pairs(s1)){
                        balanced = false;
                        break;
                    }else{
                        pop();
                    }
                }
            }
            if(!balanced || szA != 0){
                System.out.println("NO");
            }else{
                System.out.println("YES");            
            }
        }
    }
    
    public static boolean pairs(String x){
        if(  peek().equals("(") && x.equals(")")  ){
            return true;
        }else if(peek().equals("[") && x.equals("]")){
            return true;
        }else if(peek().equals("{") && x.equals("}")){
            return true;
        }
        return false;
    }
    
    public static void push(String x){
        stackA[szA] = x;
        szA++;
    }
    public static String pop(){
        szA--;
        return stackA[szA];
    }
    public static String peek(){
        return stackA[szA -1];
    }
}
