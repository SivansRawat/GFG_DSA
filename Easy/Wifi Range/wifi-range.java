//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        
        
        boolean flag = true;
        
        for(int i=0;i<N;i++){
            
            // if((S.substring(i-X,i+1).contains("1")) == false && (S.substring(i,i+X+1).contains("1")== false)){
            //     flag = false;
            // }
            
            // 2,5
            if(i<X){
                
                if((((S.substring(0,i+1)).contains("1")) == false) && (((S.substring(i,i+X+1)).contains("1")) == false)){
                    
                    return false;
                }
            }
            
            else if(i>=N-X){
                
                if((((S.substring(i-X,i+1)).contains("1")) == false) && (((S.substring(i,N)).contains("1")) == false)){
                    
                    return false;
                }
            }
            
            else{
                
                if((((S.substring(i-X,i+1)).contains("1")) == false) && (((S.substring(i,i+X+1)).contains("1")) == false)){
                    
                    return false;
                }
            }
        }
        
        
        return true;
        // int count =0;
        
        // for(int i=X+2;i<=N-X-1;i=i+X+2){
            
        //     String str = S.substring(i,i+X+3);
        //     String str1 = S.substring(i+X+2,i+X+5);
        //     // System.out.println(str);
        //     if (str.contains("1")== false || str1.contains("1") == false){
                
        //         count++;
        //         // System.out.print("Count:");
        //         // System.out.println(count);
        //         flag = false;
        //         break;
        //     }
        // }
        
        
        // if(S.substring(N-X-1).contains("1") == false){
            
        //     flag = false;
        // }
        
        
        // return flag;
        
        
        
        
        // int i=0,j=0;
        
        // while(j<N){
            
        //     if(j-i+1<(X+1)){
                
        //         j++;
        //     }
            
            
        //     else if(j-i+1 ==(X+1)){
                
        //         if(S.substring(i,j+1).contains("1") ==  false){
                    
        //             flag = false;
        //             break;
                    
        //         }
        //         j++;
        //         i++;
        //     }
        // }
        
        // return flag;
        
        
        
        
        
        
        // code here
    }
} 