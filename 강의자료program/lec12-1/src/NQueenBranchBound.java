
public class NQueenBranchBound {

	private	int col[] ;
	private int n;
	
	public NQueenBranchBound(int size)
	{
	    n = size ;
		col = new int[n+1] ;

		queens() ;  // n-queens 문제를 호출
	}

	private void queens()
	{
		int j, k ;
		int level = 0 ;

	    que Q = new que();
		Q.Add(level) ;

		while( !Q.Empty() ) {      // 큐가 빌 때까지 반복
	        level = Q.Delete() ;   // 큐에서 레벨 삭제
			for (j = 1; j <= level ; j++ ) col[j] = Q.Delete() ;   // 레벨까지 값 삭제

			// 자식 노드들의 생성
			level++ ;  
			
			for (j = 1; j <= n ; j++) {   // 각각의 자식을 생성한다. 
			    col[level] = j ;          // 하나의 자식 생성

			    if (promising(level)) {    // 제약조건 확인
				    if ( level == n ) {
					    for ( k = 1; k <= n ; k++ )    // 해답 노드인 경우
					    	System.out.print(col[k] + "  ") ;
					    System.out.println() ;
					}
					else {
						Q.Add(level) ;      // 해답 노드는 아니나 살아있는 노드인 경우
		            	for (k = 1; k <= level ; k++ ) Q.Add(col[k]) ;   // 큐에 삽입
			       	}
				}  // end of if
			}  // end of for 
		}   // end of while
	}

	private boolean promising(int i)    // 제약조건 확인 함수
	{
		int k = 1 ;
		boolean sw = true ;

		while ( k < i && sw ) {
			if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i-k )
				sw = false ;
			k++ ;
		}
		return sw ;
	}

}
