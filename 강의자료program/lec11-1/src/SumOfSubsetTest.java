
public class SumOfSubsetTest {

	public static void main(String[] args) {
		int n = 6 ;     // 수들의 갯수, 교재의 예
		int m = 30;     // m 의 값
		int w[] = new int[n+1] ;
		
		w[1] = 5  ;   w[2]= 10  ;    // 오름차순으로 주어져야만 한다.
		w[3] = 12 ;   w[4]= 13  ;		
		w[5] = 15 ;   w[6]= 18  ;
		
		SumOfSubsetClass nq = new SumOfSubsetClass(w, n, m) ;
	}

}
