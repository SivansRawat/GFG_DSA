//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	
	
	public:
	void shuffleArray(int arr[],int n)
	{
	    // Your code goes here
	     vector<int> vt;
	  int mid=(n-1)/2;
	  int i=0,j=mid+1;
	  while(i<mid){
	      vt.push_back(arr[i]);
	      vt.push_back(arr[j]);
	      i++;
	      j++;
	  }
	  vt.push_back(arr[mid]);
	  vt.push_back(arr[n-1]);
	  for(int i=0;i<n;i++){
	      arr[i]=vt[i];
	  }
	}
		 

};


//{ Driver Code Starts.


int main() 
{
   
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
	    cin>>n;
	    int a[n] ;
	    for(int i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }


       

        Solution ob;
        ob.shuffleArray(a, n);

		for (int i = 0; i < n; i++) 
			cout << a[i] << " ";
    
	
        
	    cout << "\n";
	     
    }
    return 0;
}
// } Driver Code Ends