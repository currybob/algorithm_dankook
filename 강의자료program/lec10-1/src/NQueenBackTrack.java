import java.lang.Math ;

public class NQueenBackTrack {  // 퇴각검색으로 n-queen 문제를 해를 구한다.

	private	int col[] ;
	private int n;
	
	public NQueenBackTrack(int size)
	{
	    n = size ;
		col = new int[n+1] ;

		queens(1) ;  // n-queens 문제를 호출
	}

	private void queens(int k)
	{
		int i, j ;

		for ( i = 1; i <= n ; i++) {
			col[k] = i ;
			if (promising(k)) {    // 제약조건 확인
				if ( k == n ) {
					for ( j = 1; j <= n ; j++ )
						 System.out.print(col[j] + "  ") ;
					System.out.println() ;
				}
			    else
			        queens(k+1)  ;     // 다음 행을 순환 호출
			}
		}
	}

	private boolean promising(int k)    // 제약조건 확인 함수
	{
		int i = 1 ;
		boolean sw = true ;

		while ( i < k && sw ) {
			if (col[k] == col[i] || Math.abs(col[k] - col[i]) == k-i )
				sw = false ;
			i++ ;
		}
		return sw ;
	}

}
