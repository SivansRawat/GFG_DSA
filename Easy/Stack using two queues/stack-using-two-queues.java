//{ Driver Code Starts
import java.util.*;


class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}


// } Driver Code Ends



class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	   //  static Queue<Integer> q1
    //         = new LinkedList<Integer>();
    //     static Queue<Integer> q2
    //         = new LinkedList<Integer>();
    
     q2.add(a);
 
            // Push all the remaining
            // elements in q1 to q2.
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }
 
            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
    
            
            
	    
	    
	    
	    
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    
	   // if (q1.isEmpty())
    //             return;
    //         int m = q1.remove();
    
    // q1.remove();
            
            
        if (q1.isEmpty())
                return -1;
            return q1.remove();
    }
	
}

