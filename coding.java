import java.util.*;
public class coding{
    public static String reverse(String str){
        Stack<Character>s=new Stack<>();
        int idx=0;
        while(idx<s.length()){
            s.push(s.charAt(idx));
            idx++;
        }

        StringBuilder sb=new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        String str="rohan";
        System.out.print(reverse(str));
    }
}