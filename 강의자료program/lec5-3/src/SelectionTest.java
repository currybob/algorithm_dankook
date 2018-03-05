
public class SelectionTest {

	public static void main(String[] args) {
		int arrSize = 16 ;    // 배열의 크기
		int arr[] = new int[arrSize+2];
		
		for(int i=1; i<= arrSize; i++) 
			arr[i] = (int)(java.lang.Math.random()*99);  //테스트 데이터 생성

		System.out.println("선택 전:");
		for(int i=1; i<= arrSize; i++)
			System.out.print("  " + arr[i]);   // 선택 전의 데이터 값들
		System.out.println(); 
		
		Select1(arr, arrSize, 10);   // k = 10 번째 원소를 선택

		System.out.println("k=10 번째 값을 선택 후:");
		for(int i=1; i<= arrSize; i++)
			System.out.print("  " + arr[i]);	// 선택 후의 데이터 값들	 	
	}

	static void Select1(int a[], int n, int k)
	   // Selects the kth-smallest element in a[1:n] and
	   // places it in the kth position of a[]. The
	   // remaining elements are rearranged such that
	   // a[m] <= a[k] for 1 <= m < k, and
	   // a[m] >= a[k] for k < m <= n.
	   {
	       int low=1, up=n+1;
	       a[n+1] = Integer.MAX_VALUE ; // a[n+1] is set to infinity.
	       do { // Each time the loop is entered,
	              // 1<=low<=k<=up<=n+1.
	          int j = Partition(a, low, up);
	              // j is such that a[j] is the
	              // jth-smallest value in a[].
	          if (k == j) return;
	          else if (k < j) up = j; // j is the new upper limit.
	          else low = j+1; // j+1 is the new lower limit.
	       } while (true);
	   }
	
	static int Partition(int a[], int m, int p)
	   // Within a[m], a[m+1],..., a[p-1] the elements
	   // are rearranged in such a manner that if
	   // initially t==a[m], then after completion
	   // a[q]==t for some q between m and p-1, a[k]<=t
	   // for m<=k<q, and a[k]>=t for q<k<p. q is returned.
	   {
	       int v=a[m]; int i=m, j=p;
	       do {
	              do i++;
	              while (a[i] < v);
	              do j--;
	              while (a[j] > v);
	              if (i < j) Interchange(a, i, j);
	          } while (i < j);
	          a[m] = a[j]; a[j] = v; return(j);
	   }
	 
	 static void Interchange(int a[], int i, int j){
		 int temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	 }    
}
