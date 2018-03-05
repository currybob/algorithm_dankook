
public class TVSClass {     // 트리 표현 대신 그래프 표현을 사용한다.

	private int w[][] ;     // 가중치 인접행렬
	private int d[] ;
	private int numVertex ; // 정점의 수
	private int root ;      // 맨 첫 시작정점(루트)
		
	public TVSClass (int n) {
		numVertex = n ;
		w = new int [n+1][n+1] ;      // 정점번호는 1 에서 n 까지 사용
		d = new int [n+1] ;           // 정점번호 0 은 사용하지 않음 (교재 그림 참조)
		for (int i=1; i<=n; i++) {     
			d[i] = 0;				   // 배열 d 의 초기화
			for (int j=1; j<=n ; j++)  // 인접행렬의 초기화
				w[i][j] = 0 ;
		}
	}
	
	public void addW(int u, int v, int weight) {
		w[u][v] = weight ;
	}
	
	public void startTVS(int start, int delta) {
		root = start ;
		System.out.println("<< 분할 정점들 >> ") ;
		TVS(start, 0, delta) ;  // 0은 부모 정점이 없음 나타냄
	}
	
	void TVS(int T, int p, int delta)
	// Determine and output the nodes to be split.
	// w is the weighting adjacent matrix for the edges.
	{
	   if ( T != 0 ) {  // T 가 0 이면 자식이 없음을 의미
		   d[T] = 0 ;
	  	   for (int v = 1; v <= numVertex; v++) {
	  		   if (w[T][v] != 0) {        // 자식이 존재할 때
		           TVS(v, T, delta);
	  		       if (d[v]+w[T][v] > d[T])
	  		    	   d[T] = d[v]+w[T][v] ;
	  		   }
		   }
		   if ((T != root) && (d[T]+w[p][T] > delta)) {
			    System.out.println("정점 : "+ T) ;
	            d[T] = 0 ;
		   }
		}
	}
}
