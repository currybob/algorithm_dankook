
public class BinSearch1Test {

	public static void main(String[] args) {
		
		int index, val ;
		int arr[] = {10, 17, 25, 30, 45, 53, 60, 77, 86, 95};
		
		System.out.print("배열 arr[] =");
		for(int i=0; i<10; i++)
			System.out.print("  " + arr[i]);
		System.out.println();
		
		for(int i=0; i<10; i++) {
			val = arr[i];
		    index = BinSrch(arr, 0, 9, val);
			System.out.println(val + " 는 " + index + " 번째 값입니다.");	
		}
	}

	static int BinSrch(int a[], int i, int l, int x) 
	// Given an array a[i:l] of elements in nondecreasing 
	// order, 1<=i<=l, determine whether x is present, and 
	// if so, return j such that x == a[j]; else return 0. 
	{ 
		if (l==i) { // If Small(P) 
			if (x==a[i]) return i; 
			else return 0; 
		} 
		else { // Reduce P into a smaller subproblem. 
			int mid = (i+l)/2; 
			if (x == a[mid]) return mid; 
			else if (x < a[mid]) return BinSrch(a,i,mid-1,x); 
			else return BinSrch(a,mid+1,l,x); 
		}
	}
}
