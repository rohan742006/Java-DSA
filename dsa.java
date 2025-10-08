import java.util.*;
public class dsa {

    static class Node{
        char data;
        Node next;

        public Node(char data){
            this.data=data;
            this.next=null;
        }
    }
        public static Node head;
        public static Node tail;
        
        public static void addlast(char data){
            Node newNode=new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

    public static boolean palindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node curr=mid(head);
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        //compare both halves
        Node left=head;
        Node right=prev;

        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static String simplifypath(String path){
        //rules: absolute path always starts with /
        //. current directory
        //.. go to parent directory
        // treat it as single /
        Stack<String>stack=new Stack<>();
        String parts[]=path.split("/");  //each thing is splitted
        for(int i=0;i<parts.length;i++){
            String part=parts[i];

            if(part.equals("")||part.equals(".")){
                continue;  //move to next
            }

            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();   //remove last added directory
                }
            }
            else{
                stack.push(part);
            }
        }
        return "/"+String.join("/",stack);
    }
    public static Node mid(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.next;
    }
    public static void main(String args[]){
        /*addlast('a');
        addlast('b');
        addlast('b');
        addlast('a');
        if(palindrome(head)){
            System.out.print("List is Palindrome");
        }
        else{
            System.out.print("List is not Plaindrome");
        }*/

        System.out.print(simplifypath("/apnacollege/"));
    }
}
