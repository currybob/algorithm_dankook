
public class SelectionSortTest {

	public static void main(String[] args) {
		int arr[] = {100, 30, 20, 10, 50, 70, 40, 90, 80, 60};
		for(int i=0; i<10; i++)
			System.out.print("  " + arr[i]);
		
		System.out.println();
		SelectionSort(arr, 10);
		
		for(int i=0; i<10; i++)
			System.out.print("  " + arr[i]);		
	}
	static void SelectionSort(int a[], int n) 
	// Sort the array a[1:n] into nondecreasing order. 
	{ 
		for (int i=0; i<n; i++) { 
			int j = i; 
			for (int k=i+1; k<n; k++) 
			     if (a[k]<a[j]) j=k; 
			int t = a[i]; a[i] = a[j]; a[j] = t; 
		}
	 } 
}
