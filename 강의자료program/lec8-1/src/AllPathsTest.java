
public class AllPathsTest {

	public static void main(String[] args) {
		int numV = 3 ;    // 정점의 수
		float adjMat[][] = new float[numV+1][numV+1] ;  // 정점번호가 1부터 시작. 정점 0은 사용하지 않음
		float A[][] = new float[numV+1][numV+1] ;
		
		for(int i=1; i<=numV; i++) {   // 가중치 인접행렬의 초기화
			for (int j=1; j<=numV; j++)
				adjMat[i][j] = Integer.MAX_VALUE ;
			adjMat[i][i] = 0;
		}

		adjMat[1][2] = 4;    // 교재의 그래프 입력
		adjMat[1][3] = 11;
		adjMat[2][1] = 6;
		adjMat[2][3] = 2;
		adjMat[3][1] = 3;
		
		AllPaths(adjMat, A, numV);    // 최단 경로 함수를 호출 
		
		System.out.print("정점 : ");
		for (int i=1; i<=numV; i++)
			System.out.print(" " + i + "  ");
		System.out.println();
	    for (int i=1; i<=numV; i++) {    // 최단 경로의 비용을 출력
	    	System.out.print("  "+ i + " :");
		    for (int j=1; j<=numV; j++)
		        System.out.print(" " + A[i][j]); 
		    System.out.println();
	    }
	}
	
	static void AllPaths(float cost[][], float A[][], int n)
	   // cost[1:n][1:n] is the cost adjacency matrix of
	   // a graph with n vertices; A[i][j] is the cost
	   // of a shortest path from vertex i to vertex j.
	   // cost[i][i] = 0.0, for 1 <= i <= n.
	   {
	      for (int i=1; i<=n; i++)
	         for (int j=1; j<=n; j++)
	            A[i][j] = cost[i][j]; // Copy cost into A.
	      for (int k=1; k<=n; k++)
	         for (int i=1; i<=n; i++)
	            for (int j=1; j<=n; j++)
	            	if (A[i][k]+A[k][j] < A[i][j] )
	            		A[i][j] = A[i][k]+A[k][j] ;
	   }

}
