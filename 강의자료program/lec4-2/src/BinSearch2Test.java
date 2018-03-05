
public class BinSearch2Test {

	public static void main(String[] args) {
		int index, val ;
		int arr[] = {10, 17, 25, 30, 45, 53, 60, 77, 86, 95};
		
		System.out.print("배열 arr[] =");
		for(int i=0; i<10; i++)
			System.out.print("  " + arr[i]);
		System.out.println();
		
		for(int i=0; i<10; i++) {
			val = arr[i];
		    index = BinSearch(arr, 10, val);
			System.out.println(val + " is " + index + " 번째 값입니다.");	
		}
	}

	static int BinSearch(int a[], int n, int x) 
	// Given an array a[0:n-1] of elements in nondecreasing 
	// order, n>=0, determine whether x is present, and 
	// if so, return j such that x == a[j]; else return -1. 
	{ 
		int low = 0, high = n-1; 
		while (low <= high){ 
			int mid = (low + high)/2; 
			if (x < a[mid]) high = mid - 1; 
			else if (x > a[mid]) low = mid + 1; 
			else return mid; 
		} 
		return -1; 
	} 
	
}
