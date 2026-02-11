package Activities.Activity1Feb10;

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data=data;
        this.next=null;
    }
}
class SinglyLinkedList{
    Node head;
      
      public  void insertAtBeginning(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
        public void insertAtEnd(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
       public void traverse(){
        Node temp=head;

        if (temp==null) {
            System.out.println("List is empty");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + "  ");
            temp=temp.next;
        }
        System.out.println();
    }
       public boolean search(int key) {
        Node temp=head;
        while(temp!=null) {
            if(temp.data==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
      public  void reverse(){
        Node prev=null;
        Node curr=head;
        Node next=null;
        while (curr!=null) {
            next=curr.next;   
            curr.next=prev;   
            prev=curr;        
            curr=next;        
        }
        head=prev;
    }
}



public class SinglyLinkedListImplementationTaskC{
  public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.traverse();   

        System.out.println(list.search(30)); 
        System.out.println(list.search(50)); 

        list.reverse();
        list.traverse(); 
    }
}