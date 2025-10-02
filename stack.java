import java.util.*;
public class stack{
    public static boolean valid_parenthesis(String str){
        Stack<Character>s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            //if openign brackett push to stack
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch);
            }
            else{   //closing brackett
                if(s.isEmpty()){  //if there is nothing at opening end
                    return false;
                }
                //chec if top of stack matches
                if((s.peek()=='(' && ch==')')||
                (s.peek()=='{' && ch=='}')||
                (s.peek()=='[' && ch==']')){
                s.pop();  //match found then remove opening
            }
            else{
                return false;  //mismatch
        }
            }
        }
        if(s.isEmpty()){  //final check stack is empty
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean duplicate_parentheses(String str){
        Stack<Character>s=new Stack<>();
        //iterate
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch!=')'){         //push evrything except ')'
                s.push(ch);
            }
                
            else{    //handle closing parenthesis
                int count=0;
                while(s.peek()!='('){   //pop until we get '('
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicate
                }
                else{
                    s.pop();  //pop the () as we have to check next
                }
        }
    }
        return false;  //no duplicate found
    }
    public static void main(String args[]){
        //String str="({})[]";
        //System.out.print(valid_parenthesis(str));
        String str="(a+b)";
        System.out.print(duplicate_parentheses(str));
    }
}








