
public class SumOfSubsetClass {

	private	int w[] ;
	private int x[] ;
	private int n, m;
	
	public SumOfSubsetClass(int arr[], int vofn, int vofm) {
		w = arr;
		n = vofn;
		m = vofm;
		x = new int [n+1];
		
		int sum = 0 ;
		for (int i=1; i<=n; i++) {
			x[i] = 0 ;			 // x[i] 의  초기화
			sum += w[i] ;        // w[i] 값들의 합을 구한다.
		}
		System.out.println("부분집합의 해: ");
		SumOfSub(0, 1, sum) ;    // SumOfSub 함수의 첫 호출
	}
	
	private void SumOfSub(float s, int k, float r) {
	      // Generate left child. Note that s+w[k] <= m
	      // because B_{k-1} is true.
	      x[k] = 1;
	      if (s+w[k] == m) { // Subset found
	         for (int j=1; j<=k; j++) System.out.print(x[j]+" ") ;
	         System.out.println();
	      }
	          // There is no recursive call here
	          // as w[j] > 0, 1 <= j <= n.
	      else if (s+w[k]+w[k+1] <= m)
	              SumOfSub(s+w[k], k+1, r-w[k]);
	      // Generate right child and evaluate B_k.
	      x[k] = 0;
	      if ((s+r-w[k] >= m) && (s+w[k+1] <= m)) {
	         SumOfSub(s, k+1, r-w[k]);
	      }
	   }
}
