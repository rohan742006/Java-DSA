public class doubly {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void add_f(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    //remove
    public int delete_1st(){
        if(head==null){
            System.out.print("doubly linked list is empty");
            return Integer.MIN_VALUE;
        }

        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    //print
    public void print(){
        Node temp=head;
        //System.out.print("Null-->");
        while(temp!=null){
            System.out.print(temp.data+"<--> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    public void add_last(int data){
        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        newNode.next=null;
        tail=newNode;
    }

    public void remove_last(){
        if(size==0){
            System.out.print("doubly is empty");
            return;
        }
        else if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        else{
            Node temp=head;
            for(int i=0;i<size-2;i++){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
            size--;
        }
    }

    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String args[]){
        doubly ll=new doubly();
        ll.add_f(3);
        ll.add_f(4);
        ll.add_f(5);
        ll.add_f(6);
        //ll.delete_1st();
        ll.add_last(2);
        //ll.remove_last();
        System.out.println("Original doubly list ");
        ll.print();
        System.out.println("reversed doubly list: ");
        ll.reverse();
        ll.print();
        System.out.print("Size of doubly linked list is:"+ll.size);
    }
}
