//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    
    
    ArrayList<String> list = new ArrayList<String>();
    public List<String> find_permutation(String S) {
        permute(S,0,S.length()-1);
        Collections.sort(list);
        return list;
    }
    
    public void permute(String S,int l,int r){
    if (l == r)
            return;
        else {
            for (int i = l; i <= r; i++) {
                S = swap(S, l, i);
                if(!list.contains(S))
                list.add(S);
                
                permute(S, l + 1, r);
                S = swap(S, l, i);
                if(!list.contains(S))
                list.add(S);
                
    }
        }
       
    }
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}