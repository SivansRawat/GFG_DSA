//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        int i=0;
        Stack<Integer> st = new Stack<>();
        Node current = odd;
        Node prev = null;
        while(current.next!=null){
            prev = current;
            current = current.next;
             i++;
            if(i%2!=0){
                st.add(current.data);
                prev.next = current.next;
               
                
            }
           
        
        }
       while(st.size()>0){
           Node temp = new Node(st.pop());
           if(prev.next!=null){
               current.next = temp;
               current = temp;
           }
           else {
           prev.next = temp;
           
           prev = temp;
           }
       }
      
    }
    
    
    
}
