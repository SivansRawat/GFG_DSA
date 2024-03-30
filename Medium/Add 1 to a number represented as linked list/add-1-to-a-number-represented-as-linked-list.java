//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends




/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/
class Solution
{
    public static Node addOne(Node head) 
    { 
        if(head == null) return new Node(1);
      Node newhead = reverse(head);
        int carry = 1;
        int sum = 0;
        Node node = newhead;
        
        while(node != null){
            sum = node.data + carry;
            if(sum < 9){
                node.data = sum;
                carry = 0;
            }else{
                node.data  = sum  % 10;
                 carry = sum  / 10;
            }
            if(node.next == null && carry > 0){
                Node n = new Node(sum /10);
                node.data = sum % 10;
                node.next = n;
                node = node.next;
            }
            node = node.next;
        }
        
         return reverse(newhead);
    }
    static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
}