
public class BinSearch3Test {

	public static void main(String[] args) {
		int index, val ;
		int arr[] = {10, 17, 25, 30, 45, 53, 60, 77, 86, 95};
		
		System.out.print("배열 arr[] =");
		for(int i=0; i<10; i++)
			System.out.print("  " + arr[i]);
		System.out.println();
		
		for(int i=0; i<10; i++) {
			val = arr[i];
		    index = BinSearch1(arr, 10, val);
			System.out.println(val + " 은 " + index + " 번째 값입니다.");	
		}
	}

	static int BinSearch1(int a[], int n, int x) 
	// Same specifications as BinSearch except n > 0 
	{
	   int low=0, high=n; 
	   // high is one more than possible. 
	   while (low < (high-1)) { 
			int mid = (low + high)/2; 
			if (x < a[mid]) high = mid; // Only one comparison 
						     // in the loop 
			else low = mid; // x >= a[mid] 
	    } 
	    if (x == a[low]) return(low); // x is present. 
	    else return(-1); // x is not present. 
	}
	
}
